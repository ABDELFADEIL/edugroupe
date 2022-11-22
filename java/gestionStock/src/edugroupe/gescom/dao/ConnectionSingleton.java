package edugroupe.gescom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

    private static Connection connection;
    private String url = "jdbc:mysql://localhost:3306/gescom";
    private String username = "root";
    private String password = "rootroot";

    private ConnectionSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection Creation Failed : " + e.getMessage());
        }
    }



    public static Connection getConnection() throws SQLException {
        synchronized (ConnectionSingleton.class){
            if (connection == null) {
                 new ConnectionSingleton();
            } else if (connection.isClosed()) {
                new ConnectionSingleton();
            }
        }
        return connection;
    }
}
