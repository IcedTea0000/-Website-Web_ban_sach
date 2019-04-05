package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import model.User;

public class UserDaoImpl extends JDBCConnection implements UserDao {

	@Override
	public void add(User newUser) {
		// add newUser object to SQL db
		String sql = "insert into web_ban_sach.user (name,address,username,password,role,info,picture_name)" + "values(?,?,?,?,?,?,?)";
		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newUser.getName());
			statement.setString(2, newUser.getAddress());
			statement.setString(3, newUser.getUsername());
			statement.setString(4, newUser.getPassword());
			statement.setString(5, newUser.getRole());
			statement.setString(6, newUser.getInfo());
			statement.setString(7, newUser.getPicture_name());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(User newUser) {
		// update user's information on SQL db where id=newUser.id
		String sql = "update web_ban_sach.user set name=?, address=?, username=?, password=?, info=?,picture_name=? " + "where (id=?)";
		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newUser.getName());
			statement.setString(2, newUser.getAddress());
			statement.setString(3, newUser.getUsername());
			statement.setString(4, newUser.getPassword());
			statement.setString(5, newUser.getInfo());
			statement.setString(6, newUser.getPicture_name());
			
			statement.setInt(7, newUser.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int userId) {
		// delete user with id matches userId on SQL db
		String sql = "delete from web_ban_sach.user " + "where (id=?)";
		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, userId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public User getById(int userId) {
		// get cetegory object from SQL db where id matches userId
		String sql = "select * from web_ban_sach.user " + "where id=?";
		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, userId);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(userId);
				user.setName(resultSet.getString("name"));
				user.setAddress(resultSet.getString("address"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setRole(resultSet.getString("role"));
				user.setInfo(resultSet.getString("info"));
				user.setPicture_name(resultSet.getString("picture_name"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getByUsername(String username) {
		// search SQL db and return an user object with username matches argument
		String sql = "select * from web_ban_sach.user " + "where username=?";
		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setAddress(resultSet.getString("address"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setRole(resultSet.getString("role"));
				user.setInfo(resultSet.getString("info"));
				user.setPicture_name(resultSet.getString("picture_name"));

				return user;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getByUP(String username, String password) {
		// search SQL db and return an user object with username and password match
		// arguments
		User user = getByUsername(username);
		if ((user != null) && (user.getPassword().equals(password)))
			return user;
		return null;
	}

	@Override
	public List<User> searchByName(String name) {
		// search SQL db and return a list of users with names containing name
		List<User> userList = new ArrayList<User>();
		String sql = "select * from web_ban_sach.user where name like ?";
		Connection conn = super.getConn();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%" + name + "%");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setAddress(resultSet.getString("address"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setRole(resultSet.getString("role"));
				user.setInfo(resultSet.getString("info"));
				user.setPicture_name(resultSet.getString("picture_name"));

				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public List<User> searchByUsername(String username) {
		// search SQL db and return a list of users with usernames containing username
		List<User> userList = new ArrayList<User>();
		String sql = "select * from web_ban_sach.user where username like ?";
		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%" + username + "%");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setAddress(resultSet.getString("address"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setRole(resultSet.getString("role"));
				user.setInfo(resultSet.getString("info"));
				user.setPicture_name(resultSet.getString("picture_name"));

				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public boolean checkUserNameExisted(String username) {
		// check in SQL db if there is username existed
		User checkUser = getByUsername(username);
		if (checkUser != null)
			return true;
		else
			return false;
	}

}
