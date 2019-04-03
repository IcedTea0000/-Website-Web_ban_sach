package service.impl;

import java.util.List;

import dao.CartOrderDao;
import dao.impl.CartOrderDaoImpl;
import model.CartOrder;
import service.CartOrderService;

public class CartOrderServiceImpl implements CartOrderService {
	CartOrderDao cartOrderDao = new CartOrderDaoImpl();

	@Override
	public int add(CartOrder cartOrder) {
		// TODO Auto-generated method stub
		return cartOrderDao.add(cartOrder);
	}

	@Override
	public void delete(int cartOrderId) {
		// TODO Auto-generated method stub
		cartOrderDao.delete(cartOrderId);
	}

	@Override
	public CartOrder getById(int cartOrderId) {
		// TODO Auto-generated method stub
		return cartOrderDao.getById(cartOrderId);
	}

	@Override
	public List<CartOrder> searchByUserId(int userId) {
		// TODO Auto-generated method stub
		return cartOrderDao.searchByUserId(userId);
	}

}
