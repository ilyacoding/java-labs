package by.bsuir.ilyacoding.controller.command.impl;

import by.bsuir.ilyacoding.controller.command.Command;
import by.bsuir.ilyacoding.domain.Book;
import by.bsuir.ilyacoding.service.BookService;
import by.bsuir.ilyacoding.service.ServiceFactory;
import by.bsuir.ilyacoding.service.exception.ServiceException;

public class DeleteBookCommand implements Command {

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

            if (bookService.deleteBook(params[0], params[1], Book.Type.valueOf(params[2]))) {
                return "Book was deleted";
            }
            else {
                return "No such book";
            }
        } catch (ServiceException e) {
            return e.getMessage();
        }
    }
}
