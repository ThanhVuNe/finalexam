package Authentication;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Model.Account;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		String url=req.getServletPath();
		HttpSession session=req.getSession();
//		System.out.println(url);
		if(session.getAttribute("account")!=null || url.equals("/ValidateServlet")) {
			Account account=(Account)session.getAttribute("account");
			if(url.startsWith("/admin")) {
				if(account.getRole()==1) {
					chain.doFilter(request, response);							
				}
				else {
					req.getRequestDispatcher("error/404.jsp").forward(req, response);
				}
			}else {
				chain.doFilter(request, response);
			}
		}else {
			req.getRequestDispatcher("loginAndSignup.jsp").forward(req, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
