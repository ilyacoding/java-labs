package by.bsuir.ilyacoding.Server.dao;

import by.bsuir.ilyacoding.Server.dao.exception.DAOException;
import by.bsuir.ilyacoding.Server.domain.Affair;
import by.bsuir.ilyacoding.Server.domain.AffairArchive;

public interface AffairDAO {

    Affair getAffairById(int id) throws DAOException;

    void addAffair(Affair affair) throws DAOException;

    void updateAffairById(int id, Affair affair) throws DAOException;

    void deleteAffairById(int id) throws DAOException;

    AffairArchive getAll() throws DAOException;
}
