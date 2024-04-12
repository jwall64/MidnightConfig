package dev.jwall64.mdcfg.sql.stmt;

import dev.jwall64.mdcfg.sql.QueryResult;
import dev.jwall64.mdcfg.sql.SQLConnection;

public abstract class DQLStatement extends Statement {

    protected DQLStatement(SQLConnection connection) {
        super(connection);
    }

    public abstract QueryResult execute();

}
