package by.ilyacoding.servicehotels.command.factory;

import by.ilyacoding.servicehotels.command.Command;
import by.ilyacoding.servicehotels.command.admin.AddHotelCommand;
import by.ilyacoding.servicehotels.command.admin.DeleteHotelCommand;
import by.ilyacoding.servicehotels.command.admin.ShowAdminPageCommand;
import by.ilyacoding.servicehotels.command.client.CancelReservationCommand;
import by.ilyacoding.servicehotels.command.client.ReserveHotelCommand;
import by.ilyacoding.servicehotels.command.client.ShowClientHotelsCommand;
import by.ilyacoding.servicehotels.command.user.LoginUserCommand;
import by.ilyacoding.servicehotels.command.user.LogoutUserCommand;
import by.ilyacoding.servicehotels.command.util.LocalizationCommand;

/**
 * Created by ilyacoding on 11/28/2017.
 */

public enum CommandType {
    LOGIN, LOGOUT,

    RESERVEHOTEL, SHOWUSERPAGE, CANCELRESERVATION,

    ADDHOTEL, SHOWADMINPAGE, DELETEHOTEL,

    LOCALIZATION;

    public Command getCurrentCommand() throws EnumConstantNotPresentException{
        switch (this){
            case LOGIN:
                return new LoginUserCommand();

            case LOGOUT:
                return new LogoutUserCommand();

            case RESERVEHOTEL:
                return new ReserveHotelCommand();

            case SHOWUSERPAGE:
                return new ShowClientHotelsCommand();

            case ADDHOTEL:
                return new AddHotelCommand();

            case SHOWADMINPAGE:
                return new ShowAdminPageCommand();

            case CANCELRESERVATION:
                return new CancelReservationCommand();

            case DELETEHOTEL:
                return new DeleteHotelCommand();

            case LOCALIZATION:
                return new LocalizationCommand();

            default:
                throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }

}
