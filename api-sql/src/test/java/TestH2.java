import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dev.jwall64.mdcfg.ConfigSection;
import dev.jwall64.mdcfg.serializer.ConfigContext;
import dev.jwall64.mdcfg.sql.DatabasePreset;
import dev.jwall64.mdcfg.sql.PresetRegistry;
import dev.jwall64.mdcfg.sql.SQLConnection;

public class TestH2 {

    @Test
    public void testH2() {

        SQLConnection conn = Common.getDBType("h2").create("h2/test");
        Common.testAll(conn);
        conn.close();
    }

    @Test
    public void testH2Prefixed() {

        SQLConnection conn = Common.getDBType("h2").create("h2/test", null, null, "pre_", new ConfigSection());
        Common.testAll(conn);
        conn.close();
    }

    @Test
    public void testPreset() {

        PresetRegistry reg = PresetRegistry.SERIALIZER.deserialize(ConfigContext.INSTANCE, new ConfigSection()
                .with("repository", new ConfigSection()
                        .with("type", "maven")
                        .with("folder", "drivers")
                )
                .with("presets", new ConfigSection()
                        .with("default", new DatabasePreset("h2", "h2/test", null, null, null, null, new ConfigSection()), DatabasePreset.SERIALIZER)
                )
        ).getOrThrow();

        try {
            reg.connect(new ConfigSection().with("preset", "default")).thenAccept(Common::testAll).get();
            reg.connect(new ConfigSection().with("preset", "default").with("table_prefix", "pre_")).thenAccept(Common::testAll).get();
        } catch (Exception ex) {
            Assertions.fail(ex);
        }
    }
}
