package tester;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.CartOrderDao;
import dao.impl.CartOrderDaoImpl;
import model.Book;
import model.CartItem;
import model.CartOrder;
import service.CartItemService;
import service.CartOrderService;
import service.impl.CartItemServiceImpl;
import service.impl.CartOrderServiceImpl;

public class testJava {

	public static void main(String[] args) {
		int userId=1;
		System.out.println("userid="+userId);
		CartOrderService cartOrderService=new CartOrderServiceImpl();
		
		List<CartOrder> cartOrderList=cartOrderService.searchByUserId(userId);
		//req.setAttribute("cartOrderList", cartOrderList);
		System.out.println("finish create cart order list");
		
		//search cartItemList for each cartOrder, put in a Map
		CartItemService cartItemService=new CartItemServiceImpl();
		Map<Integer, CartItem>cartItemMap;
		Map<Integer, Map<Integer,CartItem>>allCartItemMap=new HashMap<>();
		
		for(CartOrder cartOrder:cartOrderList){
			cartItemMap=cartItemService.searchByOrderId(cartOrder.getId());
			allCartItemMap.put(cartOrder.getId(), cartItemMap);
			
			System.out.println("cartOrderId: "+cartOrder.getId());
			
			
			
			System.out.println("book: "+book.getTitle());
			}
		}
		//req.setAttribute("allCartItemMap", allCartItemMap);
	}

}
