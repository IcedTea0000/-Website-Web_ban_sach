package service.impl;

import java.util.List;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.UserService;

//call matching methods from UserDaoImpl
public class UserServiceImpl implements UserService {
	private UserDao userDaoImpl=new UserDaoImpl();
	
	@Override
	public void add(User newUser) {
		userDaoImpl.add(newUser);
	}

	@Override
	public void update(User newUser) {
		userDaoImpl.update(newUser);
	}

	@Override
	public void delete(int userId) {
		userDaoImpl.delete(userId);
	}

	@Override
	public User getById(int userId) {
		return userDaoImpl.getById(userId);
	}

	@Override
	public User getByUsername(String username) {
		return userDaoImpl.getByUsername(username);
	}

	@Override
	public User getByUP(String username, String password) {
		return userDaoImpl.getByUP(username, password);
	}

	@Override
	public List<User> searchByName(String name) {
		return userDaoImpl.searchByName(name);
	}

	@Override
	public List<User> searchByUsername(String username) {
		return userDaoImpl.searchByUsername(username);
	}

	@Override
	public boolean checkUserNameExisted(String username) {
		return userDaoImpl.checkUserNameExisted(username);
	}

}
