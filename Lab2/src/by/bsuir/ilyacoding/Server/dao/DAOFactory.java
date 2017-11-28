package by.bsuir.ilyacoding.Server.dao;

import by.bsuir.ilyacoding.Server.dao.xml.XmlAffairDAO;
import by.bsuir.ilyacoding.Server.dao.xml.XmlUserDAO;

public class DAOFactory {

	private static DAOFactory instance;
	private static final Object lock = new Object();

	private final AffairDAO affairDAO = new XmlAffairDAO();
	private final UserDAO userDAO = new XmlUserDAO();

	public AffairDAO getAffairDAO() {
		return affairDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public static DAOFactory getInstance() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new DAOFactory();
				}
			}
		}
		return instance;
	}
}
