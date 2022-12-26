package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AccountDao;
import Model.Account;
import Support.SendEmail;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		AccountDao dao=new AccountDao();
		Account a=dao.checkEmail(email);
		if(a!=null) {
			SendEmail sendEmail=new SendEmail();
			String otp=sendEmail.send(email);
			request.setAttribute(email, "email");
			request.getSession().setAttribute("otp", otp);
			request.getRequestDispatcher("sms.jsp").forward(request, response);
		}else {
			request.setAttribute("mess","Email does not exist");
			request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
		}
	}

}
