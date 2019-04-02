package controller.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet (urlPatterns={"/logout"})
public class LogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		session.removeAttribute("userAccount");
		session.removeAttribute("cartItemMap");
		
		//redirect to book list
		resp.sendRedirect("/GreatBookList/admin/book/search-result?categoryName=all&keyword=");

	}
}
