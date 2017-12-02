package by.ilyacoding.servicehotels.servlet;

import by.ilyacoding.servicehotels.bean.User;
import by.ilyacoding.servicehotels.command.Command;
import by.ilyacoding.servicehotels.command.factory.CommandFactory;
import by.ilyacoding.servicehotels.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ilyacoding on 11/28/2017.
 */

@WebServlet("/servicehotels")
public class ServletController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String page = null;
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Command command = CommandFactory.INSTANCE.defineCommand(request);
        page = command.execute(request);

        if(page != null){
            response.sendRedirect(request.getContextPath()+page);
        }
        else {
            page = "/index.jsp";
            response.sendRedirect(request.getContextPath()+page);
        }
        response.setCharacterEncoding("UTF-8");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
