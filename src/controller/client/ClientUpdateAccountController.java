package controller.client;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.Book;
import model.Category;
import model.User;
import service.BookService;
import service.CategoryService;
import service.UserService;
import service.impl.BookServiceImpl;
import service.impl.CategoryServiceImpl;
import service.impl.UserServiceImpl;

@WebServlet (urlPatterns={"/user-update"})//?id=1
public class ClientUpdateAccountController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId=Integer.parseInt(req.getParameter("id"));
		UserService userService=new UserServiceImpl();
		User user=userService.getById(userId);
		
		req.setAttribute("user", user);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/view/updateuser.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);

		try {
			List<FileItem> fileList = fileUpload.parseRequest(req);
			User newUser = new User();

			for (FileItem file : fileList) {
				if (file.getFieldName().equals("id")) {
					int id = Integer.parseInt(file.getString());
					newUser.setId(id);
				} else if (file.getFieldName().equals("name")) {
					String name = file.getString();
					newUser.setName(name);
				}
				if (file.getFieldName().equals("address")) {
					String address = file.getString();
					newUser.setAddress(address);
				}
				if (file.getFieldName().equals("username")) {
					String username = file.getString();
					newUser.setUsername(username);
				}
				if (file.getFieldName().equals("password")) {
					String password = file.getString();
					newUser.setPassword(password);
				}
				if (file.getFieldName().equals("info")) {
					String info = file.getString();
					newUser.setInfo(info);
				} else if (file.getFieldName().equals("picture_name")) {
					// if new picture uploaded
					if (file.getSize() > 0) {
						//get new picture name
						String originalName=file.getName();
						int index=originalName.lastIndexOf("\\");
						String pictureName=originalName.substring(index+1);
						newUser.setPicture_name(pictureName);
						
						//upload picture 
						String PICTURE_FOLDER="D:\\javaWorkspace\\GreatBookList\\WebContent\\view\\images\\user\\";
						File pictureFile=new File(PICTURE_FOLDER+pictureName);
						file.write(pictureFile);
						
						
					} else {
						int userId=newUser.getId();
						UserService userService=new UserServiceImpl();
						User oldUser=userService.getById(userId);
						String oldPictureName=oldUser.getPicture_name();
						newUser.setPicture_name(oldPictureName);
					}
					UserService userService = new UserServiceImpl();
					userService.update(newUser);
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//update userAccount session
		
		// send redirect to login
		resp.sendRedirect(req.getContextPath()+"/logout");
	
	}
}
