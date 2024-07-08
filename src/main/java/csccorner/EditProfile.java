package csccorner;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String email = (String) session.getAttribute("email");
        String gender = (String) session.getAttribute("gender");
        String city = (String) session.getAttribute("city");

        req.setAttribute("username", username);
        req.setAttribute("email", email);
        req.setAttribute("gender", gender);
        req.setAttribute("city", city);

        RequestDispatcher rd = req.getRequestDispatcher("/editprofile.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newUsername = req.getParameter("txtNewUsername");
        String newEmail = req.getParameter("txtNewEmail");
        String newGender = req.getParameter("txtNewGender");
        String newCity = req.getParameter("txtNewCity");

        // Update the user's profile in the database
        //...

        HttpSession session = req.getSession();
        session.setAttribute("username", newUsername);
        session.setAttribute("email", newEmail);
        session.setAttribute("gender", newGender);
        session.setAttribute("city", newCity);

        resp.sendRedirect("Dashboard");
    }
}