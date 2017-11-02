package by.bsuir.ilyacoding.dao.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import by.bsuir.ilyacoding.dao.AppendObjectOutputStream;
import by.bsuir.ilyacoding.dao.BookDAO;
import by.bsuir.ilyacoding.dao.exception.DAOException;
import by.bsuir.ilyacoding.domain.Book;

public class FileBookDAO implements BookDAO {

	private String filePath = "books.db";

	@Override
	public boolean addBook(Book book) throws DAOException {
		ObjectOutputStream ous = null;
		File file = new File(filePath);
		try {
			if (file.exists()) {
				ous = new AppendObjectOutputStream(new FileOutputStream(file, true));
			}
			else {
				ous = new ObjectOutputStream(new FileOutputStream(file));
			}

			ous.writeObject(book);
			ous.flush();

			return true;
		}
		catch(IOException e) {
			throw new DAOException(e);
		}
		finally {
			if (ous != null) {
				try {
					ous.close();
				} catch (IOException e) {
					throw new DAOException(e);
				}
			}
		}
	}

	@Override
	public boolean deleteBook(String title, String author, Book.Type type) throws DAOException {
		List<Book> books = getAll();
		try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(filePath))) {

			boolean bookWasDeleted = books.removeIf((book) ->
					book.getTitle().equals(title) && book.getAuthor().equals(author) && book.getType().equals(type));

			for (Book b : books) {
				ous.writeObject(b);
			}

			return bookWasDeleted;
		}

		catch (IOException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public List<Book> getAll() throws DAOException {
		ObjectOutputStream ous = null;
		ObjectInputStream ois = null;
		File file = new File(filePath);
		List<Book> books = new ArrayList<>();

		try {
			if (file.exists()) {
				ous = new AppendObjectOutputStream(new FileOutputStream(file, true));
			}
			else {
				ous = new ObjectOutputStream(new FileOutputStream(file));
			}

			ois = new ObjectInputStream(new FileInputStream(file));

			Book book;
			while ((book = (Book)ois.readObject()) != null) {
				books.add(book);
			}

			return books;
		}
		catch (EOFException ignored) {
			return books;
		}
		catch (IOException | ClassNotFoundException e) {
			throw new DAOException(e);
		}
		finally {
			if (ous != null) {
				try {
					ous.close();
				} catch (IOException e) {
					throw new DAOException(e);
				}
			}
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					throw new DAOException(e);
				}
			}
		}
	}

	@Override
	public Book getBook(String title, String author, Book.Type type) throws DAOException {
		List<Book> books = getAll();

		return books.stream().filter((book) -> book.getTitle().equals(title)
											&& book.getAuthor().equals(author)
											&& book.getType().equals(type)).findFirst().orElse(null);
	}

	@Override
	public List<Book> getBooksByTitle(String title) throws DAOException {
		return getAll().stream().filter(book -> book.getTitle().equals(title)).collect(Collectors.toList());
	}

	@Override
	public List<Book> getBooksByAuthor(String author) throws DAOException {
		return getAll().stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
	}

	@Override
	public List<Book> getBooksByType(Book.Type type) throws DAOException {
		return getAll().stream().filter(book -> book.getType().equals(type)).collect(Collectors.toList());
	}
}
