package bill.com;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/online_registration";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "bill@5213";

    public void registerUser(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {

                // Hash the password using BCrypt
                String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

                String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, user.getName());
                    preparedStatement.setString(2, user.getEmail());
                    preparedStatement.setString(3, hashedPassword);

                    preparedStatement.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    public User getUserByUsername(String username) {
        User user = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
                String query = "SELECT * FROM users WHERE name = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, username);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            user = new User();
                            user.setName(resultSet.getString("name"));
                            user.setEmail(resultSet.getString("email"));
                            user.setPassword(resultSet.getString("password")); // Note: This should be hashed in a real application
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }

        return user;
    }
}
