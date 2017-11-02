package by.bsuir.ilyacoding.controller.command.impl;

import by.bsuir.ilyacoding.controller.command.Command;
import by.bsuir.ilyacoding.domain.Book;
import by.bsuir.ilyacoding.service.BookService;
import by.bsuir.ilyacoding.service.ServiceFactory;
import by.bsuir.ilyacoding.service.exception.ServiceException;

public class AddBookCommand implements Command {

	@Override
	public String execute(String request) {
		String[] params = request.split(";");

		if (params.length < 3) {
			return "Necessary args count : 3";
		}

		Book book = new Book();

		book.setTitle(params[0]);
		book.setAuthor(params[1]);

		try {
			book.setType(Book.Type.valueOf(params[2]));
		} catch (IllegalArgumentException e)
		{
			return "Invalid book type: PAPER or ELECTRONIC";
		}

		try {
			BookService bookService = ServiceFactory.getInstance().getBookService();
			if (bookService == null) {
				throw new ServiceException("Access denied");
			}

			if (bookService.addBook(book)) {
				return "Book was added";
			}
			else {
				return "Add failed";
			}
		} catch (ServiceException e) {
			return e.getMessage();
		}
	}

}
