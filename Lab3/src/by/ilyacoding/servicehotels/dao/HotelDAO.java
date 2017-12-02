package by.ilyacoding.servicehotels.dao;

import by.ilyacoding.servicehotels.bean.Entity;
import by.ilyacoding.servicehotels.bean.Hotel;
import by.ilyacoding.servicehotels.bean.User;
import by.ilyacoding.servicehotels.connectionpool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilyacoding on 11/17/2017.
 */
public enum HotelDAO implements AbstractDAO<Hotel> {
    INSTANCE;

    @Override
    public List<Hotel> findAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM hotels_db.hotels");
        ResultSet resultSet = statement.executeQuery();
        List<Hotel> hotelsList = new ArrayList<>();
        while(resultSet.next()){
            Hotel hotel = new Hotel();
            hotel.setId(resultSet.getInt("id"));
            hotel.setName(resultSet.getString("name"));
            hotel.setPlacesCount(resultSet.getInt("places_count"));
            hotelsList.add(hotel);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return hotelsList;
    }

    @Override
    public void createEntity(Hotel entity) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO `hotels_db`.`hotels` (`name`, `places_count`) VALUES (?, ?);");
        statement.setString(1, String.valueOf(entity.getName()));
        statement.setString(2, String.valueOf(entity.getPlacesCount()));
        statement.execute();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    public int updatePlacesCount(int hotelId, int count) throws SQLException{
        Connection connection = null;
            connection = ConnectionPool.INSTANCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM hotels_db.hotels WHERE `id`=?;");
            statement.setInt(1, hotelId);
            ResultSet resultSet = statement.executeQuery();
            int oldPlacesCount=0;
            while(resultSet.next()) {
                oldPlacesCount = resultSet.getInt("places_count");
            }
            if (oldPlacesCount + count < 0) {
                count = -oldPlacesCount;
            }
            statement = connection.prepareStatement("UPDATE `hotels_db`.`hotels` SET `places_count`=? WHERE `id`=?;");
            statement.setString(1, String.valueOf(oldPlacesCount+count));
            statement.setInt(2, hotelId);
            statement.execute();
            return -count;
    }

    public void deleteEntity(int id) throws SQLException{
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM `hotels_db`.`hotels` WHERE `id`=?;");
        statement.setInt(1, id);
        statement.execute();
    }
}
