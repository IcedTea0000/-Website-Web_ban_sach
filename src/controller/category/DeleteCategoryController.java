package controller.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CategoryService;
import service.impl.CategoryServiceImpl;

@WebServlet (urlPatterns= {"/admin/category/delete"})
public class DeleteCategoryController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		CategoryService categoryService=CategoryServiceImpl.getInstance();
		categoryService.delete(id);
		
		//redirect to search-all result
		resp.sendRedirect("search-result?keyword=");
	}
}
