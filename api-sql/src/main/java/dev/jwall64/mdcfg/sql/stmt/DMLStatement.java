package dev.jwall64.mdcfg.sql.stmt;

import dev.jwall64.mdcfg.sql.SQLConnection;

public abstract class DMLStatement extends Statement {


    protected DMLStatement(SQLConnection connection) {
        super(connection);
    }

    public abstract int[] execute();

}
