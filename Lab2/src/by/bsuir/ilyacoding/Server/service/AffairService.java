package by.bsuir.ilyacoding.Server.service;

import by.bsuir.ilyacoding.Server.domain.Affair;
import by.bsuir.ilyacoding.Server.domain.AffairArchive;
import by.bsuir.ilyacoding.Server.service.exception.ServiceException;

public interface AffairService {
    Affair getAffairById(int id) throws ServiceException;

    void addAffair(Affair Affair) throws ServiceException;

    void updateAffairById(int id, Affair Affair) throws ServiceException;

    void deleteAffairById(int id) throws ServiceException;

    AffairArchive getAll() throws ServiceException;
}
