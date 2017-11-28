package by.bsuir.ilyacoding.Server.dao.xml;

import by.bsuir.ilyacoding.Server.dao.UserDAO;
import by.bsuir.ilyacoding.Server.dao.exception.DAOException;
import by.bsuir.ilyacoding.Server.domain.User;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class XmlUserDAO implements UserDAO {

    @XmlRootElement(name = "users")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class UserStock {

        @XmlElement(name = "user")
        List<User> users = new LinkedList<>();

    }


    @Override
    public boolean addUser(User user) throws DAOException {
        UserStock stock = new UserStock();

        stock.users = getAll();

        stock.users.add(user);

        try {
            writeStock(stock);
            return true;
        }
        catch (JAXBException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) throws DAOException {
        List<User> users = getAll();
        if (users == null) {
            return null;
        }
        return users.stream().filter((user) -> user.getLogin().equals(login) && user.getPassword().equals(password))
                .findFirst().orElse(null);
    }

    @Override
    public User getUserByLogin(String login) throws DAOException {
        List<User> list = getAll();
        if (list == null) {
            return null;
        }
        return list.stream().filter((user) -> user.getLogin().equalsIgnoreCase(login)).findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() throws DAOException {
        try {

            JAXBContext jc = JAXBContextFactory.getContext();
            Unmarshaller unmarshaller = jc.createUnmarshaller();

            UserStock stock = (UserStock) unmarshaller.unmarshal(new File(JAXBContextFactory.getUserFile()));
            if (stock == null) {
                stock = new UserStock();
            }
            return stock.users;

        } catch (UnmarshalException ignored) {
            return new LinkedList<>();
        }
        catch (JAXBException e) {
            throw new DAOException(e);
        }
    }

    private void writeStock(UserStock archive) throws DAOException, JAXBException {
        JAXBContext jc = JAXBContextFactory.getContext();
        Marshaller marshaller = jc.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(archive, new File(JAXBContextFactory.getUserFile()));
    }
}
