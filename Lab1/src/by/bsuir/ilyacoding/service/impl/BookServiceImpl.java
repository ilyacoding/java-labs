package by.bsuir.ilyacoding.service.impl;

import by.bsuir.ilyacoding.dao.BookDAO;
import by.bsuir.ilyacoding.dao.DAOFactory;
import by.bsuir.ilyacoding.dao.exception.DAOException;
import by.bsuir.ilyacoding.domain.Book;
import by.bsuir.ilyacoding.domain.User;
import by.bsuir.ilyacoding.service.BookService;
import by.bsuir.ilyacoding.service.ServiceFactory;
import by.bsuir.ilyacoding.service.exception.ServiceException;
import by.bsuir.ilyacoding.service.util.Validator;

import java.util.List;

public class BookServiceImpl implements BookService {

	private static String InvalidDataMessage = "Invalid title and/or author";

	private boolean isValid(String title, String author) throws ServiceException {
		if (Validator.isTitleValid(title) && Validator.isAuthorValid(author)) {
			return true;
		}

		return false;
	}

	private void checkAccessRights() throws ServiceException {
		if (!ServiceFactory.getInstance().getCurrentUser().getRole().equals(User.Role.ADMIN)) {
			throw new ServiceException("Access denied.");
		}
	}

	@Override
	public boolean addBook(Book book) throws ServiceException {
		checkAccessRights();

		if (!isValid(book.getTitle(), book.getAuthor())) {
			throw new ServiceException("Invalid title and/or author");
		}

		try {
			BookDAO bookDAO = DAOFactory.getInstance().getBookDAO();
			Book existingBook = bookDAO.getBook(book.getTitle(), book.getAuthor(), book.getType());

			if (existingBook == null) {
				return bookDAO.addBook(book);
			}
			return false;
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Book getBook(String title, String author, Book.Type type) throws ServiceException {
		if (!isValid(title, author)) {
			throw new ServiceException(InvalidDataMessage);
		}

		try {
			return DAOFactory.getInstance().getBookDAO().getBook(title, author, type);
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean deleteBook(String title, String author, Book.Type type) throws ServiceException {
		checkAccessRights();

		if (!isValid(title, author)) {
			throw new ServiceException(InvalidDataMessage);
		}

		try {
			return DAOFactory.getInstance().getBookDAO().deleteBook(title, author, type);
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Book> getAll() throws ServiceException {
		try {
			return DAOFactory.getInstance().getBookDAO().getAll();
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Book> getBooksByTitle(String title) throws ServiceException {
		try {
			return DAOFactory.getInstance().getBookDAO().getBooksByTitle(title);
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Book> getBooksByAuthor(String author) throws ServiceException {
		try {
			return DAOFactory.getInstance().getBookDAO().getBooksByAuthor(author);
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Book> getBooksByType(Book.Type type) throws ServiceException {
		try {
			return DAOFactory.getInstance().getBookDAO().getBooksByType(type);
		}
		catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
