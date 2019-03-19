package controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/Register.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String role="member";
		String info=req.getParameter("info");
		
		UserService userService=new UserServiceImpl();
		
		if (userService.checkUserNameExisted(username)){
			req.setAttribute("checkUserExisted", "Username existed");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/Register.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			User newUser=new User(name, address, username, password, role, info);
			userService.add(newUser);
			resp.sendRedirect("login");
		}
	}
}
