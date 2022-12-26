package AdminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminDao.AccountAdminDao;
import Model.Account;

/**
 * Servlet implementation class AddAccountAdmin
 */

@WebServlet(urlPatterns= {"/AddAccountAdmin","/admin/AddAccountAdmin"})
public class AddAccountAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccountAdmin() {
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
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		AccountAdminDao dao=new AccountAdminDao();
		Account a=dao.checkEmail(email);
		if(a!=null) {
			request.setAttribute("mess", "Email already exists");
			request.getRequestDispatcher("AccountAdmin").forward(request, response);
		}else {
			dao.addAccount(email, password);
			response.sendRedirect("AccountAdmin");
		}
	}

}
