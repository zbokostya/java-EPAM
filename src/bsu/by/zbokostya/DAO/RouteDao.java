package bsu.by.zbokostya.DAO;

import bsu.by.zbokostya.entity.Route;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RouteDao extends Dao<Route> {
    {
        setTableName("route");
        setInsertSql("INSERT INTO route " +
                "(city_out, city_in)" +
                "VALUES(?,?)");
        setDeleteSql("DELETE FROM route WHERE route_id = ");
    }

    @Override
    public String makeUpdateQuery(Route route) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE route");
        stringBuilder.append("set city_out = '").append(route.getCityOut()).append("',");
        stringBuilder.append("city_in = '").append(route.getCityIn()).append("',");
        stringBuilder.append("WHERE route_id = '").append(route.getId()).append("'");
        return stringBuilder.toString();
    }

    @Override
    public PreparedStatement prepareInsert(PreparedStatement preparedStatement, Route route) {
        try {
            preparedStatement.setString(1, route.getCityOut());
            preparedStatement.setString(2, route.getCityIn());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    public Route makeEntity(ResultSet sqlResponse) {
        Route route = new Route();
        try {
            route.setId(sqlResponse.getInt("route_id"));
            route.setCityOut(sqlResponse.getString("plane_city_out").trim());
            route.setCityIn(sqlResponse.getString("plane_city_in").trim());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return route;
    }
}
