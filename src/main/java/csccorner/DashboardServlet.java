package csccorner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection settings
    private static final String DB_URL = "jdbc:mysql://localhost:3306/fulare";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "rUSHI@123";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String email = (String) session.getAttribute("email");
        String gender = (String) session.getAttribute("gender");
        String city = (String) session.getAttribute("city");

        if (username == null || email == null || gender == null || city == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Connect to database
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Retrieve user data from database
            String query = "SELECT * FROM register WHERE username =?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbEmail = rs.getString("email");
                String dbGender = rs.getString("gender");
                String dbCity = rs.getString("city");

                // Set request attributes
                request.setAttribute("username", username);
                request.setAttribute("email", dbEmail);
                request.setAttribute("gender", dbGender);
                request.setAttribute("city", dbCity);
            } else {
                // User not found in database, redirect to login page
                response.sendRedirect("login.jsp");
                return;
            }
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
            response.sendRedirect("error.jsp");
            return;
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (conn!= null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}