import org.junit.jupiter.api.Test;
import dev.jwall64.mdcfg.ConfigSection;
import dev.jwall64.mdcfg.sql.DatabaseType;
import dev.jwall64.mdcfg.sql.SQLConnection;

import java.io.File;

public class TestSQLite {

    @Test
    public void testSQLite() {

        SQLConnection conn = Common.getDBType("sqlite").create("sqlite/test");

        Common.testBasics(conn);
        Common.testNumberTypes(conn);
        Common.testStringTypes(conn);
        Common.testWhere(conn);

        conn.close();
    }


    @Test
    public void testSQLitePrefixed() {

        SQLConnection conn = Common.getDBType("sqlite").create("sqlite/test", null, null, "pre_", new ConfigSection());

        Common.testBasics(conn);
        Common.testNumberTypes(conn);
        Common.testStringTypes(conn);
        Common.testWhere(conn);

        conn.close();
    }


}
