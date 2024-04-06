import org.junit.jupiter.api.Assertions;
import dev.jwall64.mdcfg.ConfigSection;
import dev.jwall64.mdcfg.sql.ColumnType;
import dev.jwall64.mdcfg.sql.DatabaseType;
import dev.jwall64.mdcfg.sql.SQLConnection;
import dev.jwall64.mdcfg.sql.TableSchema;

import java.util.List;

public class Common {

    public static void testBasics(SQLConnection conn) {
        TableSchema schema = TableSchema.builder()
                .withColumn("id", ColumnType.SMALLINT)
                .withColumn("name", ColumnType.TINYTEXT)
                .build();

        if(conn.getTables().contains("test")) {
            conn.dropTable("test");
        }

        conn.createTable("test", schema);

        conn.insert("test", schema, new ConfigSection().with("id", 1).with("name", "Test User"));

        List<ConfigSection> results = conn.select("test", schema);

        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(1, results.get(0).getByte("id"));
        Assertions.assertEquals("Test User", results.get(0).getString("name"));
        conn.close();
    }

}
