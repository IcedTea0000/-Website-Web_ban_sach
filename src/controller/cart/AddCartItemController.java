package controller.cart;

import java.io.IOException;
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
import model.Cart;
import model.CartItem;
import model.User;
import service.impl.BookServiceImpl;
import service.impl.CartItemServiceImpl;
import service.impl.UserServiceImpl;
import service.BookService;
import service.CartItemService;
import service.UserService;

@WebServlet(urlPatterns = { "/cart/add" }) // ?book_id=1
public class AddCartItemController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int bookId = Integer.parseInt(req.getParameter("book_id"));
		CartItem cartItem;
		int quantityInCart;
		BookService bookService = new BookServiceImpl();
		UserService userService = new UserServiceImpl();
		CartItemService cartItemService = new CartItemServiceImpl();

		HttpSession session = req.getSession();
		Book bookAddToCart = bookService.getById(bookId);
		User user = (User) session.getAttribute("userAccount");
		Map<Integer, CartItem> cartItemMap = new HashMap<>();

		// check if cart session existing
		if (session.getAttribute("cartItemMap") == null) {
			quantityInCart = 1;
		} else {
			cartItemMap = (HashMap) session.getAttribute("cartItemMap");
			// check if book existing in cart
			if (cartItemMap.get(bookId) == null) {
				// no, add book to cart
				quantityInCart = 1;
			} else {
				// yes, add quantityInCart +1
				quantityInCart = cartItemMap.get(bookId).getQuantityInCart();
				quantityInCart++;
			}
		}

		// check if user login already
		if (user != null) {
			// save cartItem to db
			cartItem = new CartItem(user.getId(), bookAddToCart, quantityInCart, 0);
			cartItemService.add(cartItem);
		} else {
			
			cartItem = new CartItem(bookAddToCart, quantityInCart, 0);
		}
		
		cartItemMap.put(bookId, cartItem);		

		session.setAttribute("cartItemMap", cartItemMap);

		// redirect to cart
		resp.sendRedirect(req.getContextPath() + "/cart");
	}
}
