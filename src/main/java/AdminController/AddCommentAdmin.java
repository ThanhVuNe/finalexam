package AdminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminDao.CommentAdminDao;

/**
 * Servlet implementation class AddCommentAdmin
 */
@WebServlet(urlPatterns= {"/AddCommentAdmin","/admin/AddCommentAdmin"})
public class AddCommentAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentAdmin() {
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
		String content=request.getParameter("content");
		String id_match=request.getParameter("id_match");
		String id_user=request.getParameter("id_user");
		String date=request.getParameter("date");
		date=date.replace('T', ' ').concat(":00");
		CommentAdminDao dao=new CommentAdminDao();
		dao.addComment(content, id_match, id_user, date);
		response.sendRedirect("CommentAdmin");
	}

}
