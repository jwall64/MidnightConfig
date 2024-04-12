package dev.jwall64.mdcfg.sql.stmt;

import dev.jwall64.mdcfg.sql.SQLConnection;

public abstract class DDLStatement extends Statement {

    protected DDLStatement(SQLConnection connection) {
        super(connection);
    }

    public abstract boolean execute();

}
