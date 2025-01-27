package MovieBookingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UpdateRow {

    // Method to update a row in any table
    public static void updateRow(String tableName, List<String> columnNames, List<Object> values, String conditionColumn, Object conditionValue) {
        // Constructing the SQL query dynamically based on column names
        String setClause = String.join(", ", columnNames.stream().map(col -> col + " = ?").toArray(String[]::new));

        String query = "UPDATE " + tableName + " SET " + setClause + " WHERE " + conditionColumn + " = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set values for the placeholders dynamically
            for (int i = 0; i < values.size(); i++) {
                pstmt.setObject(i + 1, values.get(i));
            }

            // Set the condition value (e.g., adminID, movieID, etc.)
            pstmt.setObject(values.size() + 1, conditionValue);

            // Execute the update query
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Row updated successfully in the " + tableName + " table!");
            } else {
                System.out.println("No row found with " + conditionColumn + " = " + conditionValue);
            }
        } catch (SQLException e) {
            System.out.println("Error while updating the row.");
            e.printStackTrace();
        }
    }
}

