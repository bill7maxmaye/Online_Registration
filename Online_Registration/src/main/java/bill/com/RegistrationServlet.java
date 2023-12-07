package bill.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate input
        if (name == null || email == null || password == null ||
            name.isEmpty() || email.isEmpty() || password.isEmpty() || !isValidEmail(email)) {
            // If any required field is missing or email is not in the correct format, redirect to an error page
            response.sendRedirect("error.jsp");
            return;
        }

        // Create a user object
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        // Register the user in the database (UserDao handles password hashing)
        userDao.registerUser(user);

        // Store the username in a session attribute
        HttpSession session = request.getSession();
        session.setAttribute("username", name);

        // Redirect to confirmation page
        response.sendRedirect("confirmation.jsp");
    }

    private boolean isValidEmail(String email) {
        // Simple email validation using a regular expression
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
