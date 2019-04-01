package service;

import java.util.Map;

import model.CartItem;

public interface CartItemService {

	public void add(CartItem cartItem);
	
	public void delete(int cartItemId);
	
	public void update(CartItem cartItem);
	
	public Map<Integer, CartItem> searchItemInCart(int userId) ;
	
	public Map<Integer, CartItem> searchByOrderId (int cartOrderId);
	
}
