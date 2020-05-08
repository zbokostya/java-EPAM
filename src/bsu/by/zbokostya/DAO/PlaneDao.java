package bsu.by.zbokostya.DAO;

import bsu.by.zbokostya.entity.Plane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaneDao extends Dao<Plane> {
    {
        setTableName("plane");
        setInsertSql("INSERT INTO plane " +
                "(name, seat_number, company_id, serial_number)" +
                "VALUES(?,?,?,?)" + " RETURNING id");
        setDeleteSql("DELETE FROM plane WHERE plane_id = ");
    }


    @Override
    public String makeUpdateQuery(Plane plane) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE plane");
        stringBuilder.append("set name = '").append(plane.getName()).append("',");
        stringBuilder.append("seat_number = '").append(plane.getSeats()).append("',");
        stringBuilder.append("company_id = '").append(plane.getCompanyId()).append("',");
        stringBuilder.append("serial_number = '").append(plane.getSerialNumber()).append("'");
        stringBuilder.append("WHERE plane_id = '").append(plane.getId()).append("'");
        return stringBuilder.toString();
    }

    @Override
    public PreparedStatement prepareInsert(PreparedStatement preparedStatement, Plane plane) {
        try {
            preparedStatement.setString(1, plane.getName());
            preparedStatement.setInt(2, plane.getSeats());
            preparedStatement.setInt(3, plane.getCompanyId());
            preparedStatement.setString(4, plane.getSerialNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    public Plane makeEntity(ResultSet sqlResponse) {
        Plane plane = new Plane();
        try {
            plane.setId(sqlResponse.getInt("id"));
            plane.setName(sqlResponse.getString("name"));
            plane.setSeats(sqlResponse.getInt("seat_number"));
            plane.setCompanyId(sqlResponse.getInt("company_id"));
            plane.setSerialNumber(sqlResponse.getString("serial_number"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plane;
    }
}
