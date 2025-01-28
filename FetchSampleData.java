

package MovieBookingSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class FetchSampleData {

    public static void fetchData(String tableName) {
        Connection connection = null;
        try {
           
            connection = DatabaseConnection.connect();
            if (connection == null) {
                System.out.println("Failed to establish a connection.");
                return;
            }

            System.out.println("Fetching data from table: " + tableName);

            
            Statement stmt = connection.createStatement();

            
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
            while (rs.next()) {
               
                int columnCount = rs.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getMetaData().getColumnLabel(i) + ": " + rs.getString(i) + " ");
                }
                System.out.println();
            }

           
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
