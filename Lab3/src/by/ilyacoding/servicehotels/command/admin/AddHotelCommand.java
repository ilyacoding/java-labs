package by.ilyacoding.servicehotels.command.admin;

import by.ilyacoding.servicehotels.bean.Hotel;
import by.ilyacoding.servicehotels.command.Command;
import by.ilyacoding.servicehotels.dao.HotelDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by ilyacoding on 11/28/2017.
 */
public class AddHotelCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        Hotel hotel = new Hotel();
        hotel.setName(request.getParameter("hotelname"));
        hotel.setPlacesCount(Integer.parseInt(request.getParameter("placescount")));
        try {
            HotelDAO.INSTANCE.createEntity(hotel);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        new ShowAdminPageCommand().execute(request);
        return "/servicehotels";
    }
}
