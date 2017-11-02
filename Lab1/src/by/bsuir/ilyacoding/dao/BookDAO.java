package by.bsuir.ilyacoding.dao;

import by.bsuir.ilyacoding.dao.exception.DAOException;
import by.bsuir.ilyacoding.domain.Book;

import java.util.List;

public interface BookDAO {

	boolean addBook(Book book) throws DAOException;
	Book getBook(String title, String author, Book.Type type) throws DAOException;
	boolean deleteBook(String title, String author, Book.Type type) throws DAOException;

	List<Book> getAll() throws DAOException;

	List<Book> getBooksByTitle(String title) throws DAOException;
	List<Book> getBooksByAuthor(String author) throws DAOException;
	List<Book> getBooksByType(Book.Type type) throws DAOException;
}
