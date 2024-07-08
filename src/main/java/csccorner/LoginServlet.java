package csccorner;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description="jdbc mysql",urlPatterns= {"/Login"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    PrintWriter out;
    Connection con   ;  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
          out = response.getWriter();

            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fulare?useSSL=true", "root", "rUSHI@123");
            System.out.println("mysql connected");
        }
        catch (SQLException e) {
        	System.out.println("Error occur in the connection");
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
            String n = request.getParameter("txtEmail");
            String m = request.getParameter("txtpwd");

          
			PreparedStatement ps = con.prepareStatement("select * from register where email=? and password=?");
            ps.setString(1, n);
            ps.setString(2, m); // corrected here
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	HttpSession session=request.getSession();
            	session.setAttribute("username",n);
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
            } else {
            	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            	rd.include(request, response);
               
				out.print("<font color='red' size='18'>Login Failed!!</font>");
                out.print ("<a href='login.jsp'>Try Again!!</a>");
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }
}