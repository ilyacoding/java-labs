package by.bsuir.ilyacoding.Server.controller.command.impl;

import by.bsuir.ilyacoding.Server.controller.ServerThread;
import by.bsuir.ilyacoding.Server.controller.command.Command;
import by.bsuir.ilyacoding.Server.controller.command.util.Parser;
import by.bsuir.ilyacoding.Server.domain.Affair;
import by.bsuir.ilyacoding.Server.domain.User;
import by.bsuir.ilyacoding.Server.service.ServiceFactory;
import by.bsuir.ilyacoding.Server.service.exception.ServiceException;

public class UpdateAffairCommand implements Command {
    
    @Override
    public String execute(String request) {
        String[] params = Parser.parse(request);

        if (params.length < 1 || params.length > 4) {
            return "Necessary args count : between 1 and 4.";
        }

        int id;
        try {
            id = Integer.valueOf(params[0]);
        }
        catch (NumberFormatException ignored) {
            return "First number should be a number.";
        }

        Affair affair = createAffair(params);

        String response;

        try {
            User user = ((ServerThread)Thread.currentThread()).getCurrentUser();
            if (user == null || user.getRole().equals(User.Role.USER)) {
                throw new ServiceException("Access denied");
            }

            ServiceFactory.getInstance().getAffairService().updateAffairById(id, affair);
            return "Affair was updated";

        } catch (ServiceException e) {
            response = e.getMessage();
        }

        return response;
    }

    private Affair createAffair(String[] params) {
        Affair affair = new Affair();
        affair.setId(Integer.valueOf(params[0]));
        try {
            affair.setName(params[1]);
            affair.setBirthDate(params[2]);
            affair.setCourse(Integer.valueOf(params[3]));
        }
        finally {
            return affair;
        }
    }

}
