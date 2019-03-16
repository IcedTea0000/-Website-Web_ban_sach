package controller.category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/update" })
public class UpdateCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = categoryService.getById(id);

		req.setAttribute("category", category);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/category/UpdateCategory.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String description=req.getParameter("description");
		Category newCategory=new Category(id,name,description);
		
		CategoryService categoryService=new CategoryServiceImpl();
		categoryService.update(newCategory);
		
		//redirect to search-all result
		resp.sendRedirect("search-result?keyword=");
	}

}
