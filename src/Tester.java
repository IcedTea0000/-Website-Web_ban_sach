import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.CategoryDaoImpl;
import dao.impl.UserDaoImpl;
import model.Book;
import model.CartItem;
import model.Category;
import model.User;
import service.BookService;
import service.CartItemService;
import service.CategoryService;
import service.UserService;
import service.impl.BookServiceImpl;
import service.impl.CartItemServiceImpl;
import service.impl.CategoryServiceImpl;
import service.impl.UserServiceImpl;

public class Tester {
	// testing methods and objects

	public static void main(String[] args) {
		CartItemService cartItemService = new CartItemServiceImpl();
		Map<Integer, CartItem> cartItemMap = cartItemService.searchByOrderId(1);
		Set<Integer>keyList=cartItemMap.keySet();
			for(Integer key:keyList){
				System.out.println(cartItemMap.get(key).getBook().getTitle());
		}
	}

}
