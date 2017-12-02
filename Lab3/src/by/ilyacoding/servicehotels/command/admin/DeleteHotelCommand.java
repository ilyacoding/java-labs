package by.ilyacoding.servicehotels.command.admin;

import by.ilyacoding.servicehotels.command.Command;
import by.ilyacoding.servicehotels.dao.HotelDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by ilyacoding on 11/22/2017.
 */
public class DeleteHotelCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        int hotelId = Integer.parseInt(request.getParameter("hotelid"));
        try {
            HotelDAO.INSTANCE.deleteEntity(hotelId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        new ShowAdminPageCommand().execute(request);
        return "/servicehotels";
    }
}
