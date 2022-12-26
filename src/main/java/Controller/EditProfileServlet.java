package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.UserDao;
import Model.User;

/**
 * Servlet implementation class EditProfileServlet
 */
@MultipartConfig
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public EditProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		User u=(User) request.getSession().getAttribute("user");
		
		Part part = request.getPart("image");
		System.out.println(name + age + part.toString());

		String realPath = "D:\\source jsp\\FinalExam\\src\\main\\webapp\\images\\user";
		String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
		
		
		UserDao dao=new UserDao();
		if (fileName.equals("")) {
			dao.EditAccount(u.getId(), name, age, fileName);
		} else
		{
			System.out.println(realPath+"/"+fileName);

			  part.write(realPath+"/"+fileName); 
			  dao.EditAccount(u.getId(), name, age,"images/user/"+fileName);
			  
		}
		u=dao.getByIdUser(u.getId()); 
		request.getSession().setAttribute("user", u);
		response.sendRedirect("profile.jsp");
	}

}
