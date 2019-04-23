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
import model.Category;
import service.BookService;
import service.CategoryService;
import service.impl.BookServiceImpl;
import service.impl.CategoryServiceImpl;

@WebServlet (urlPatterns= {"/category-info"})
public class ClientGetCategoryInfoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		CategoryService categoryService=CategoryServiceImpl.getInstance();
		Category category=categoryService.getById(id);
		BookService bookService=BookServiceImpl.getInstance();
		List<Book> bookList=bookService.searchByNC("", category); 

		req.setAttribute("category", category);
		req.setAttribute("bookList", bookList);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/view/categorydetail.jsp");
		dispatcher.forward(req, resp);
	}
}
