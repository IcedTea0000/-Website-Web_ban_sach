package dao;

import java.util.Map;

import model.CartItem;

public interface CartItemDao {

	public void add(CartItem cartItem);
	
	public void delete(int cartItemId);
	
	public void update(CartItem cartItem);
	
	public CartItem get(int userId, int bookId);
	
	public Map<Integer, CartItem> searchItemInCart(int userId) ;
	
	public Map<Integer, CartItem> searchByOrderId (int cartOrderId);
	
}
