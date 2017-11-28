package by.bsuir.ilyacoding.Server.controller.command.impl;

import by.bsuir.ilyacoding.Server.controller.ServerThread;
import by.bsuir.ilyacoding.Server.controller.command.Command;
import by.bsuir.ilyacoding.Server.controller.command.util.Parser;
import by.bsuir.ilyacoding.Server.domain.User;
import by.bsuir.ilyacoding.Server.service.ServiceFactory;
import by.bsuir.ilyacoding.Server.service.exception.ServiceException;

public class DeleteAffairCommand implements Command {

    @Override
    public String execute(String request) {

        String[] params = Parser.parse(request);

        if (params.length != 1) {
            return "Necessary args count : 1.";
        }

        String response;

        try {

            User user = ((ServerThread)Thread.currentThread()).getCurrentUser();
            if (user == null || user.getRole().equals(User.Role.USER)) {
                throw new ServiceException("Access denied");
            }

            ServiceFactory.getInstance().getAffairService().deleteAffairById(Integer.valueOf(params[0]));
            response = "Delete success.";

        } catch (ServiceException e) {
            response = e.getMessage();
        }

        return response;
    }
}
