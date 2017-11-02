package by.bsuir.ilyacoding.controller.command.impl;

import by.bsuir.ilyacoding.controller.command.Command;
import by.bsuir.ilyacoding.controller.util.BookStringBuilder;
import by.bsuir.ilyacoding.domain.Book;
import by.bsuir.ilyacoding.service.BookService;
import by.bsuir.ilyacoding.service.ServiceFactory;
import by.bsuir.ilyacoding.service.exception.ServiceException;

import java.util.List;

public class GetBookByTitleCommand implements Command {

    @Override
    public String execute(String request) {
        String[] params = request.split(";");

        if (params.length < 1) {
            return "Arguments required: 1";
        }

        try {
            BookService bookService = ServiceFactory.getInstance().getBookService();
            if (bookService == null) {
                throw new ServiceException("Access denied");
            }

            List<Book> books = bookService.getBooksByTitle(params[0]);
            if (books != null) {
                BookStringBuilder sb = new BookStringBuilder();
                return sb.buildString(books);
            }
            else {
                return "No such book";
            }
        } catch (ServiceException e) {
            return e.getMessage();
        }
    }
}
