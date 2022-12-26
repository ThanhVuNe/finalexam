package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CommentDao;
import Dao.MatchDetailDao;
import Dao.PlayerDao;
import Dao.PlayerDetailDao;
import Model.User;

/**
 * Servlet implementation class MatchDetailServlet
 */
@WebServlet("/MatchDetailServlet")
public class MatchDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_match=request.getParameter("id_match");
		String id_season=(String)request.getSession().getAttribute("season");
		String id_team1=request.getParameter("id_team1");
		String id_team2=request.getParameter("id_team2");
		
		//load cau thu ghi ban va chi tiet tran dau
		MatchDetailDao dao=new MatchDetailDao();
		PlayerDetailDao Pdao=new PlayerDetailDao();
		
		//load comment user
		CommentDao cDao=new CommentDao();
		
		
		request.setAttribute("pd1", Pdao.getGoal(Integer.parseInt(id_match), Integer.parseInt(id_team1)));
		request.setAttribute("pd2", Pdao.getGoal(Integer.parseInt(id_match), Integer.parseInt(id_team2)));
		request.setAttribute("md", dao.getMatchDetail(Integer.parseInt(id_match), Integer.parseInt(id_season)));
//		System.out.println(dao.getMatchDetail(Integer.parseInt(id_match), Integer.parseInt(id_season)));
		User user=(User)request.getSession().getAttribute("user");
		request.setAttribute("currentUser", cDao.getByIdUser(user.getId(), Integer.parseInt(id_match)));
		request.setAttribute("otherUser", cDao.getAllComments(user.getId(), Integer.parseInt(id_match)));
		
		request.getRequestDispatcher("matchDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
