package dev.jwall64.mdcfg.sql.stmt;

import dev.jwall64.mdcfg.sql.Condition;
import dev.jwall64.mdcfg.sql.SQLConnection;
import dev.jwall64.mdcfg.sql.SQLUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete extends DMLStatement {

    public final String table;
    public Condition where;

    public Delete(SQLConnection connection, String table) {
        super(connection);
        SQLUtil.validate(table);
        this.table = table;
    }

    public Delete where(Condition where) {
        this.where = where;
        return this;
    }

    @Override
    public int[] execute() {

        StringBuilder out = new StringBuilder("DELETE FROM ").append(table);
        if(where != null) {
            out.append(" WHERE ").append(where.encode());
        }
        out.append(";");

        try(PreparedStatement stmt = connection.getInternal().prepareStatement(out.toString())) {

            if(where != null) {
                where.writeArguments(stmt, 1);
            }
            return stmt.executeBatch();
        } catch (SQLException ex) {
            throw new IllegalStateException("Unable to execute DELETE statement!");
        }
    }
}
