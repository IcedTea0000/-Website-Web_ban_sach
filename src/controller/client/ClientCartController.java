package controller.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.CartItem;
import model.User;
import service.BookService;
import service.CartItemService;
import service.UserService;
import service.impl.BookServiceImpl;
import service.impl.CartItemServiceImpl;
import service.impl.UserServiceImpl;

@WebServlet (urlPatterns={"/cart"})
public class ClientCartController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double totalPrice = 0;
		double bookPrice=0;
		
		//if user login, get cart from db
		HttpSession session=req.getSession();
		User currentLogin=(User)session.getAttribute("userAccount");
		Map<Integer, CartItem> cartItemMap;
		
		if (currentLogin!=null){
			CartItemService cartItemService=new CartItemServiceImpl();
			cartItemMap= cartItemService.searchItemInCart(currentLogin.getId());
			session.setAttribute("cartItemMap", cartItemMap);
		}
		else
		{
			cartItemMap=(HashMap)session.getAttribute("cartItemMap");
		}
		
		Set<Integer> keyList = cartItemMap.keySet();
		for (Integer key : keyList) {
			bookPrice = cartItemMap.get(key).getBook().getPrice();
			totalPrice += bookPrice * cartItemMap.get(key).getQuantityInCart();
		}
		session.setAttribute("totalPrice", totalPrice);
	
		RequestDispatcher dispatcher=req.getRequestDispatcher("/view/cart.jsp");
		dispatcher.forward(req, resp);
	}
}
