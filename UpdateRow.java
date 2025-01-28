package MovieBookingSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
public class UpdateRow {

    public static void updateRow(String tableName, List<String> columnNames, List<Object> values, String conditionColumn, Object conditionValue) {
        String setClause = String.join(", ", columnNames.stream().map(col -> col + " = ?").toArray(String[]::new));

        String query = "UPDATE " + tableName + " SET " + setClause + " WHERE " + conditionColumn + " = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            for (int i = 0; i < values.size(); i++) {
                pstmt.setObject(i + 1, values.get(i));
            }

            pstmt.setObject(values.size() + 1, conditionValue);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Row updated successfully in " + tableName + " table!");
            } else {
                System.out.println("No row found with " + conditionColumn + " = " + conditionValue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

