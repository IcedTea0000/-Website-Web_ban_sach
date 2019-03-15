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

@WebServlet(urlPatterns = { "/admin/update-user" })
public class UpdateUserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userId"));
		UserService userService = new UserServiceImpl();
		User userToEdit = userService.getById(userId);
		req.setAttribute("userToEdit", userToEdit);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/user/UpdateUser.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		String info = req.getParameter("info");

		UserService userService = new UserServiceImpl();
		User updatedUser = new User(id, name, address, username, password, role, info);
		System.out.println(updatedUser.getId());
		// add updatedUser to SQL db
		userService.update(updatedUser);
		// forward to search "all" result
		resp.sendRedirect(req.getContextPath() + "/admin/user/search-result" + "?keyword=");
	}

}
