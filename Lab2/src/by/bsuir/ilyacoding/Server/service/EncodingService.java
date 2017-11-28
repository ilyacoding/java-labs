package by.bsuir.ilyacoding.Server.service;

import by.bsuir.ilyacoding.Server.service.exception.ServiceException;

public interface EncodingService {
    String getHash(String str) throws ServiceException;
}
