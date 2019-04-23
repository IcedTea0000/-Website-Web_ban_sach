package controller.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.CartItem;
import model.CartOrder;
import service.CartItemService;
import service.CartOrderService;
import service.impl.CartItemServiceImpl;
import service.impl.CartOrderServiceImpl;

@WebServlet (urlPatterns={"/order-history"})//?userId=1
public class ClientCartOrderListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId=Integer.parseInt(req.getParameter("userId"));
		CartOrderService cartOrderService=CartOrderServiceImpl.getInstance();
		
		List<CartOrder> cartOrderList=cartOrderService.searchByUserId(userId);
		req.setAttribute("cartOrderList", cartOrderList);
		
		//search cartItemList for each cartOrder, put in a Map
		CartItemService cartItemService=CartItemServiceImpl.getInstance();
		Map<Integer, CartItem>cartItemMap;
		Map<Integer, Map<Integer,CartItem>>allCartItemMap=new HashMap<>();
		
		for(CartOrder cartOrder:cartOrderList){
			cartItemMap=cartItemService.searchByOrderId(cartOrder.getId());
			allCartItemMap.put(cartOrder.getId(), cartItemMap);
		}
		req.setAttribute("allCartItemMap", allCartItemMap);
		
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/view/UserOrderHistory.jsp");
		dispatcher.forward(req, resp);
	}
}
