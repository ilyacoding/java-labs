package by.bsuir.ilyacoding.controller.command.impl;

import by.bsuir.ilyacoding.controller.command.Command;
import by.bsuir.ilyacoding.controller.util.BookStringBuilder;
import by.bsuir.ilyacoding.domain.Book;
import by.bsuir.ilyacoding.service.BookService;
import by.bsuir.ilyacoding.service.ServiceFactory;
import by.bsuir.ilyacoding.service.exception.ServiceException;

public class GetBookCommand implements Command {

    @Override
    public String execute(String request) {
        String[] params = request.split(";");

        if (params.length < 3) {
            return "Arguments required: 3";
        }

        try {
            BookService bookService = ServiceFactory.getInstance().getBookService();
            if (bookService == null) {
                throw new ServiceException("Access denied");
            }
            Book book = bookService.getBook(params[0], params[1], Book.Type.valueOf(params[2]));
            if (book != null) {
                BookStringBuilder sb = new BookStringBuilder();
                return sb.buildString(book);
            }
            else {
                return "No such book";
            }
        } catch (ServiceException e) {
            return e.getMessage();
        }
    }
}
