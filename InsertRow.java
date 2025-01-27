package MovieBookingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertRow {

    // Method to insert a row into any table
    public static void insertRow(String tableName, List<String> columnNames, List<Object> values) {
        // Constructing the SQL query dynamically based on column names
        String columns = String.join(", ", columnNames);
        String placeholders = String.join(", ", columnNames.stream().map(col -> "?").toArray(String[]::new));

        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + placeholders + ")";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set the values dynamically based on the provided list
            for (int i = 0; i < values.size(); i++) {
                pstmt.setObject(i + 1, values.get(i));
            }

            // Execute the insert query
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Row added successfully to " + tableName + " table!");
            } else {
                System.out.println("Failed to add the row to " + tableName + " table.");
            }
        } catch (SQLException e) {
            System.out.println("Error while adding the row.");
            e.printStackTrace();
        }
    }
}
