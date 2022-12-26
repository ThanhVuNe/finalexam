package AdminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminDao.MatchAdminDao;

/**
 * Servlet implementation class AddMatchAdmin
 */
@WebServlet(urlPatterns= {"/AddMatchAdmin","/admin/AddMatchAdmin"})
public class AddMatchAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMatchAdmin() {
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
		String date=request.getParameter("date");
		String id_season=request.getParameter("id_season");
		String card=request.getParameter("card");
		
		date=date.replace('T', ' ').concat(":00");
		MatchAdminDao dao=new MatchAdminDao();
		dao.addMatch(date, id_season, card);
		response.sendRedirect("MatchAdmin");
	}

}
