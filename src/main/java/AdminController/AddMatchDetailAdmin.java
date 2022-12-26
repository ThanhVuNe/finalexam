package AdminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminDao.MatchDetailAdminDao;

/**
 * Servlet implementation class AddMatchDetailAdmin
 */
@WebServlet(urlPatterns= {"/AddMatchDetailAdmin","/admin/AddMatchDetailAdmin"})
public class AddMatchDetailAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMatchDetailAdmin() {
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
		String id_team=request.getParameter("id_team");
		String id_match=request.getParameter("id_match");
		String status=request.getParameter("status");
		String score=request.getParameter("score");
		MatchDetailAdminDao dao=new MatchDetailAdminDao();
		dao.addMatchDetail(id_team, id_match, status, score);
		response.sendRedirect("MatchDetailAdmin");
	}

}
