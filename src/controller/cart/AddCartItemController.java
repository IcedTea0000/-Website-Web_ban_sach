package controller.cart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.CartItem;
import service.impl.BookServiceImpl;

import service.BookService;

@WebServlet(urlPatterns = { "/cart/add" }) // ?book_id=1
public class AddCartItemController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookId = Integer.parseInt(req.getParameter("book_id"));
		BookService bookService = new BookServiceImpl();
		Book book = bookService.getById(bookId);
		int quantityInCart;
		CartItem cartItem;
		Map<Integer, CartItem> cartMap;
		HttpSession session = req.getSession();

		// check if cartMap existing in session
		if (session.getAttribute("cartMap") == null) {
			// if no. Create cartItem and cartMap, add to session
			cartMap = new HashMap<>();
			quantityInCart = 1;
			cartItem = new CartItem(book, quantityInCart);
		} else {
			cartMap = (HashMap) session.getAttribute("cartMap");
			// if yes. Check if book existing in cartMap
			if (cartMap.get(bookId) == null) {
				// if no. Add new book to map
				quantityInCart = 1;
				cartItem = new CartItem(book, quantityInCart);
			} else {
				// if yes. Add quantity of book in map +1
				cartItem = cartMap.get(bookId);
				quantityInCart = cartItem.getQuantityInCart();
				quantityInCart++;
				cartItem = new CartItem(book, quantityInCart);
			}
		}
		cartMap.put(bookId, cartItem);
		session.setAttribute("cartMap", cartMap);
		resp.sendRedirect(req.getContextPath()+"/admin/cart");
	}
}
