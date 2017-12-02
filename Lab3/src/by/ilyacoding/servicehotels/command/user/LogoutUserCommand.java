package by.ilyacoding.servicehotels.command.user;

import by.ilyacoding.servicehotels.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ilyacoding on 11/28/2017.
 */
public class LogoutUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("userType");
        session.removeAttribute("errorLoginOrPassword");
        session.invalidate();
        return "/servicehotels";
    }
}
