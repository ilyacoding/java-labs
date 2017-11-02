package by.bsuir.ilyacoding.dao;

import by.bsuir.ilyacoding.dao.exception.DAOException;
import by.bsuir.ilyacoding.domain.User;

import java.util.List;

public interface UserDAO {

	boolean addUser(User user) throws DAOException;

	User getUserByLoginAndPassword(String login, String password) throws DAOException;
	User getUserByLogin(String login) throws DAOException;

	List<User> getAll() throws DAOException;
}
