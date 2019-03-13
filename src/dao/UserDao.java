package dao;

import java.util.List;

import model.User;

public interface UserDao {

	public void add(User newUser);

	public void update(User newUser);

	public void delete(int userId);

	public User getById(int userId);

	public User getByUsername(String username);

	public User getByUP(String username, String password);

	public List<User> searchByName(String name);

	public List<User> searchByUsername(String username);
}
