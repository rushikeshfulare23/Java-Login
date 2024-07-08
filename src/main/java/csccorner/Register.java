package csccorner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String myname = req.getParameter("txtName");
        String myemail = req.getParameter("txtEmail");
        String mypass = req.getParameter("txtPassword");
        String mygender = req.getParameter("txtGender");
        String mycity = req.getParameter("txtCity");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fulare?useSSL=true", "root", "rUSHI@123");

            PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
            ps.setString(1, myname);
            ps.setString(2, myemail);
            ps.setString(3, mypass);
            ps.setString(4, mygender);
            ps.setString(5, mycity);

            int count = ps.executeUpdate();
            if (count > 0) {
                resp.sendRedirect("Confirmation?txtName=" + myname + "&txtEmail=" + myemail + "&txtGender=" + mygender + "&txtCity=" + mycity);
            } else {
                out.print("<h3> User not registered due to some error </h3>");
                RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
                rd.include(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();

            resp.setContentType("text/html");
            out.print("<h3> Exception Ocurred : " + e.getMessage() + "</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
            rd.include(req, resp);
        }
    }
}