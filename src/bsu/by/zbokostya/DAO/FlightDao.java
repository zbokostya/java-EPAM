package bsu.by.zbokostya.DAO;

import bsu.by.zbokostya.entity.Flight;
import bsu.by.zbokostya.entity.Plane;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightDao extends Dao<Flight> {

    private PlaneDao planeDao;
    private RouteDao routeDao;
    {
        setTableName("flight");
        setInsertSql("INSERT INTO flight " +
                "(plane_serial, route_id, date_out)" +
                "VALUES(?,?,?)");
        setDeleteSql("DELETE FROM flight WHERE flight_id = ");
    }
    @Override
    public String makeUpdateQuery(Flight flight) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE flight");
        stringBuilder.append("set plane_serial = '").append(flight.getPlane().getId()).append("',");
        stringBuilder.append("route_id = '").append(flight.getRoute()).append("',");
        stringBuilder.append("date_out = '").append(flight.getDate()).append("',");
        stringBuilder.append("WHERE flight_id = '").append(flight.getId()).append("'");
        return stringBuilder.toString();
    }

    @Override
    public PreparedStatement prepareInsert(PreparedStatement preparedStatement, Flight flight) {
        try {
            preparedStatement.setInt(1, flight.getPlane().getId());
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
            flight.setId(sqlResponse.getInt("flight_id"));
            flight.setPlane(planeDao.makeEntity(statement.executeQuery("select * from plane WHERE serial_number = " + sqlResponse.getInt("flight_plane_serial_number"))));
            flight.setRoute(routeDao.makeEntity(statement.executeQuery("select * from route WHERE id = " + sqlResponse.getInt("flight_route_id"))));
            flight.setDate(sqlResponse.getDate("flight_date_out"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }
}
