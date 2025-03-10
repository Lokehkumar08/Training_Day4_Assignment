//package MovieBookingSystem;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DatabaseConnection {
//    private static final String URL = "jdbc:mysql://localhost:3306/MovieBookingSystem"; // Update with your database name
//    private static final String USER = "root"; // Replace with your MySQL username
//    private static final String PASSWORD = "admin@123"; // Replace with your MySQL password
//
//    public static Connection connect() {
//        Connection connection = null;
//        try {
//            // Load the MySQL JDBC driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Establish the connection
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("Database connected successfully!");
//        } catch (ClassNotFoundException e) {
//            System.out.println("MySQL Driver not found. Add the connector library to your project.");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("Error connecting to the database.");
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    public static void main(String[] args) {
//        // Test the connection
//        connect();
//    }
//}

package MovieBookingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/MovieBookingSystem"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "admin@123"; 

    public static Connection connect() {
        Connection connection = null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

           
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
           
            System.out.println("MySQL JDBC Driver not found. Please add the connector library to your project.");
            e.printStackTrace();
        } catch (SQLException e) {
            
            System.out.println("Error connecting to the database. Please check your connection details.");
            e.printStackTrace();
        }
        return connection;
    }
}

