package by.bsuir.ilyacoding.controller.util;

import by.bsuir.ilyacoding.domain.Book;

import java.util.List;

public class BookStringBuilder {
    public String buildString(List<Book> bookList) {
        StringBuilder stringBuilder = new StringBuilder();
        bookList.forEach((book) -> stringBuilder.append(buildString(book)));
        return stringBuilder.toString();
    }

    public String buildString(Book book) {
        return String.format("Title: %s;\nAuthor: %s;\nType: %s\n\n", book.getTitle(), book.getAuthor(), book.getType());
    }
}
