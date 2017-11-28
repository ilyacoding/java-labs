package by.bsuir.ilyacoding.Server.service.impl;

import by.bsuir.ilyacoding.Server.dao.DAOFactory;
import by.bsuir.ilyacoding.Server.dao.exception.DAOException;
import by.bsuir.ilyacoding.Server.domain.User;
import by.bsuir.ilyacoding.Server.service.EncodingService;
import by.bsuir.ilyacoding.Server.service.ServiceFactory;
import by.bsuir.ilyacoding.Server.service.UserService;
import by.bsuir.ilyacoding.Server.service.exception.ServiceException;
import by.bsuir.ilyacoding.Server.service.util.Validator;

import java.util.List;

public class UserServiceImpl implements UserService {

	private boolean isValid(String login, String password) throws ServiceException {
		if (Validator.isLoginValid(login) && Validator.isPasswordValid(password)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean register(User user) throws ServiceException {
		if (!isValid(user.getLogin(), user.getPassword())) {
			throw new ServiceException("Wrong password, login or email");
		}
		try {
			User existingUser = DAOFactory.getInstance().getUserDAO().getUserByLogin(user.getLogin());
			if (existingUser != null) {
				return false;
			}
			else {
				EncodingService encoder = new Sha256EncodeServiceImpl();
				String password = encoder.getHash(user.getPassword());
				user.setPassword(password);
				return DAOFactory.getInstance().getUserDAO().addUser(user);
			}
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public User login(String login, String password) throws ServiceException {
		if (!isValid(login, password)) {
			throw new ServiceException("Wrong password, login or email");
		}

		try {
			EncodingService encoder = new Sha256EncodeServiceImpl();
			String encodedPassword = encoder.getHash(password);
			User user = DAOFactory.getInstance().getUserDAO().getUserByLoginAndPassword(login, encodedPassword);
			return user;
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<User> getAll() throws ServiceException {
		try {
			return DAOFactory.getInstance().getUserDAO().getAll();
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
