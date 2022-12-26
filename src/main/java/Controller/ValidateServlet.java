package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AccountDao;
import Dao.UserDao;
import Model.Account;
import Model.User;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("login")) {
			String email =request.getParameter("email");
			String pass=request.getParameter("password");
			String remember=request.getParameter("remember");
			
			AccountDao dao=new AccountDao();
			if(dao.login(email, pass)==null) {
				String mess="WRONG USER OR PASS";
				request.setAttribute("mess", mess);
				request.getRequestDispatcher("loginAndSignup.jsp").forward(request, response);
			}else {
				Account a=dao.login(email, pass);
				HttpSession session = request.getSession();
				
				UserDao dao2=new UserDao();
				//init session
				session.setAttribute("user", dao2.getByIdAccount(a.getId()));
				session.setAttribute("account", a);
				
				//init cookie
				if(remember!=null) {
					Cookie accCookie=new Cookie("account", email);
					Cookie pCookie=new Cookie("pass", pass);
					accCookie.setMaxAge(60);
					pCookie.setMaxAge(60);
					response.addCookie(accCookie);
					response.addCookie(pCookie);
				}
				
				if(a.getRole()==1) {
					response.sendRedirect("admin/home.jsp");
				}else {
					response.sendRedirect("season.jsp");					
				}
			}
		}else if(action.equals("signup")) { 
			String email =request.getParameter("emailS");
			String pass=request.getParameter("passwordS");
			System.out.println(pass);
			AccountDao dao=new AccountDao();
			Account account=dao.checkEmail(email);
			if(account!=null) {
				String mess="EMAIL IS ALREADY EXIST";
				request.setAttribute("messS", mess);
				request.setAttribute("checked", "checked");
				request.getRequestDispatcher("loginAndSignup.jsp").forward(request, response);
			}else {
				dao.signUp(email, pass);
				response.sendRedirect("loginAndSignup.jsp");	
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
