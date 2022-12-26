package AdminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminDao.AccountAdminDao;
import Model.Account;

/**
 * Servlet implementation class EditAccountAdmin
 */
@WebServlet(urlPatterns= {"/EditAccountAdmin","/admin/EditAccountAdmin"})
public class EditAccountAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccountAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		AccountAdminDao dao=new AccountAdminDao();
		Account account=dao.getAccountById(id);
		PrintWriter out=response.getWriter();
		out.print(account.getId()+"/"+account.getEmail()+"/"+account.getPassword());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		AccountAdminDao dao=new AccountAdminDao();
		Account a=dao.checkEmail(email);
		if(a!=null) {
			request.setAttribute("mess", "Email already exists");
			request.getRequestDispatcher("AccountAdmin").forward(request, response);
		}else {
			dao.editAccount(email, password,id);
			response.sendRedirect("AccountAdmin");
		}
	}

}
