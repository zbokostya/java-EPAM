package bsu.by.zbokostya.DAO;

import bsu.by.zbokostya.entity.Flight;
import bsu.by.zbokostya.entity.Ticket;
import bsu.by.zbokostya.service.PlaneService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDao extends Dao<Ticket> {
    private PlaneDao planeDao;
    private FlightDao flightDao;

    {
        setTableName("ticket");
        setInsertSql("INSERT INTO ticket " +
                "(cost, seat, flight_id, plane_id)" +
                "VALUES(?,?,?,?)" + " RETURNING id");
        setDeleteSql("DELETE FROM ticket WHERE ticket_id = ");
    }


    @Override
    public String makeUpdateQuery(Ticket ticket) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE ticket");
        stringBuilder.append("set cost = '").append(ticket.getCost()).append("',");
        stringBuilder.append("seat = '").append(ticket.getSeat()).append("',");
        stringBuilder.append("flight_id = '").append(ticket.getFlight().getId()).append("',");
        stringBuilder.append("plane_id = '").append(ticket.getPlane().getId()).append("'");
        stringBuilder.append("WHERE ticket_id = '").append(ticket.getId()).append("'");
        return stringBuilder.toString();
    }

    @Override
    public PreparedStatement prepareInsert(PreparedStatement preparedStatement, Ticket ticket) {
        try {
            preparedStatement.setInt(1, ticket.getCost());
            preparedStatement.setInt(2, ticket.getSeat());
            preparedStatement.setInt(3, ticket.getFlight().getId());
            preparedStatement.setInt(4, ticket.getPlane().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    public Ticket makeEntity(ResultSet sqlResponse) {
        Ticket ticket = new Ticket();
        try {
            ticket.setId(sqlResponse.getInt("id"));
            ticket.setCost(sqlResponse.getInt("cost"));
            ticket.setSeat(sqlResponse.getInt("seat"));
            ticket.setFlight(flightDao.makeEntity(statement.executeQuery("select * from flight WHERE id = " + sqlResponse.getInt("flight_id"))));
            ticket.setPlane(planeDao.makeEntity(statement.executeQuery("select * from plane WHERE id = " + sqlResponse.getInt("plane_id"))));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }
}
