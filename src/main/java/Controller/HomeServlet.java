package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MatchDao;
import Dao.TeamDao;
import Model.Match;
import Model.Team;
import jakarta.mail.Session;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s=request.getParameter("season");
		String season=(String) request.getSession().getAttribute("season");
		if(season!=null) {
			s=season;

		}else {
			request.getSession().setAttribute("season", s);			
		}
		TeamDao dao=new TeamDao();
		MatchDao mDao=new MatchDao();
		List<Team>teams=dao.getTop6TeamByIdSeason(Integer.parseInt(s));
		List<Match>matchs=mDao.getAllMatchByIdSeason(Integer.parseInt(s));
		
		request.setAttribute("matchs", matchs);
		request.setAttribute("teams", teams);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
