package controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import service.BookService;
import service.impl.BookServiceImpl;

@WebServlet(urlPatterns = { "/offers" })
public class ClientBookOfferController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookService bookService=new BookServiceImpl();
		List<Book> bookSaleList= bookService.searchByStatus("sale");
		req.setAttribute("bookList", bookSaleList);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("view/allbooklist.jsp");
		dispatcher.forward(req, resp);
	}
}
