package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.PlayerDao;
import Dao.TeamDao;
import Model.Player;
import Model.Team;

/**
 * Servlet implementation class ViewDetailTeamServlet
 */
@WebServlet("/ViewDetailTeamServlet")
public class ViewDetailTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDetailTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idTeam=request.getParameter("id");
		TeamDao dao=new TeamDao();
		Team team=dao.getTeamById(Integer.parseInt(idTeam));
		PrintWriter out=response.getWriter();
		
		PlayerDao playerDao=new PlayerDao();
		List<Player>list=playerDao.getPlayersByIdTeam(Integer.parseInt(idTeam));
		out.print("<div class=\"mb-4\">\r\n"
				+ "						<div class=\"img-detail\">\r\n"
				+ "							<img src=" +team.getImg_arena() +" alt=\"\">\r\n"
				+ "						</div>\r\n"
				+ "					</div>\r\n"
				+ "					<div class=\"mb-4\">\r\n"
				+ "						<h4>Stadium:"+team.getArena() +"</h4>\r\n"
				+ "						<p>"+team.getDescription() +"</p>"
				+ "					</div>"
				+"<div class=\"mb-4\">\r\n"
				+ "                        <h4>List Player</h4>\r\n"
				+ "                        <ul>"
				);
		for(int i=0;i<list.size();i++) {
			out.println("<li>" + list.get(i).getName()+" <span>"+ list.get(i).getShirt()+"</span> </li>");
		}
		out.print(" </ul>\r\n"
				+ " </div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
