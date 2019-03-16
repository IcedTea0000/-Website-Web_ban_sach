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

@WebServlet (urlPatterns= {"/admin/category/get-info"})
public class GetCategoryInfoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		CategoryService categoryService=new CategoryServiceImpl();
		Category category=categoryService.getById(id);
		System.out.println("name:"+category.getName());
		
		req.setAttribute("category", category);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/view/admin/category/GetCategoryInfo.jsp");
		dispatcher.forward(req, resp);
	}
}
