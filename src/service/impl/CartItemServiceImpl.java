package service.impl;

import java.util.Map;

import dao.CartItemDao;
import dao.CartOrderDao;
import dao.impl.CartItemDaoImpl;
import dao.impl.CartOrderDaoImpl;
import model.CartItem;
import service.CartItemService;

public class CartItemServiceImpl implements CartItemService {
	CartItemDao cartItemDao=new CartItemDaoImpl();
	@Override
	public void add(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDao.add(cartItem);
	}

	@Override
	public void delete(int cartItemId) {
		// TODO Auto-generated method stub
		cartItemDao.delete(cartItemId);
	}

	@Override
	public void update(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDao.update(cartItem);
	}

	@Override
	public Map<Integer, CartItem> searchItemInCart(int userId) {
		// TODO Auto-generated method stub
		return cartItemDao.searchItemInCart(userId);
	}

	@Override
	public Map<Integer, CartItem> searchByOrderId(int cartOrderId) {
		// TODO Auto-generated method stub
		return cartItemDao.searchByOrderId(cartOrderId);
	}

	
}
