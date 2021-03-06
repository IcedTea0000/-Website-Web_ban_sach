package controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import service.BookService;
import service.impl.BookServiceImpl;

@WebServlet (urlPatterns={"/book-info"})//?id=1
public class ClientGetBookInfoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookId=Integer.parseInt(req.getParameter("id"));
		BookService bookService=BookServiceImpl.getInstance();
		Book book=bookService.getById(bookId);
		req.setAttribute("book", book);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/view/bookdetail.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
