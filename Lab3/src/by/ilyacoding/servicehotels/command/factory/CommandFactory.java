package by.ilyacoding.servicehotels.command.factory;

import by.ilyacoding.servicehotels.command.Command;
import by.ilyacoding.servicehotels.command.user.LoginUserCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ilyacoding on 11/28/2017.
 */
public enum CommandFactory {
    INSTANCE;

    public Command defineCommand(HttpServletRequest request){
        Command current = null;
        String commandName = request.getParameter("command");
        if(commandName == null){
            HttpSession session = request.getSession();
            String userType = (String)session.getAttribute("userType");
            if(userType != null) {
                if (userType.equals("admin")) {
                    commandName = "SHOWADMINPAGE";
                } else if (userType.equals("user")) {
                    commandName = "SHOWUSERPAGE";
                }
            }
        }
        try{
            CommandType type = CommandType.valueOf(commandName.toUpperCase());
            current = type.getCurrentCommand();
        }
        catch(NullPointerException e){
            current = new LoginUserCommand();
        }
        catch(IllegalArgumentException e){
            current = new LoginUserCommand();
        }
        return current;
    }
}
