package by.bsuir.ilyacoding.service;

import by.bsuir.ilyacoding.dao.BookDAO;
import by.bsuir.ilyacoding.dao.DAOFactory;
import by.bsuir.ilyacoding.dao.UserDAO;
import by.bsuir.ilyacoding.dao.impl.FileBookDAO;
import by.bsuir.ilyacoding.dao.impl.FileUserDAO;
import by.bsuir.ilyacoding.service.impl.BookServiceImpl;
import by.bsuir.ilyacoding.service.impl.UserServiceImpl;

import by.bsuir.ilyacoding.domain.User;

public class ServiceFactory {

	private static final ServiceFactory factory = new ServiceFactory();

	private final BookService bookService = new BookServiceImpl();
	private final UserService userService = new UserServiceImpl();
	private User currentUser;

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return factory;
	}

	public BookService getBookService() {
		if (currentUser != null)
		{
			return bookService;
		}

		return null;
	}
	public UserService getUserService() {
		return userService;
	}

	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User user) {
		this.currentUser = user;
	}
}
