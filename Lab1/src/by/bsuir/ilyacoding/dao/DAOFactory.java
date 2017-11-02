package by.bsuir.ilyacoding.dao;

import by.bsuir.ilyacoding.dao.impl.FileBookDAO;
import by.bsuir.ilyacoding.dao.impl.FileUserDAO;

public class DAOFactory {

	private static final DAOFactory factory = new DAOFactory();

	private final BookDAO bookDAO = new FileBookDAO();
	private final UserDAO userDAO = new FileUserDAO();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return factory;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

}
