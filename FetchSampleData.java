

package MovieBookingSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchSampleData {

    public static void fetchData() {
        Connection connection = null;

        try {
            // Establish connection using DatabaseConnection class
            connection = DatabaseConnection.connect();
            if (connection == null) {
                System.out.println("Failed to establish a connection.");
                return;
            }

            System.out.println("Database connected successfully!");

            // Create a statement
            Statement stmt = connection.createStatement();

            // Fetch data from Admin table
            System.out.println("\nAdmin Table:");
            ResultSet rs = stmt.executeQuery("SELECT * FROM Admin");
            while (rs.next()) {
                System.out.println("Admin ID: " + rs.getInt("adminID") + ", Name: " + rs.getString("name") +
                                   ", Email: " + rs.getString("email") + " Password: " + rs.getString("password"));
            }

            // Fetch data from Movie table
            System.out.println("\nMovie Table:");
            rs = stmt.executeQuery("SELECT * FROM Movie");
            while (rs.next()) {
                System.out.println("Movie ID: " + rs.getInt("movieID") + ", Title: " + rs.getString("title") +
                                   ", Genre: " + rs.getString("genre") + ", Language: " + rs.getString("language") +
                                   ", Duration: " + rs.getFloat("duration") + " mins");
            }

            // Fetch data from Booking table
            System.out.println("\nBooking Table:");
            rs = stmt.executeQuery("SELECT * FROM Booking");
            while (rs.next()) {
                System.out.println("Booking ID: " + rs.getInt("bookingID") + ", User ID: " + rs.getInt("userID") +
                                   ", Show ID: " + rs.getInt("showID") + ", Seats Booked: " + rs.getInt("seatsBooked") +
                                   ", Total Amount: " + rs.getFloat("totalAmount") + ", Status: " + rs.getString("bookingStatus"));
            }

            // Close the result set and statement
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
