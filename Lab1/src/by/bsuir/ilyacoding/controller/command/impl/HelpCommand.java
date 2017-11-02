package by.bsuir.ilyacoding.controller.command.impl;

import by.bsuir.ilyacoding.controller.command.Command;

public class HelpCommand implements Command {
    @Override
    public String execute(String request) {
        return "register\nlogin\nlogout\n\nadd_book\ndelete_book\nget_books\nget_book\nfind_by_title\nfind_by_author\nfind_by_type\n\nquit";
    }
}
