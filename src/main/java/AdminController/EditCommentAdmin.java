package AdminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.exceptions.RSAException;

import AdminDao.CommentAdminDao;
import Model.CommentModel;

/**
 * Servlet implementation class EditCommentAdmin
 */
@WebServlet(urlPatterns= {"/EditCommentAdmin","/admin/EditCommentAdmin"})
public class EditCommentAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCommentAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		CommentAdminDao dao=new CommentAdminDao();
		CommentModel c=dao.getById(id);
		PrintWriter out=response.getWriter();
		out.print(c.getId()+"/"+c.getContent()+"/"+c.getId_match()+"/"+c.getId_user()+"/"+c.getDate());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String content=request.getParameter("content");
		String id_match=request.getParameter("id_match");
		String id_user=request.getParameter("id_user");
		String date=request.getParameter("date");
		date=date.replace('T', ' ').concat(":00");
		CommentAdminDao dao=new CommentAdminDao();
		dao.editComment(id, content, id_match, id_user, date);
		response.sendRedirect("CommentAdmin");
	}

}
