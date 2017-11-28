package by.bsuir.ilyacoding.Server.controller.command.impl;

import by.bsuir.ilyacoding.Server.controller.ServerThread;
import by.bsuir.ilyacoding.Server.controller.command.Command;

/**
 * Created by user on 29.10.2017.
 */
public class LogOutCommand implements Command {

    @Override
    public String execute(String request) {

        ServerThread threadInst = (ServerThread)Thread.currentThread();
        threadInst.setCurrentUser(null);

        return "Logout success.";
    }
}
