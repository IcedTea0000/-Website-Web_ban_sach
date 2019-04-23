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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.User;
import service.BookService;
import service.UserService;
import service.impl.BookServiceImpl;
import service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/register.jsp");
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
				if (file.getFieldName().equals("name")) {
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
				}
				if (file.getFieldName().equals("picture_name")) {
					if (file.getSize() > 0) {
						// get file's name
						String originalName = file.getName();
						int index = originalName.lastIndexOf("\\");
						String pictureName = originalName.substring(index + 1);
						newUser.setPicture_name(pictureName);

						newUser.setRole("member");

						// save file to db
						String PICTURE_FOLDER = "D:\\javaWorkspace\\GreatBookList\\WebContent\\view\\images\\user\\";
						File pictureFile = new File(PICTURE_FOLDER + pictureName);
						file.write(pictureFile);

						UserService userService = UserServiceImpl.getInstance();
						userService.add(newUser);
					}
				}
			}
			resp.sendRedirect("login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
