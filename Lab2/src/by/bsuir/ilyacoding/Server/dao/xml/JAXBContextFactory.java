package by.bsuir.ilyacoding.Server.dao.xml;

import by.bsuir.ilyacoding.Server.dao.exception.DAOException;
import by.bsuir.ilyacoding.Server.domain.AffairArchive;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public class JAXBContextFactory {

    private static final Object lock = new Object();
    private static JAXBContext instance;
    private static String affairFile = "affairs.xml";
    private static String userFile = "user.xml";

    public static JAXBContext getContext() throws DAOException {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    try {
                        instance = JAXBContext.newInstance(AffairArchive.class, XmlUserDAO.UserStock.class);
                    } catch (JAXBException e) {
                        throw new DAOException(e);
                    }
                }
            }
        }
        return instance;
    }

    public static String getAffairFile() {
        File file = new File(affairFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ignored) {}
        }

        return affairFile;
    }

    public static String getUserFile() {
        File file = new File(userFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ignored) {}
        }

        return userFile;
    }
}
