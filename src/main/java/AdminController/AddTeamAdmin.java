package AdminController;

import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import AdminDao.TeamAdminDao;
import Dao.UserDao;
import Model.User;

/**
 * Servlet implementation class AddTeamAdmin
 */
@MultipartConfig
@WebServlet(urlPatterns= {"/AddTeamAdmin","/admin/AddTeamAdmin"})
public class AddTeamAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeamAdmin() {
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
		String name = request.getParameter("name");
		String nameArena = request.getParameter("nameArena");
		String des=request.getParameter("description");
		
		Part logo = request.getPart("logo");
		Part imgArena = request.getPart("imgArena");
//		System.out.println(name + age + part.toString());

		String realPathLogo = "D:\\source jsp\\FinalExam\\src\\main\\webapp\\images\\team\\2019-2020";
		String realPathimgArena = "D:\\source jsp\\FinalExam\\src\\main\\webapp\\images\\team\\2019-2020";
		String fileNameLogo = Path.of(logo.getSubmittedFileName()).getFileName().toString();
		String fileNameimgArena = Path.of(imgArena.getSubmittedFileName()).getFileName().toString();
		
		System.out.println(fileNameLogo);
		System.out.println(fileNameimgArena);
		
		TeamAdminDao dao=new TeamAdminDao();
		dao.addTeam(name, nameArena, "images/team/2019-2020/"+fileNameLogo, "images/team/2019-2020/"+fileNameimgArena, des);
		logo.write(realPathLogo+"/"+fileNameLogo);
		imgArena.write(realPathimgArena+"/"+fileNameimgArena);
		response.sendRedirect("TeamAdmin");
		/*
		 * UserDao dao=new UserDao(); if (fileName.equals("")) {
		 * dao.EditAccount(u.getId(), name, age, fileName); } else {
		 * System.out.println(realPath+"/"+fileName);
		 * 
		 * part.write(realPath+"/"+fileName); dao.EditAccount(u.getId(), name,
		 * age,"images/user/"+fileName);
		 * 
		 * } u=dao.getByIdUser(u.getId()); request.getSession().setAttribute("user", u);
		 * response.sendRedirect("profile.jsp");
		 */
	}
	
}
