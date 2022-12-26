package AdminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminDao.TeamDetailAdminDao;

/**
 * Servlet implementation class DeleteTeamDetailAdmin
 */
@WebServlet(urlPatterns= {"/DeleteTeamDetailAdmin","/admin/DeleteTeamDetailAdmin"})
public class DeleteTeamDetailAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeamDetailAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS=request.getParameter("id_season");
		String idT=request.getParameter("id_team");
		TeamDetailAdminDao dao=new TeamDetailAdminDao();
		dao.deleteTeamDetail(idS, idT);
		response.sendRedirect("TeamDetailAdmin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
