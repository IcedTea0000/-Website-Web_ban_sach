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

@WebServlet(urlPatterns = { "/admin/book/update" })
public class UpdateBookController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookId=Integer.parseInt(req.getParameter("id"));
		BookService bookService=new BookServiceImpl();
		Book oldBook=bookService.getById(bookId);
		req.setAttribute("oldBook", oldBook);
		
		CategoryService categoryService=new CategoryServiceImpl();
		List<Category> categoryList= categoryService.searchByName("");
		req.setAttribute("categoryList", categoryList);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/view/admin/book/UpdateBook.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String title=req.getParameter("title");
		String description=req.getParameter("description");
		String author=req.getParameter("author");
		double price=Double.parseDouble(req.getParameter("price"));
		int stock=Integer.parseInt(req.getParameter("stock"));
		int categoryId=Integer.parseInt(req.getParameter("categoryId"));		
		CategoryService categoryService=new CategoryServiceImpl();
		Category category=categoryService.getById(categoryId);
		Book newBook=new Book(id, title, description, price, category, author, stock);
		
		BookService bookService=new BookServiceImpl();
		bookService.update(newBook);
		
		//send redirect to search-all result
		resp.sendRedirect("search-result?categoryName=all&keyword=");
	}
}
