package by.bsuir.ilyacoding.controller.command.impl;

import by.bsuir.ilyacoding.controller.command.Command;
import by.bsuir.ilyacoding.service.ServiceFactory;

public class LogoutCommand implements Command {
    @Override
    public String execute(String request) {
        if (ServiceFactory.getInstance().getCurrentUser() != null)
        {
            ServiceFactory.getInstance().setCurrentUser(null);
            return "Logout successfully";
        } else {
            return "Already logouted";
        }
    }
}
