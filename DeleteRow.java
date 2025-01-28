package MovieBookingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteRow {

    
    public static void deleteRow(String tableName, String columnName, Object columnValue) {
        
        String query = "DELETE FROM " + tableName + " WHERE " + columnName + " = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            
            pstmt.setObject(1, columnValue);

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
