package controller.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.CartItem;
import model.CartOrder;
import model.User;
import service.BookService;
import service.CartItemService;
import service.CartOrderService;
import service.impl.BookServiceImpl;
import service.impl.CartItemServiceImpl;
import service.impl.CartOrderServiceImpl;

@WebServlet (urlPatterns={"/cart/checkout"})
public class ClientCheckOutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		User userAccount=(User)session.getAttribute("userAccount");
		//check if user is login
		if (userAccount==null){
			resp.sendRedirect(req.getContextPath()+"/login");
		}
		else {
			//check if cart is empty or not
			
			//create cart order and save to userAccount
			Map<Integer, CartItem> cartItemMap=(HashMap)session.getAttribute("cartItemMap");
			Date currentDate= new Date();
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
			String dayBuy=dateFormat.format(currentDate);
			int userId=userAccount.getId();
			
			CartOrder cartOrder=new CartOrder(userId, cartItemMap, dayBuy, "processing");
			CartOrderService cartOrderService=new CartOrderServiceImpl();
			int cartOrderId=cartOrderService.add(cartOrder);
			
			//update book quantity in db & update cartItem
			Set<Integer> keys=cartItemMap.keySet();
			for (Integer key: keys){
				CartItem cartItem=cartItemMap.get(key);
				
				cartItem.setCartOrderId(cartOrderId);
				CartItemService cartItemService=new CartItemServiceImpl();
				cartItemService.update(cartItem);
				
				Book bookInDb=cartItem.getBook();
				int currentStock=bookInDb.getStock();
				bookInDb.setStock(currentStock-cartItem.getQuantityInCart());
				BookService bookService=new BookServiceImpl();
				bookService.update(bookInDb);
				
			}
			
			
			
			//redirect to checkout success
			resp.sendRedirect(req.getContextPath()+"/view/checkout-success.jsp");
		}
	}
}
