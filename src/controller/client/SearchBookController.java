package controller.client;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet(urlPatterns = { "/search-book" })
public class SearchBookController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		String categoryName ="all";  //req.getParameter("categoryName");

		CategoryService categoryService = new CategoryServiceImpl();
		BookService bookService = new BookServiceImpl();
		List<Book> bookList;
		if (categoryName.equals("all")) {
			bookList = bookService.searchByName(keyword);
		} else {
			Category category = categoryService.getByName(categoryName);
			bookList = bookService.searchByNC(keyword, category);
		}

		req.setAttribute("bookList", bookList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/allbooklist.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		String categoryName = req.getParameter("categoryName");

		CategoryService categoryService = new CategoryServiceImpl();
		BookService bookService = new BookServiceImpl();
		List<Book> bookList;
		if (categoryName.equals("all")) {
			bookList = bookService.searchByName(keyword);
		} else {
			Category category = categoryService.getByName(categoryName);
			bookList = bookService.searchByNC(keyword, category);
		}

		req.setAttribute("bookList", bookList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/book/SearchResultBook.jsp");
		dispatcher.forward(req, resp);
	}
}
