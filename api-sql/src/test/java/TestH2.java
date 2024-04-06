import org.junit.jupiter.api.Test;
import dev.jwall64.mdcfg.sql.DatabaseType;
import dev.jwall64.mdcfg.sql.SQLConnection;

import java.io.File;

public class TestH2 {

    @Test
    public void testH2() {

        File db = new File("h2");
        SQLConnection conn = DatabaseType.h2(DatabaseType.ResourceType.FILE).create(db.getAbsolutePath());

        Common.testBasics(conn);
        Common.testNumberTypes(conn);
        Common.testWhere(conn);

        conn.close();
    }

}
