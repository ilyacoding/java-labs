package by.ilyacoding.servicehotels.dao;

import by.ilyacoding.servicehotels.bean.Entity;
import by.ilyacoding.servicehotels.bean.User;
import by.ilyacoding.servicehotels.connectionpool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilyacoding on 11/28/2017.
 */
public enum UserDAO implements AbstractDAO {
    INSTANCE;

    @Override
    public List findAll() throws SQLException {

        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM hotels_db.users");
        ResultSet resultSet = statement.executeQuery();
        List<User> usersList = new ArrayList<>();
        while(resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));
            usersList.add(user);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return usersList;
    }

    public boolean isAuthorized(String login, String password) throws SQLException{
        boolean isLogin = false;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT login, password FROM users WHERE login = ? AND password = ?");
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        if(result.next()){
            isLogin = true;
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return isLogin;
    }


    public User getUserByLogin(String login) throws SQLException{
        User user = null;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login = ?");
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return user;
    }

    @Override
    public void createEntity(Entity entity) throws SQLException {

    }
}
