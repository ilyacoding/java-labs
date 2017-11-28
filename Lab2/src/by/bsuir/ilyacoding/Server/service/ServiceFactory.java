package by.bsuir.ilyacoding.Server.service;

import by.bsuir.ilyacoding.Server.service.impl.AffairServiceImpl;
import by.bsuir.ilyacoding.Server.service.impl.UserServiceImpl;

public class ServiceFactory {

	private static ServiceFactory instance;
	private static final Object lock = new Object();

	private final AffairService affairService = new AffairServiceImpl();
	private final UserService userService = new UserServiceImpl();

	public AffairService getAffairService() {
		return affairService;
	}

	public UserService getUserService() {
		return userService;
	}

	public static ServiceFactory getInstance() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new ServiceFactory();
				}
			}
		}
		return instance;
	}
}
