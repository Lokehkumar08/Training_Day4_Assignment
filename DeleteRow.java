package MovieBookingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteRow {

    // Method to delete a row from any table based on the column name and value
    public static void deleteRow(String tableName, String columnName, Object columnValue) {
        // Construct SQL query dynamically
        String query = "DELETE FROM " + tableName + " WHERE " + columnName + " = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set the value for the column in the query
            pstmt.setObject(1, columnValue);

            // Execute the delete query
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Row with " + columnName + " = " + columnValue + " deleted successfully from " + tableName + " table.");
            } else {
                System.out.println("No row found with " + columnName + " = " + columnValue + " in " + tableName + " table.");
            }
        } catch (SQLException e) {
            System.out.println("Error while deleting the row.");
            e.printStackTrace();
        }
    }
}
