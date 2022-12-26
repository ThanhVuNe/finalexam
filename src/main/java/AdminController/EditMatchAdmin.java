package AdminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminDao.MatchAdminDao;
import Model.MatchModel;

/**
 * Servlet implementation class EditMatchAdmin
 */
@WebServlet(urlPatterns= {"/EditMatchAdmin","/admin/EditMatchAdmin"})
public class EditMatchAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMatchAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		MatchAdminDao dao=new MatchAdminDao();
		MatchModel m=dao.getMatchById(id);
		PrintWriter out=response.getWriter();
		out.print(m.getId()+"/"+m.getDate()+"/"+m.getId_season()+"/"+m.getCard());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String date=request.getParameter("date");
		date=date.replace('T', ' ').concat(":00");
		String id_season=request.getParameter("id_season");
		String card=request.getParameter("card");
		
		MatchAdminDao dao=new MatchAdminDao();
		dao.editMatch(date, id_season, card, id);
		response.sendRedirect("MatchAdmin");
	}

}
