package by.ilyacoding.servicehotels.command.client;

import by.ilyacoding.servicehotels.bean.Hotel;
import by.ilyacoding.servicehotels.bean.Request;
import by.ilyacoding.servicehotels.bean.User;
import by.ilyacoding.servicehotels.command.Command;
import by.ilyacoding.servicehotels.dao.HotelDAO;
import by.ilyacoding.servicehotels.dao.RequestDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ilyacoding on 11/28/2017.
 */
public class ShowClientHotelsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();

            List<Hotel> hotelList = HotelDAO.INSTANCE.findAll();
            session.setAttribute("hotelList",hotelList);
            User user = (User)session.getAttribute("user");
            List<Request> requestList = RequestDAO.INSTANCE.getEntitiesByUserId(user.getId());
            session.setAttribute("requestList",requestList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/jsp/client/main.jsp";
    }
}
