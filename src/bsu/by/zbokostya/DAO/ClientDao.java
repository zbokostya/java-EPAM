package bsu.by.zbokostya.DAO;

import bsu.by.zbokostya.entity.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientDao extends Dao<Client> {
    {
        setTableName("client");
        setInsertSql("INSERT INTO client " +
                "(plane_serial, route_id, date_out)" +
                "VALUES(?,?,?)");
        setDeleteSql("DELETE FROM flight WHERE flight_id = ");
    }
    @Override
    public String makeUpdateQuery(Client client) {
        return null;
    }

    @Override
    public PreparedStatement prepareInsert(PreparedStatement preparedStatement, Client client) {
        return null;
    }

    @Override
    public Client makeEntity(ResultSet sqlResponse) {
        return null;
    }
}
