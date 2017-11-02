package by.bsuir.ilyacoding.service;

import by.bsuir.ilyacoding.service.exception.ServiceException;

public interface EncodingService {
    String getHash(String str) throws ServiceException;
}
