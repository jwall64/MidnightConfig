import org.junit.jupiter.api.Test;
import dev.jwall64.mdcfg.sql.DatabaseType;
import dev.jwall64.mdcfg.sql.SQLConnection;

import java.io.File;

public class TestSQLite {

    @Test
    public void testSQLite() {

        File db = new File("test.db");
        SQLConnection conn = DatabaseType.sqlite().create(db.getAbsolutePath());

        Common.testBasics(conn);

    }

}
