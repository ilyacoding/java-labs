package by.ilyacoding.servicehotels.command.user;

import by.ilyacoding.servicehotels.bean.User;
import by.ilyacoding.servicehotels.command.Command;
import by.ilyacoding.servicehotels.command.factory.CommandType;
import by.ilyacoding.servicehotels.command.util.LocalizationCommand;
import by.ilyacoding.servicehotels.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by ilyacoding on 11/28/2017.
 */
public class LoginUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String page = null;
        try{
            if(UserDAO.INSTANCE.isAuthorized(login,password)) {
                HttpSession session = request.getSession();
                User user = UserDAO.INSTANCE.getUserByLogin(login);
                session.setAttribute("userType",user.getRole());
                session.setAttribute("user",user);

                if(user.getRole().equals("user")) {
                    CommandType type = CommandType.valueOf("SHOWUSERPAGE");
                    type.getCurrentCommand().execute(request);
                    page = "/jsp/client/main.jsp";
                }
                else
                {
                    CommandType type = CommandType.valueOf("SHOWADMINPAGE");
                    type.getCurrentCommand().execute(request);
                    page="/jsp/admin/main.jsp";
                }
            }else{
                page = "/index.jsp";
                if(login != null && password != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("errorLoginOrPassword", "<div class='alert alert-danger'>Invalid login or password</div>");
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
            page = "/index.jsp";
        }
        new LocalizationCommand().execute(request);
        return page;
    }
}
