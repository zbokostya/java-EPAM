package bsu.by.zbokostya.DAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public abstract class Dao<E> {
    static Logger log = LogManager.getLogger();


    private ArrayList<E> data;
    private Connection connection;
    protected Statement statement;
    private String tableName;
    private String sql;
    private String insertSql;
    private String deleteSql;
    private String updateSql;
    protected ResultSet sqlResponse;

    {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:54320/epam";
            Properties properties = new Properties();
            properties.setProperty("user", "zbokostya");
            properties.setProperty("password", "123");

            connection = DriverManager.getConnection(url, properties);
        } catch (SQLException | ClassNotFoundException e) {
            log.error("Connection Failed! Check output console");
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao() {
        this.data = new ArrayList<E>();
    }

    public int create(E e) { //return last inserted id
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement = prepareInsert(preparedStatement, e);
            preparedStatement.executeUpdate();
            ResultSet cnt = preparedStatement.getGeneratedKeys();
            cnt.next();
            return cnt.getInt(1);
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
        return 0;
    }

    public void delete(String id) {
        final StringBuilder str = new StringBuilder();
        str.append("\'");
        str.append(id);
        str.append("\'");
        try {
            statement.executeUpdate(deleteSql + str);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    public void delete(String email, long eventId) {
        final StringBuilder str = new StringBuilder();
        str.append("\'");
        str.append(email);
        str.append("\'");
        str.append(" AND event id =" + eventId);
        try {
            statement.executeUpdate(deleteSql + str);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    public void delete(long id) {
        try {
            statement.executeUpdate(deleteSql + id);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    public void update(E e) {
        try {
            statement.executeUpdate(makeUpdateQuery(e));
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    public void read() {
        sql = "select * from " + tableName;
        try {
            sqlResponse = statement.executeQuery(sql);
            while (sqlResponse.next()) {
                data.add(makeEntity(sqlResponse));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public E readById(int id) {
        sql = "select * from " + tableName + " WHERE id = " + id;
        try {
            sqlResponse = statement.executeQuery(sql);
            if(sqlResponse.next()) {
                return makeEntity(sqlResponse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public abstract String makeUpdateQuery(E e);

    public abstract PreparedStatement prepareInsert(PreparedStatement preparedStatement, E e);

    public abstract E makeEntity(ResultSet sqlResponse);

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setInsertSql(String insertSql) {
        this.insertSql = insertSql;
    }

    public void setDeleteSql(String deleteSql) {
        this.deleteSql = deleteSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = updateSql;
    }

    public ArrayList<E> getData() {
        return data;
    }

    public String getDeleteSql() {
        return deleteSql;
    }
}
