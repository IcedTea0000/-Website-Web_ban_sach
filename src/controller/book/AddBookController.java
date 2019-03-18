package controller.book;

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

@WebServlet(urlPatterns = { "/admin/book/add" })
public class AddBookController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> categoryList = categoryService.searchByName("");
		req.setAttribute("categoryList", categoryList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/book/AddBook.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		double price = Double.parseDouble(req.getParameter("price"));
		String author = req.getParameter("author");
		int stock = Integer.parseInt(req.getParameter("stock"));
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = categoryService.getByName(req.getParameter("categoryName"));

		Book newBook = new Book(title, description, price, category, author, stock);
		BookService bookService = new BookServiceImpl();
		bookService.add(newBook);

		// redirect to search-all result
		resp.sendRedirect("search-result?categoryName=all&keyword=");
	}
}
