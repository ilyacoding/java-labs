package by.bsuir.ilyacoding.service;

import by.bsuir.ilyacoding.domain.User;
import by.bsuir.ilyacoding.service.exception.ServiceException;

import java.util.List;

public interface UserService {
	
	boolean register(User user) throws ServiceException;
	boolean login(String login, String password) throws ServiceException;
	List<User> getAll() throws ServiceException;
}
