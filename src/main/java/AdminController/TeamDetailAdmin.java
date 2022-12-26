package AdminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminDao.TeamDetailAdminDao;


/**
 * Servlet implementation class TeamDetailAdmin
 */
@WebServlet(urlPatterns= {"/TeamDetailAdmin","/admin/TeamDetailAdmin"})
public class TeamDetailAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamDetailAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String err=request.getParameter("err");
		if(err!=null) {
			request.setAttribute("err", "Team and Season is exists");
		}
		TeamDetailAdminDao dao=new TeamDetailAdminDao();
		request.setAttribute("list", dao.getAll());
		request.setAttribute("active33", "active");
		request.getRequestDispatcher("teamDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
