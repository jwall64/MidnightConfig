import org.junit.jupiter.api.Test;
import dev.jwall64.mdcfg.sql.DatabaseType;
import dev.jwall64.mdcfg.sql.SQLConnection;

public class TestMariaDB {

    @Test
    public void testMySQL() {

        String url = System.getenv("TEST_MARIADB_URL");
        String user = System.getenv("TEST_MARIADB_USER");
        String pass = System.getenv("TEST_MARIADB_PASS");

        if(url != null && user != null && pass != null) {

            DatabaseType type = DatabaseType.MARIADB;
            try(SQLConnection conn = type.create(url, user, pass)) {

                Common.testBasics(conn);
                Common.testNumberTypes(conn);
                Common.testStringTypes(conn);
                Common.testWhere(conn);

            }

        }

    }

}
