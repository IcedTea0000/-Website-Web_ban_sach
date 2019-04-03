package model;

import java.util.Map;

public class CartOrder {
	int id;
	int userId;
	Map<Integer, CartItem> cartItemMap;
	String dayBuy;
	String status;

	public CartOrder() {
	}

	public CartOrder(int userId, Map<Integer, CartItem> cartItemMap, String dayBuy,String status) {
		this.userId = userId;
		this.cartItemMap = cartItemMap;
		this.dayBuy = dayBuy;
		this.status=status;//processing,shipping,completed
	}

	public CartOrder(int id,int userId, Map<Integer, CartItem> cartItemMap, String dayBuy,String status) {
		this.id=id;
		this.userId = userId;
		this.cartItemMap = cartItemMap;
		this.dayBuy = dayBuy;
		this.status=status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Map<Integer, CartItem> getCartItemMap() {
		return cartItemMap;
	}

	public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
		this.cartItemMap = cartItemMap;
	}

	public String getDayBuy() {
		return dayBuy;
	}

	public void setDayBuy(String dayBuy) {
		this.dayBuy = dayBuy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
