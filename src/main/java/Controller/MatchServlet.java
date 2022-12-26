package Controller;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * Servlet implementation class MatchServlet
 */
@WebServlet("/MatchServlet")
public class MatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String season=(String)request.getSession().getAttribute("season");
		String search=request.getParameter("search");
		
		MatchDao dao=new MatchDao();
		List<Match>matchs=new ArrayList<>();
		
		if(search=="") {
			search=null;
		}
		String pageString=request.getParameter("page");
		int page;
		int pageSize=dao.getAllMatchByIdSeason(Integer.parseInt(season)).size();
		pageSize=pageSize%6==0?pageSize-1:pageSize;
		pageSize=(int)Math.ceil((pageSize/6)+0.1);
		if(pageString==null) {
			page=1;
		}else {
			page=Integer.parseInt(pageString);
		}
		
		if(search!=null) {
			System.out.println("1");
			matchs=dao.SearchByNameAndPage(Integer.parseInt(season), search,page);
			pageSize=Math.round((float)dao.SearchByName(Integer.parseInt(season), search).size()/3);
			request.setAttribute("valueSearch", search);
		}else {
			System.out.println(page+" "+season);
			System.out.println("2");
			matchs=dao.getTeamByPage(page,season);
		}
		System.out.println(matchs);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("matchs", matchs);
		request.getRequestDispatcher("match.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
