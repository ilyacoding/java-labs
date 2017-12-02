package by.ilyacoding.servicehotels.dao;

import by.ilyacoding.servicehotels.bean.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ilyacoding on 11/28/2017.
 */
public interface AbstractDAO <T extends Entity> {
    List<T> findAll() throws SQLException;
    void createEntity(T entity) throws SQLException;
}
