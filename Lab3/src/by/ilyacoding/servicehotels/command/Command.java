package by.ilyacoding.servicehotels.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ilyacoding on 11/28/2017.
 */
public interface Command {
    String execute(HttpServletRequest request);
}
