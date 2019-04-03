package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.CartItemDao;
import dao.CartOrderDao;
import model.Book;
import model.CartItem;
import model.CartOrder;
import service.BookService;
import service.impl.BookServiceImpl;

public class CartOrderDaoImpl extends JDBCConnection implements CartOrderDao {

	@Override
	public int add(CartOrder cartOrder) {
		// add cartOrder to SQL db
		Connection conn=super.getConn();
		String sql="INSERT INTO web_ban_sach.cart_order (user_id, day_buy, status) VALUES (?,?,?)";
		try {
			PreparedStatement statement= conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, cartOrder.getUserId());
			statement.setString(2, cartOrder.getDayBuy());
			statement.setString(3, cartOrder.getStatus());
			
			statement.execute();
			ResultSet rs=statement.getGeneratedKeys();
			
			int cartOrderId=0;
			if (rs.next()) {
				cartOrderId=rs.getInt("id");
			}
			return cartOrderId;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return 0;
	}

	@Override
	public void delete(int cartOrderId) {
		// delete cartOrder from SQL db
		Connection conn=super.getConn();
		String sql="DELETE FROM web_ban_sach.cart_order WHERE (id = ?)";
		
		try {
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setInt(1, cartOrderId);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public CartOrder getById(int cartOrderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartOrder> searchByUserId(int userId) {
		// Search db for all cartOrder based on userId
		String sql = "select * from web_ban_sach.cart_order where (user_id=?)";

		Connection conn = super.getConn();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			List<CartOrder> cartOrderList=new ArrayList<CartOrder>();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String dayBuy = resultSet.getString("day_buy");
				String status= resultSet.getString("status");
				
				CartItemDao cartItemDao=new CartItemDaoImpl();
				Map<Integer, CartItem> cartItemMap=cartItemDao.searchByOrderId(id);
				CartOrder cartOrder=new CartOrder(id,userId , cartItemMap, dayBuy, status);
				cartOrderList.add(cartOrder);
			}
			return cartOrderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
