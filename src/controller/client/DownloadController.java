package controller.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet(urlPatterns = { "/download" }) // ?folder=user/book/category&filename=123.jpg
public class DownloadController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/png");
		String folder = req.getParameter("folder");
		String fileName = req.getParameter("filename");

		String PICTURE_FOLDER = "D:\\javaWorkspace\\GreatBookList\\WebContent\\view\\images\\" + folder;

		File file = new File(PICTURE_FOLDER + File.separator + fileName);
		FileInputStream inputStream=new FileInputStream(file);
		
		IOUtils.copy(inputStream, resp.getOutputStream());
	}

}
