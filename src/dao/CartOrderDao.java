package dao;

import java.util.List;

import model.CartOrder;

public interface CartOrderDao {

	public int add(CartOrder cartOrder);

	public void delete(int cartOrderId);

	public CartOrder getById(int cartOrderId);

	public List<CartOrder> searchByUserId(int userId);
}
