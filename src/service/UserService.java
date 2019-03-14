package service;

import java.util.List;

import model.User;

public interface UserService {

	public void add(User newUser);

	public void update(User newUser);

	public void delete(int userId);

	public User getById(int userId);

	public User getByUsername(String username);

	public User getByUP(String username, String password);
	
	public boolean checkUserNameExisted(String username);

	public List<User> searchByName(String name);

	public List<User> searchByUsername(String username);
}
