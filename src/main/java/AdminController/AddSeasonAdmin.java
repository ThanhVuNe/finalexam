package AdminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminDao.SeasonAdminDao;

/**
 * Servlet implementation class AddSeasonAdmin
 */
@WebServlet(urlPatterns= {"/AddSeasonAdmin","/admin/AddSeasonAdmin"})
public class AddSeasonAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSeasonAdmin() {
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
		String yearS=request.getParameter("yearS");
		String yearE=request.getParameter("yearE");
		SeasonAdminDao dao=new SeasonAdminDao();
		dao.addSeason(yearS, yearE);
		response.sendRedirect("SeasonAdmin");
	}

}
