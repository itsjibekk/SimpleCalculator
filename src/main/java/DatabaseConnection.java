import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseConnection {
    private final String USERNAME = "postgres";
    private final String PASSWORD = "123456";
    private final String URL = "jdbc:postgresql://localhost:5432/db_calc";

    public void sendQuery(String exp, int res) throws Exception{

        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        String query = "INSERT INTO results (expression, result) VALUES (?, ?)";

        try (PreparedStatement pstatement = connection.prepareStatement(query)) {
            pstatement.setString(1, exp);
            pstatement.setInt(2, res);
            pstatement.executeUpdate();
        }
    }
}
