package by.bsuir.ilyacoding.controller.command.impl;

import by.bsuir.ilyacoding.controller.command.Command;
import by.bsuir.ilyacoding.domain.User;
import by.bsuir.ilyacoding.service.ServiceFactory;
import by.bsuir.ilyacoding.service.exception.ServiceException;

public class RegisterCommand implements Command {

    @Override
    public String execute(String request) {
        String[] params = request.split(";");

        if (params.length < 2) {
            return "Arguments required: 2";
        }

        User user = new User();

        user.setLogin(params[0]);
        user.setPassword(params[1]);

        if (params.length > 2)
        {
            try {
                user.setRole(User.Role.valueOf(params[2]));
            } catch (IllegalArgumentException e) {
                return "Invalid user group: ADMIN or USER";
            }
        } else {
            user.setRole(User.Role.USER);
        }

        try {
            boolean registerSuccessful = ServiceFactory.getInstance().getUserService().register(user);
            if (registerSuccessful) {
                return "Registered successfully.\n";
            }
            else {
                return "Registration failed.\n";
            }
        } catch (ServiceException e) {
            return e.getMessage();
        }
    }
}
