package AdminController;

import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import AdminDao.AccountAdminDao;
import AdminDao.UserAdminDao;

/**
 * Servlet implementation class AddUserAdmin
 */
@MultipartConfig
@WebServlet(urlPatterns= {"/AddUserAdmin","/admin/AddUserAdmin"})
public class AddUserAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("fullname");
		String age=request.getParameter("age");
		String id_account=request.getParameter("id_account");
		Part img=request.getPart("img");
		
		String realPath = "D:\\source jsp\\FinalExam\\src\\main\\webapp\\images\\user";
		String fileName = Path.of(img.getSubmittedFileName()).getFileName().toString();
		
		UserAdminDao dao=new UserAdminDao();
		dao.addUser(name, age, "images/user/"+fileName, id_account);
		img.write(realPath+"/"+fileName);
		response.sendRedirect("UserAdmin");
	}

}
