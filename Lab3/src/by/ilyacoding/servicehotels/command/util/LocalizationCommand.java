package by.ilyacoding.servicehotels.command.util;

import by.ilyacoding.servicehotels.command.Command;
import by.ilyacoding.servicehotels.locale.LocalePropertyManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * Created by ilyacoding on 11/24/2017.
 */
public class LocalizationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();
        if(request.getParameter("locale")!= null){
            session.setAttribute("locale",request.getParameter("locale"));
        }
            switch ((String)session.getAttribute("locale")){

                case "ru":{
                    session.setAttribute("locale_authorization_btn", LocalePropertyManager.INSTANCE.getProperty("locale.ru.authorization.btn"));
                    session.setAttribute("locale_authorization_label_login", LocalePropertyManager.INSTANCE.getProperty("locale.ru.authorization.label.login"));
                    session.setAttribute("locale_authorization_label_password", LocalePropertyManager.INSTANCE.getProperty("locale.ru.authorization.label.password"));
                    session.setAttribute("locale_authorization_header", LocalePropertyManager.INSTANCE.getProperty("locale.ru.authorization.header"));

                    session.setAttribute("locale_admin_table_header", LocalePropertyManager.INSTANCE.getProperty("locale.ru.admin.table.header"));
                    session.setAttribute("locale_admin_table_hotelname", LocalePropertyManager.INSTANCE.getProperty("locale.ru.admin.table.hotelname"));
                    session.setAttribute("locale_admin_table_hotelcount", LocalePropertyManager.INSTANCE.getProperty("locale.ru.admin.table.hotelcount"));
                    session.setAttribute("locale_admin_table_deleteform", LocalePropertyManager.INSTANCE.getProperty("locale.ru.admin.table.deleteform"));
                    session.setAttribute("locale_admin_table_btndelete", LocalePropertyManager.INSTANCE.getProperty("locale.ru.admin.table.btndelete"));
                    session.setAttribute("locale_admin_registration_header", LocalePropertyManager.INSTANCE.getProperty("locale.ru.admin.registration.header"));
                    session.setAttribute("locale_admin_registration_label_hotelname", LocalePropertyManager.INSTANCE.getProperty("locale.ru.admin.registration.label.hotelname"));
                    session.setAttribute("locale_admin_registration_label_hotelcount", LocalePropertyManager.INSTANCE.getProperty("locale.ru.admin.registration.label.hotelcount"));
                    session.setAttribute("locale_admin_registration_btnadd", LocalePropertyManager.INSTANCE.getProperty("locale.ru.admin.registration.btnadd"));

                    session.setAttribute("locale_client_table_header", LocalePropertyManager.INSTANCE.getProperty("locale.ru.client.table.header"));
                    session.setAttribute("locale_client_table_hotelname", LocalePropertyManager.INSTANCE.getProperty("locale.ru.client.table.hotelname"));
                    session.setAttribute("locale_client_table_hotelcount", LocalePropertyManager.INSTANCE.getProperty("locale.ru.client.table.hotelcount"));
                    session.setAttribute("locale_client_table_reservationform", LocalePropertyManager.INSTANCE.getProperty("locale.ru.client.table.reservationform"));
                    session.setAttribute("locale_client_table_btnreserve", LocalePropertyManager.INSTANCE.getProperty("locale.ru.client.table.btnreserve"));
                    session.setAttribute("locale_client_reservedtabel_header", LocalePropertyManager.INSTANCE.getProperty("locale.ru.client.reservedtabel.header"));
                    session.setAttribute("locale_client_reservedtabel_hotelname", LocalePropertyManager.INSTANCE.getProperty("locale.ru.client.reservedtable.hotelname"));
                    session.setAttribute("locale_client_reservedtabel_hotelcount", LocalePropertyManager.INSTANCE.getProperty("locale.ru.client.reservedtable.hotelcount"));
                    session.setAttribute("locale_client_reservedtabel_cancelreservationform", LocalePropertyManager.INSTANCE.getProperty("locale.ru.client.reservedtable.cancelreservationform"));
                    session.setAttribute("locale_client_reservedtabel_btncancelreservation", LocalePropertyManager.INSTANCE.getProperty("locale.ru.client.reservedtable.btncancelreservation"));

                    session.setAttribute("locale_btn_logout", LocalePropertyManager.INSTANCE.getProperty("locale.ru.btn.logout"));
                    break;
                }

                default:{
                    session.setAttribute("locale_authorization_btn", LocalePropertyManager.INSTANCE.getProperty("locale.eng.authorization.btn"));
                    session.setAttribute("locale_authorization_label_login", LocalePropertyManager.INSTANCE.getProperty("locale.eng.authorization.label.login"));
                    session.setAttribute("locale_authorization_label_password", LocalePropertyManager.INSTANCE.getProperty("locale.eng.authorization.label.password"));
                    session.setAttribute("locale_authorization_header", LocalePropertyManager.INSTANCE.getProperty("locale.eng.authorization.header"));

                    session.setAttribute("locale_admin_table_header", LocalePropertyManager.INSTANCE.getProperty("locale.eng.admin.table.header"));
                    session.setAttribute("locale_admin_table_hotelname", LocalePropertyManager.INSTANCE.getProperty("locale.eng.admin.table.hotelname"));
                    session.setAttribute("locale_admin_table_hotelcount", LocalePropertyManager.INSTANCE.getProperty("locale.eng.admin.table.hotelcount"));
                    session.setAttribute("locale_admin_table_deleteform", LocalePropertyManager.INSTANCE.getProperty("locale.eng.admin.table.deleteform"));
                    session.setAttribute("locale_admin_table_btndelete", LocalePropertyManager.INSTANCE.getProperty("locale.eng.admin.table.btndelete"));
                    session.setAttribute("locale_admin_registration_header", LocalePropertyManager.INSTANCE.getProperty("locale.eng.admin.registration.header"));
                    session.setAttribute("locale_admin_registration_label_hotelname", LocalePropertyManager.INSTANCE.getProperty("locale.eng.admin.registration.label.hotelname"));
                    session.setAttribute("locale_admin_registration_label_hotelcount", LocalePropertyManager.INSTANCE.getProperty("locale.eng.admin.registration.label.hotelcount"));
                    session.setAttribute("locale_admin_registration_btnadd", LocalePropertyManager.INSTANCE.getProperty("locale.eng.admin.registration.btnadd"));

                    session.setAttribute("locale_client_table_header", LocalePropertyManager.INSTANCE.getProperty("locale.eng.client.table.header"));
                    session.setAttribute("locale_client_table_hotelname", LocalePropertyManager.INSTANCE.getProperty("locale.eng.client.table.hotelname"));
                    session.setAttribute("locale_client_table_hotelcount", LocalePropertyManager.INSTANCE.getProperty("locale.eng.client.table.hotelcount"));
                    session.setAttribute("locale_client_table_reservationform", LocalePropertyManager.INSTANCE.getProperty("locale.eng.client.table.reservationform"));
                    session.setAttribute("locale_client_table_btnreserve", LocalePropertyManager.INSTANCE.getProperty("locale.eng.client.table.btnreserve"));
                    session.setAttribute("locale_client_reservedtabel_header", LocalePropertyManager.INSTANCE.getProperty("locale.eng.client.reservedtabel.header"));
                    session.setAttribute("locale_client_reservedtabel_hotelname", LocalePropertyManager.INSTANCE.getProperty("locale.eng.client.reservedtable.hotelname"));
                    session.setAttribute("locale_client_reservedtabel_hotelcount", LocalePropertyManager.INSTANCE.getProperty("locale.eng.client.reservedtable.hotelcount"));
                    session.setAttribute("locale_client_reservedtabel_cancelreservationform", LocalePropertyManager.INSTANCE.getProperty("locale.eng.client.reservedtable.cancelreservationform"));
                    session.setAttribute("locale_client_reservedtabel_btncancelreservation", LocalePropertyManager.INSTANCE.getProperty("locale.eng.client.reservedtable.btncancelreservation"));

                    session.setAttribute("locale_btn_logout", LocalePropertyManager.INSTANCE.getProperty("locale.eng.btn.logout"));
                    break;
                }
            }
        return "/servicehotels";
    }
}
