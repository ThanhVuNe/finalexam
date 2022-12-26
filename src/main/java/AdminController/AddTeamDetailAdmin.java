package AdminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminDao.TeamDetailAdminDao;

/**
 * Servlet implementation class AddTeamDetailAdmin
 */
@WebServlet(urlPatterns= {"/AddTeamDetailAdmin","/admin/AddTeamDetailAdmin"})
public class AddTeamDetailAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeamDetailAdmin() {
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
		String id_season=request.getParameter("id_season");
		String id_team=request.getParameter("id_team");
		TeamDetailAdminDao dao=new TeamDetailAdminDao();
		if(dao.checkExists(id_season, id_team)==null) {
			dao.addTeamDetail(id_season, id_team);
			response.sendRedirect("TeamDetailAdmin");			
		}else {
			response.sendRedirect("TeamDetailAdmin?err=true");
		}
				
	}

}
