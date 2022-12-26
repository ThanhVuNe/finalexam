package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckSmsServlet
 */
@WebServlet("/CheckSmsServlet")
public class CheckSmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String o1=request.getParameter("otp1");
		String o2=request.getParameter("otp2");
		String o3=request.getParameter("otp3");
		String o4=request.getParameter("otp4");
		String o5=request.getParameter("otp5");
		String o6=request.getParameter("otp6");
		String sms=o1+o2+o3+o4+o5+o6;
		String otp=(String) request.getSession().getAttribute("otp");
		if(otp!=null) {
			if(sms.equals(otp)) {
				request.getSession().removeAttribute("otp");
				String email=request.getParameter("email");
				request.setAttribute("email", email);
				request.getRequestDispatcher("changePassword.jsp").forward(request, response);
			}else {
				request.setAttribute("mess", "Invalid OTP");
				request.getRequestDispatcher("sms.jsp").forward(request, response);
			}
		}
	}

}
