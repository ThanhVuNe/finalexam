package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.SeasonDao;
import Dao.TeamDao;
import Model.Season;
import Model.Team;

@WebServlet("/TeamServlet")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String season=(String)request.getSession().getAttribute("season");
		String search=request.getParameter("search");
		
		TeamDao dao=new TeamDao();
		List<Team>teams=new ArrayList<>();
		
		if(search=="") {
			search=null;
		}
		String pageString=request.getParameter("page");
		int page;
		int pageSize=dao.getTeamByIdSeason(Integer.parseInt(season)).size();
		pageSize=pageSize%3==0?pageSize-1:pageSize;
		pageSize=(int)Math.ceil((pageSize/3)+0.1);
		if(pageString==null) {
			page=1;
		}else {
			page=Integer.parseInt(pageString);
		}
		
		if(search!=null) {
			teams=dao.SearchByNameAndPage(Integer.parseInt(season), search,page);
			pageSize=Math.round((float)dao.SearchByName(Integer.parseInt(season), search).size()/3);
			request.setAttribute("valueSearch", search);
		}else {
			teams=dao.getTeamByPage(page,season);
		}
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("teams", teams);
		request.getRequestDispatcher("team.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
