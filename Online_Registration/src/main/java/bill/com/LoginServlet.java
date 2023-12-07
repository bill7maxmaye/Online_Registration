package bill.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Retrieve user from the database based on the provided username
        User user = userDao.getUserByUsername(username);

        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            // Successful login
            // Store user information in the session
            HttpSession session = request.getSession(true);
            session.setAttribute("user", username);

            // Redirect to welcome.jsp
            response.sendRedirect("home.jsp");
        } else {
            // Failed login
            // Store error message in request attribute
            request.setAttribute("error", "Invalid username or password");

            // Forward back to login.jsp with error message
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
