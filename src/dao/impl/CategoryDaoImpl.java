package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDao;
import model.Category;

public class CategoryDaoImpl extends JDBCConnection implements CategoryDao {

	@Override
	public void add(Category newCategory) {
		// add newCategory object to SQL db
		String sql = "insert into web_ban_sach.category (name,description) values (?,?)";
		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newCategory.getName());
			statement.setString(2, newCategory.getDescription());
			statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Category newCategory) {
		// update category's information on SQL db where id=newCategory.id
		String sql = "update web_ban_sach.category set name=?,description=? where (id=?)";
		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newCategory.getName());
			statement.setString(2, newCategory.getDescription());
			statement.setInt(3, newCategory.getId());
			statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int categoryId) {
		// delete category with id matches categoryId on SQL db
		String sql = "delete from web_ban_sach.category where (id=?)";
		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, categoryId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Category getById(int categoryId) {
		// get category object from SQL db where id matches categoryId
		String sql = "select * from web_ban_sach.category where (categoryId=?)";
		Connection conn = super.getConn();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, categoryId);
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Category category = new Category(id, name, description);
				return category;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Category getByName(String categoryName) {
		// get category object from SQL db where name matches categoryName
		String sql = "select * from web_ban_sach.category where name=?";

		Connection conn = super.getConn();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, categoryName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Category category = new Category(id, name, description);
				return category;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> searchByName(String categoryName) {
		// search SQL db and return a list of categories with names containing
		// categoryName
		String sql = "select * from web_ban_sach.category where name like ?";
		Connection conn = super.getConn();
		List<Category> categoryList = new ArrayList<Category>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%" + categoryName + "%");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Category category = new Category(id, name, description);
				categoryList.add(category);
			}
			return categoryList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean checkCategoryExisted(String categoryName) {
		// check in SQL db if category
		Category checkCategory=getByName(categoryName);
		if (checkCategory!=null) return true;
		else return false;
	}

}
