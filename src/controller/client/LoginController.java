package controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet (urlPatterns={"/login"})
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher=req.getRequestDispatcher("/view/client/Login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		UserService userService=new UserServiceImpl();
		User user= userService.getByUP(username, password);
		
		if (user==null){
			req.setAttribute("errorMessage", "Wrong username or password");
			RequestDispatcher dispatcher=req.getRequestDispatcher("/view/client/Login.jsp");
			dispatcher.forward(req, resp);	
		}
		else {
			HttpSession session=req.getSession();
			session.setAttribute("userAccount", user);
			session.setMaxInactiveInterval(30*60);
			
			//redirect ve trang chu
		}
	}
}
