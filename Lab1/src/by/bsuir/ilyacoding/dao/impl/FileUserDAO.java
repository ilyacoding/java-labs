package by.bsuir.ilyacoding.dao.impl;

import by.bsuir.ilyacoding.dao.AppendObjectOutputStream;
import by.bsuir.ilyacoding.dao.UserDAO;
import by.bsuir.ilyacoding.dao.exception.DAOException;
import by.bsuir.ilyacoding.domain.User;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileUserDAO implements UserDAO {

	private String filePath = "users.db";

	@Override
	public boolean addUser(User user) throws DAOException {
		ObjectOutputStream ous = null;
		File file = new File(filePath);
		try {
			if (file.exists()) {
				ous = new AppendObjectOutputStream(new FileOutputStream(file, true));
			}
			else {
				ous = new ObjectOutputStream(new FileOutputStream(file));
			}

			ous.writeObject(user);
			ous.flush();

			return true;
		}
		catch(IOException e) {
			throw new DAOException(e);
		}
		finally {
			if (ous != null) {
				try {
					ous.close();
				} catch (IOException e) {
					throw new DAOException(e);
				}
			}
		}
	}

	@Override
	public User getUserByLoginAndPassword(String login, String password) throws DAOException {
		List<User> users = getAll();

		return users.stream().filter((user) -> user.getLogin().equals(login) && user.getPassword().equals(password))
				.findFirst().orElse(null);
	}

	@Override
	public User getUserByLogin(String login) throws DAOException {
		List<User> users = getAll();

		return users.stream().filter((user) -> user.getLogin().equals(login))
				.findFirst().orElse(null);
	}

	@Override
	public List<User> getAll() throws DAOException {

		ObjectOutputStream ous = null;
		ObjectInputStream ois = null;
		File file = new File(filePath);
		List<User> users = new LinkedList<>();
		try {
			if (file.exists()) {
				ous = new AppendObjectOutputStream(new FileOutputStream(file, true));
			}
			else {
				ous = new ObjectOutputStream(new FileOutputStream(file, true));
			}
			ois = new ObjectInputStream(new FileInputStream(file));

			User user;
			while ((user = (User)ois.readObject()) != null) {
				users.add(user);
			}

			return users;
		}
		catch (EOFException ignored) {
			return users;
		}
		catch (IOException | ClassNotFoundException e) {
			throw new DAOException(e);
		}
		finally {
			if (ous != null) {
				try {
					ous.close();
				} catch (IOException e) {
					throw new DAOException(e);
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					throw new DAOException(e);
				}
			}
		}
	}

}
