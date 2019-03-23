import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.CategoryDaoImpl;
import dao.impl.UserDaoImpl;
import model.Book;
import model.Category;
import model.User;
import service.BookService;
import service.CategoryService;
import service.UserService;
import service.impl.BookServiceImpl;
import service.impl.CategoryServiceImpl;
import service.impl.UserServiceImpl;

public class Tester {
	// testing methods and objects

	public static void main(String[] args) {
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = categoryService.getById(3);
		BookService bookService = new BookServiceImpl();
		List<Book> bookList = bookService.searchByNC("", category);
		if (bookList != null) {
			System.out.println(bookList.get(0).getTitle());
		} else
			System.out.println("null");
	}

}
