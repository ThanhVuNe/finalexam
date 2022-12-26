package AdminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminDao.TeamDetailAdminDao;

/**
 * Servlet implementation class EditTeamDetailAdmin
 */
@WebServlet(urlPatterns= {"/EditTeamDetailAdmin","/admin/EditTeamDetailAdmin"})
public class EditTeamDetailAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeamDetailAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String id_season=request.getParameter("id_season");
		String id_team=request.getParameter("id_team");
		System.out.println(id+"/"+id_season+"/"+id_team);
		TeamDetailAdminDao dao=new TeamDetailAdminDao();
		dao.editTeamDetail(id,id_season,id_team);
		response.sendRedirect("TeamDetailAdmin");
	}

}
