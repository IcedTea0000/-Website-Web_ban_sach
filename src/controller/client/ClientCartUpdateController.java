package controller.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CartItem;
import service.CartItemService;
import service.impl.CartItemServiceImpl;

@WebServlet (urlPatterns={"/cart/update-quantity"})
public class ClientCartUpdateController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int newQuantity=Integer.parseInt(req.getParameter("quantity_input"));
		int bookId=Integer.parseInt(req.getParameter("bookId"));
		CartItemService cartItemService=CartItemServiceImpl.getInstance();
		HttpSession session=req.getSession();
		
		//update cart Item quantity in session
		
		Map<Integer, CartItem> cartItemMap=(HashMap)session.getAttribute("cartItemMap");
		CartItem cartItemToUpdate=cartItemMap.get(bookId);
		cartItemToUpdate.setQuantityInCart(newQuantity);
		cartItemMap.put(bookId, cartItemToUpdate);
		session.setAttribute("cartItemMap", cartItemMap);
		
		///if userAccount not null, update cart Item quantity in db
		if (session.getAttribute("userAccount")!=null){
			cartItemService.update(cartItemToUpdate);
		}		
		
		//redirect to cart
		resp.sendRedirect(req.getContextPath() + "/cart");
	}
}
