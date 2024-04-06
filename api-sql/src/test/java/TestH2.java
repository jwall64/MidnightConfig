import org.junit.jupiter.api.Test;
import dev.jwall64.mdcfg.sql.DatabaseType;
import dev.jwall64.mdcfg.sql.SQLConnection;

import java.io.File;

public class TestH2 {

    @Test
    public void testH2() {

        File db = new File("test.h2");
        SQLConnection conn = DatabaseType.sqlite().create(db.getAbsolutePath());

        Common.testBasics(conn);

    }

}
