import org.junit.jupiter.api.Test;
import dev.jwall64.mdcfg.sql.DatabaseType;
import dev.jwall64.mdcfg.sql.SQLConnection;

import java.io.File;

public class TestSQLite {

    @Test
    public void testSQLite() {

        File db = new File("test.db");
        SQLConnection conn = Common.getDBType("sqlite").create(db.getAbsolutePath());

        Common.testBasics(conn);
        Common.testNumberTypes(conn);
        Common.testStringTypes(conn);
        Common.testWhere(conn);

        conn.close();
    }

}
