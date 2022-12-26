package AdminController;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import AdminDao.TeamAdminDao;
import Model.Team;

/**
 * Servlet implementation class EditTeamAdmin
 */
@WebServlet(urlPatterns= {"/EditTeamAdmin","/admin/EditTeamAdmin"})
public class EditTeamAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeamAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		TeamAdminDao dao=new TeamAdminDao();
		Team team=dao.getTeamById(id);
		PrintWriter out=response.getWriter();
		out.print(team.getId()+":"+team.getName()+":"+team.getArena()+":"+team.getLogo()+":"+team.getImg_arena()+":"+team.getDescription());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name = request.getParameter("name");
		String nameArena = request.getParameter("nameArena");
		String des=request.getParameter("description");
		TeamAdminDao dao=new TeamAdminDao();
		
		Part logo = request.getPart("logo");
		Part imgArena = request.getPart("imgArena");
//		System.out.println(name + age + part.toString());
		if(logo==null && imgArena==null) {
			dao.EditTeam1(name, nameArena, des, id);
		}else {
			String realPathLogo = "D:\\source jsp\\FinalExam\\src\\main\\webapp\\images\\team\\2019-2020";
			String fileNameLogo = Path.of(logo.getSubmittedFileName()).getFileName().toString();
			String realPathimgArena = "D:\\source jsp\\FinalExam\\src\\main\\webapp\\images\\team\\2019-2020";
			String fileNameimgArena = Path.of(imgArena.getSubmittedFileName()).getFileName().toString();
//			
			if(logo!=null && imgArena!=null) {
				dao.EditTeam4(name, nameArena, "images/team/2019-2020/"+fileNameLogo, "images/team/2019-2020/"+fileNameimgArena, des, id);
			}
			else {
				if(logo!=null) {
					dao.EditTeam2(name, nameArena, "images/team/2019-2020/"+fileNameLogo, des, id);
				}
				if(imgArena!=null) {
					dao.EditTeam3(name, nameArena,"images/team/2019-2020/"+fileNameimgArena, des, id);
				}
			}
			
		}
		
		response.sendRedirect("TeamAdmin");
	}

}
