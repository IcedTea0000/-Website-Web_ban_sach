package model;

import java.util.Map;

public class Cart {
	private Map<Integer, CartItem> cartItemMap;
	private double totalPrice;

	public Cart() {
	}

	public Cart(Map<Integer, CartItem> cartItemMap, double totalPrice) {
		this.cartItemMap = cartItemMap;
		this.totalPrice = totalPrice;
	}

	public Map<Integer, CartItem> getCartItemMap() {
		return cartItemMap;
	}

	public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
		this.cartItemMap = cartItemMap;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
