package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet (urlPatterns= {"/admin/user/delete-user"})
public class DeleteUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int deleteId=Integer.parseInt(req.getParameter("deleteId"));
		UserService userService=new UserServiceImpl();
		userService.delete(deleteId);
		
		//forward to search-all result
		resp.sendRedirect(req.getContextPath()+"/admin/user/search-result"+"?keyword=");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	
}
