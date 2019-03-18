package controller.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;
import service.impl.BookServiceImpl;

@WebServlet (urlPatterns={"/admin/book/delete"})
public class DeleteBookController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookId=Integer.parseInt(req.getParameter("id"));
		BookService bookService=new BookServiceImpl();
		
		bookService.delete(bookId);
		//redirect to search-all result
		resp.sendRedirect("search-result?categoryName=all&keyword=");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
