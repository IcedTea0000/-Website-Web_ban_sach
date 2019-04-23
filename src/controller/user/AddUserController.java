package controller.user;

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

@WebServlet(urlPatterns = { "/admin/user/add" })
public class AddUserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/user/AddUser.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		String info = req.getParameter("info");
		UserServiceImpl userService = UserServiceImpl.getInstance();

		if (!userService.checkUserNameExisted(username)) {
			User newUser = new User(name, address, username, password, role, info);
			// add newUser to SQL db
			userService.add(newUser);
			// forward to search "all" result
			resp.sendRedirect(req.getContextPath()+"/admin/user/search-result"+"?keyword=");

		}
		else {
			req.setAttribute("checkUserExisted", "Username existed");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/user/AddUser.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
