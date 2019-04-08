package controller.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartItemDao;
import dao.impl.CartItemDaoImpl;

@WebServlet (urlPatterns={"/cart/delete"}) //?cart-item-id=?
public class ClientCartDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cartItemId=Integer.parseInt(req.getParameter("cart-item-id"));
		CartItemDao cartItemDao=new CartItemDaoImpl();
		cartItemDao.delete(cartItemId);
		
		//redirect to cart
		resp.sendRedirect(req.getContextPath()+"/cart");
	}
}
