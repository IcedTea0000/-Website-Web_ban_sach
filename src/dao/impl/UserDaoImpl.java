package dao.impl;

import java.util.List;

import dao.UserDao;
import model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(User newUser) {
		//add newUser object to SQL db
		
	}

	@Override
	public void update(User newUser) {
		// update user's information on SQL db where id=newUser.id
		
	}

	@Override
	public void delete(int userId) {
		// delete user with id matches userId on SQL db
		
	}

	@Override
	public User getById(int userId) {
		// get cetegory object from SQL db where id matches userId
		return null;
	}

	@Override
	public User getByUsername(String username) {
		// search SQL db and return an user object with username matches argument
		return null;
	}

	@Override
	public User getByUP(String username, String password) {
		// search SQL db and return an user object with username and password match arguments
		return null;
	}

	@Override
	public List<User> searchByName(String name) {
		// search SQL db and return a list of categories with names containing name
		return null;
	}

	@Override
	public List<User> searchByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
