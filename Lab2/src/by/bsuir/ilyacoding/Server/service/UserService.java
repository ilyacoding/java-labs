package by.bsuir.ilyacoding.Server.service;

import by.bsuir.ilyacoding.Server.domain.User;
import by.bsuir.ilyacoding.Server.service.exception.ServiceException;

import java.util.List;

public interface UserService {
	
	boolean register(User user) throws ServiceException;
	User login(String login, String password) throws ServiceException;
	List<User> getAll() throws ServiceException;
}
