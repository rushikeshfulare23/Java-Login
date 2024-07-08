package csccorner;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LogoutServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Invalidate the session to log out the user
        req.getSession().invalidate();

        // Redirect to the logout page
        res.sendRedirect("logout.jsp");
    }
}