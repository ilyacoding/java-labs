package by.bsuir.ilyacoding.Server.controller.command.impl;

import by.bsuir.ilyacoding.Server.controller.command.Command;

public class HelpCommand implements Command {
    @Override
    public String execute(String request) {
        return "register\nlogin\nlogout\n\nadd\ndelete\nget\nupdate\nall\n\nquit";
    }
}
