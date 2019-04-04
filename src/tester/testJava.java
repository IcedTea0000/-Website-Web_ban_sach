package tester;

import java.util.HashMap;
import java.util.Map;

import dao.CartOrderDao;
import dao.impl.CartOrderDaoImpl;
import model.CartItem;
import model.CartOrder;

public class testJava {

	public static void main(String[] args) {
		CartOrderDao cartOrderDao=new CartOrderDaoImpl();
		Map<Integer, CartItem> cartItemMap=new HashMap<Integer, CartItem>();
		CartOrder cartOrder=new CartOrder(0, cartItemMap, "test", "test");
		int cartOrderId= cartOrderDao.add(cartOrder);
		System.out.println("id: "+cartOrderId);
	}

}
