package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import model.Book;
import model.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

public class BookDaoImpl extends JDBCConnection implements BookDao {

	@Override
	public void add(Book newBook) {
		// add object newBook to SQL db
		String sql = "insert into web_ban_sach.book (title,description, price, category_id, author, stock) values (?,?,?,?,?,?)";
		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newBook.getTitle());
			statement.setString(2, newBook.getDescription());
			statement.setDouble(3, newBook.getPrice());
			statement.setInt(4, newBook.getCategory().getId());
			statement.setString(5, newBook.getAuthor());
			statement.setInt(6, newBook.getStock());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Book newBook) {
		// update book's information on SQL db where id=newBook.id
		String sql = "update web_ban_sach.book set title=?,description=?,price=?,category_id=?,author=?,stock=? where (id=?)";
		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, newBook.getTitle());
			statement.setString(2, newBook.getDescription());
			statement.setDouble(3, newBook.getPrice());
			statement.setInt(4, newBook.getCategory().getId());
			statement.setString(5, newBook.getAuthor());
			statement.setInt(6, newBook.getStock());
			statement.setInt(7, newBook.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Book getById(int bookId) {
		// get object book with id matches bookId on SQL db
		String sql = "select * from web_ban_sach.book where id=?";
		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, bookId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				double price = resultSet.getDouble("price");
				int category_id = resultSet.getInt("category_id");
				String author = resultSet.getString("author");
				int stock = resultSet.getInt("stock");

				CategoryService categoryService = new CategoryServiceImpl();
				Category category = categoryService.getById(category_id);
				Book book = new Book(id, title, description, price, category, author, stock);
				return book;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(int bookId) {
		// delete book with id matches bookId on SQL db
		String sql = "delete from web_ban_sach.book where (id=?)";

		Connection conn = super.getConn();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, bookId);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> searchByName(String bookName) {
		// search SQL db and return a list of books with names containing
		// bookName
		String sql = "select * from web_ban_sach.book where title like ?";

		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%" + bookName + "%");
			ResultSet resultSet = statement.executeQuery();
			List<Book> bookList=new ArrayList<Book>();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				double price = resultSet.getDouble("price");
				int category_id = resultSet.getInt("category_id");
				String author = resultSet.getString("author");
				int stock = resultSet.getInt("stock");

				CategoryService categoryService = new CategoryServiceImpl();
				Category category = categoryService.getById(category_id);
				Book book = new Book(id, title, description, price, category, author, stock);
				bookList.add(book);
			}
			return bookList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> searchByNC(String bookName, Category category) {
		// search SQL db and return a list of books with names containing
		// bookName and
		// category matches category
		String sql = "select * from web_ban_sach.book where category_id=? and title like ?";

		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, category.getId());
			statement.setString(2, "%" + bookName + "%");
			ResultSet resultSet = statement.executeQuery();
			List<Book> bookList=new ArrayList<Book>();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				double price = resultSet.getDouble("price");
				int category_id = resultSet.getInt("category_id");
				String author = resultSet.getString("author");
				int stock = resultSet.getInt("stock");

				CategoryService categoryService = new CategoryServiceImpl();
				Category newCategory = categoryService.getById(category_id);
				Book book = new Book(id, title, description, price, category, author, stock);
				bookList.add(book);
			}
			return bookList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
