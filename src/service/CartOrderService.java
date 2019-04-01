package service;

import java.util.List;

import model.CartOrder;

public interface CartOrderService {

	public void add(CartOrder cartOrder);

	public void delete(int cartOrderId);

	public CartOrder getById(int cartOrderId);

	public List<CartOrder> searchByUserId(int userId);
}
