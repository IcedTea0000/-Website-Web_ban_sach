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

@WebServlet (urlPatterns= {"/admin/user/get-info"})
public class GetUserInfoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idToGet=Integer.parseInt(req.getParameter("id"));
		UserService userService=new UserServiceImpl();
		User user=userService.getById(idToGet);
		req.setAttribute("user", user);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/view/admin/user/GetUserInfo.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
