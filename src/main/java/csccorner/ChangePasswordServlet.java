package csccorner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");

        // Get the user's session
        HttpSession session = request.getSession();

        // Check if the user is logged in
        if (session.getAttribute("email") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Check if the current password is correct
        String email = (String) session.getAttribute("email");
        String storedPassword;
        try {
            storedPassword = getPasswordFromDatabase(email);
        } catch (ServletException e) {
            request.setAttribute("error", "Error occurred while retrieving password from database");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
            return;
        }
        if (!storedPassword.equals(currentPassword)) {
            request.setAttribute("error", "Current password is incorrect");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
            return;
        }

        // Check if the new passwords match
        if (!newPassword.equals(confirmNewPassword)) {
            request.setAttribute("error", "New passwords do not match");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
            return;
        }

        // Update the password in the database
        try {
            updatePasswordInDatabase(email, newPassword);
        } catch (ServletException e) {
            request.setAttribute("error", "Error occurred while updating password in database");
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
            return;
        }

        // Redirect to a success page
        response.sendRedirect("passwordChange.jsp");
    }

    // Replace with your database query to get the user's password
    private String getPasswordFromDatabase(String email) throws ServletException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fulare", "root", "rUSHI@123");
            ps = conn.prepareStatement("SELECT register FROM users WHERE email =?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    // Replace with your database query to update the user's password
    private void updatePasswordInDatabase(String email, String newPassword) throws ServletException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fulare", "root", "rUSHI@123");
            ps = conn.prepareStatement("UPDATE users SET register =? WHERE email =?");
            ps.setString(1, newPassword);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException(e);
        } finally {
            closeDb(conn, ps, null);
        }
    }

    private void closeDb(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs!= null) {
                rs.close();
            }
            if (ps!= null) {
                ps.close();
            }
            if (conn!= null) {
                conn.close();
            }
        } catch (SQLException e) {
            // Log the error
            e.printStackTrace();
        }
    }
}