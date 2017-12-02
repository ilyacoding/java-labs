package by.ilyacoding.servicehotels.command.client;

import by.ilyacoding.servicehotels.bean.Request;
import by.ilyacoding.servicehotels.bean.User;
import by.ilyacoding.servicehotels.command.Command;
import by.ilyacoding.servicehotels.dao.HotelDAO;
import by.ilyacoding.servicehotels.dao.RequestDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by ilyacoding on 11/28/2017.
 */
public class ReserveHotelCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        Request requestEntity = new Request();
        int hotelId = Integer.parseInt(request.getParameter("hotelid"));
        int placesCount = Integer.parseInt(request.getParameter("reservedplacescount"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        requestEntity.setUserId(user.getId());
        requestEntity.setPlacesCount(placesCount);
        requestEntity.setHotelId(hotelId);

        try {
            int reserved = HotelDAO.INSTANCE.updatePlacesCount(requestEntity.getHotelId(),-requestEntity.getPlacesCount());
            requestEntity.setPlacesCount(reserved);
            if (reserved > 0) {
                RequestDAO.INSTANCE.createEntity(requestEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        new ShowClientHotelsCommand().execute(request);
        return "/servicehotels";
    }
}
