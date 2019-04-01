package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.BookDao;
import dao.CartItemDao;
import model.Book;
import model.CartItem;
import model.Category;
import service.BookService;
import service.CategoryService;
import service.impl.BookServiceImpl;
import service.impl.CategoryServiceImpl;

public class CartItemDaoImpl extends JDBCConnection implements CartItemDao {

	@Override
	public void add(CartItem cartItem) {
		// add cartItem to SQL db
		Connection conn = super.getConn();
		int userId = cartItem.getUserId();
		int bookId = cartItem.getBook().getId();
		int quantityInCart = cartItem.getQuantityInCart();
		int cartOrderId = cartItem.getCartOrderId();

		CartItem oldCartItem = get(userId, bookId);
		if (oldCartItem != null) {
			BookDao bookDao = new BookDaoImpl();
			Book book = bookDao.getById(bookId);
			CartItem newCartItem = new CartItem(oldCartItem.getId(), userId, book, quantityInCart, cartOrderId);
			update(newCartItem);
		} else {
			String sql = "INSERT INTO web_ban_sach.cart_item (user_id, book_id, quantity,cart_order_id) VALUES (?,?,?,?)";
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, userId);
				statement.setInt(2, bookId);
				statement.setInt(3, quantityInCart);
				statement.setInt(4, cartOrderId);

				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(int cartItemId) {
		// delete cartItem from SQL db
		Connection conn = super.getConn();
		String sql = "DELETE FROM web_ban_sach.cart_item WHERE (id = ?)";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, cartItemId);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(CartItem cartItem) {
		// update cartItem info to SQL db
		Connection conn = super.getConn();
		String sql = "UPDATE web_ban_sach.cart_item SET user_id =?,book_id=?,quantity=?,cart_order_id=? WHERE (id = ?)";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, cartItem.getUserId());
			statement.setInt(2, cartItem.getBook().getId());
			statement.setInt(3, cartItem.getQuantityInCart());
			statement.setInt(4, cartItem.getCartOrderId());
			statement.setInt(5, cartItem.getId());

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Map<Integer, CartItem> searchItemInCart(int userId) {
		// Search db for all cartItem based on userId
		String sql = "select * from web_ban_sach.cart_item where (user_id=?) and (cart_order_id=0)";

		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			Map<Integer, CartItem> cartMap = new HashMap<>();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int bookId = resultSet.getInt("book_id");
				int quantity = resultSet.getInt("quantity");

				BookService bookService = new BookServiceImpl();
				Book book = bookService.getById(bookId);
				CartItem cartItem = new CartItem(id, userId, book, quantity, 0);
				cartMap.put(bookId, cartItem);
			}
			return cartMap;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CartItem get(int userId, int bookId) {
		// Search db for all cartItem based on userId
		String sql = "select * from web_ban_sach.cart_item where (user_id=?) and (cart_order_id=0) and (book_id=?)";

		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, userId);
			statement.setInt(2, bookId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int quantity = resultSet.getInt("quantity");

				BookService bookService = new BookServiceImpl();
				Book book = bookService.getById(bookId);
				CartItem cartItem = new CartItem(id, userId, book, quantity, 0);
				return cartItem;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<Integer, CartItem> searchByOrderId(int cartOrderId) {
		// Search db for all cartItem based on cartOrderId
		String sql = "select * from web_ban_sach.cart_item where (cart_order_id=?)";

		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, cartOrderId);
			ResultSet resultSet = statement.executeQuery();
			Map<Integer, CartItem> cartMap = new HashMap<>();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int userId = resultSet.getInt("user_id");
				int bookId = resultSet.getInt("book_id");
				int quantity = resultSet.getInt("quantity");

				BookService bookService = new BookServiceImpl();
				Book book = bookService.getById(bookId);
				CartItem cartItem = new CartItem(id, userId, book, quantity, cartOrderId);
				cartMap.put(bookId, cartItem);
			}
			return cartMap;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
