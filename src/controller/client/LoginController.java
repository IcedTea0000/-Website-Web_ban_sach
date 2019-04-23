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

import model.CartItem;
import model.User;
import service.CartItemService;
import service.UserService;
import service.impl.CartItemServiceImpl;
import service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		UserService userService = UserServiceImpl.getInstance();
		User user = userService.getByUP(username, password);

		if (user == null) {
			req.setAttribute("errorMessage", "Wrong username or password");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/view/login.jsp");
			dispatcher.forward(req, resp);
		} else {
			CartItemService cartItemService = CartItemServiceImpl.getInstance();

			HttpSession session = req.getSession();
			session.setAttribute("userAccount", user);
			session.setMaxInactiveInterval(30 * 60);

			// check for session cartMap existed
			Map<Integer, CartItem> cartItemMap;
			if (session.getAttribute("cartItemMap") == null) {
				cartItemMap = new HashMap<>();
			} else {
				cartItemMap = (HashMap) session.getAttribute("cartItemMap");
				// update new books to client's cartItem list in db
				Set<Integer> keyList = cartItemMap.keySet();
				

				for (Integer key : keyList) {
					CartItem cartItem = cartItemMap.get(key);
					cartItem.setUserId(user.getId());
					CartItem oldCartItem = cartItemService.get(user.getId(), cartItem.getBook().getId());
					if (oldCartItem != null) {
						int quantityInCart = cartItem.getQuantityInCart();
						quantityInCart += oldCartItem.getQuantityInCart();
						cartItem.setQuantityInCart(quantityInCart);
					}

					cartItemService.add(cartItem);
				}



			}
			// generate new cartList session
			cartItemMap = cartItemService.searchItemInCart(user.getId());
			
			// save new cartItemMap session
			session.setAttribute("cartItemMap", cartItemMap);
			session.setAttribute("cartItemSize", cartItemMap.size());

			// redirect to book list
			
			resp.sendRedirect("/GreatBookList/book-list");
		}
	}
}
