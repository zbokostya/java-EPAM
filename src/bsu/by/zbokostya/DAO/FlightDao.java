package bsu.by.zbokostya.DAO;

import bsu.by.zbokostya.entity.Flight;
import bsu.by.zbokostya.entity.Plane;

import java.sql.*;

public class FlightDao extends Dao<Flight> {

    private PlaneDao planeDao = new PlaneDao();
    private RouteDao routeDao = new RouteDao();
    {
        setTableName("flight");
        setInsertSql("INSERT INTO flight " +
                "(plane_serial, route_id, date_out)" +
                "VALUES(?,?,?)" + " RETURNING id");
        setDeleteSql("DELETE FROM flight WHERE flight_id = ");
    }
    @Override
    public String makeUpdateQuery(Flight flight) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE flight");
        stringBuilder.append("set plane_serial = '").append(flight.getPlane().getSerialNumber()).append("',");
        stringBuilder.append("route_id = '").append(flight.getRoute().getId()).append("',");
        stringBuilder.append("date_out = '").append(flight.getDate()).append("',");
        stringBuilder.append("WHERE flight_id = '").append(flight.getId()).append("'");
        return stringBuilder.toString();
    }

    @Override
    public PreparedStatement prepareInsert(PreparedStatement preparedStatement, Flight flight) {
        try {
            preparedStatement.setString(1, flight.getPlane().getSerialNumber());
            preparedStatement.setInt(2, flight.getRoute().getId());
            preparedStatement.setDate(3, new java.sql.Date(flight.getDate().getTime()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    public Flight makeEntity(ResultSet sqlResponse) {
        Flight flight = new Flight();
        try {
            flight.setId(sqlResponse.getInt("id"));
            String str1 = sqlResponse.getString("plane_serial");
            int str2 = sqlResponse.getInt("route_id");
            Date str3 = sqlResponse.getDate("date_out");
            ResultSet set1 = statement.executeQuery("select * from plane WHERE serial_number = '" + str1 + "'");
            set1.next();
            flight.setPlane(planeDao.makeEntity(set1));
            ResultSet set = statement.executeQuery("select * from route WHERE id = " + str2);
            set.next();
            flight.setRoute(routeDao.makeEntity(set));
            flight.setDate(str3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }
}
