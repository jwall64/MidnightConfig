package dev.jwall64.mdcfg.sql.stmt;

import dev.jwall64.mdcfg.sql.SQLConnection;

public abstract class Statement {

    protected final SQLConnection connection;
    protected Statement(SQLConnection connection) {
        if(!connection.isConnected()) {
            throw new IllegalArgumentException("Connection is not connected!");
        }
        this.connection = connection;
    }

}
