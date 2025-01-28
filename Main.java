package MovieBookingSystem;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Menu to allow the user to choose an operation
            System.out.println("\nMovie Booking System ");
            System.out.println("1. Fetch Sample Data (Read)");
            System.out.println("2. Insert Data (Create)");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");
            System.out.println("5. Exit");
            System.out.print("Choose an operation (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Fetch and display data from any table
                    System.out.print("Enter the table name to fetch data from: ");
                    String tableName = scanner.nextLine();
                    FetchSampleData.fetchData(tableName);
                    break;

                case 2:
                    // Insert data into any table
                    System.out.print("Enter the table name to insert data into: ");
                    tableName = scanner.nextLine();
                    System.out.print("Enter the column names (comma-separated): ");
                    String columns = scanner.nextLine();
                    List<String> columnNames = Arrays.asList(columns.split(","));
                    System.out.print("Enter the values to insert (comma-separated): ");
                    String valuess = scanner.nextLine();
                    List<String> values = Arrays.asList(valuess.split(","));

                    // Convert List<String> to List<Object>
                    List<Object> objectValues = values.stream().map(v -> (Object) v).collect(Collectors.toList());

                    // Call insertRow with List<Object> instead of List<String>
                    InsertRow.insertRow(tableName, columnNames, objectValues);
                    break;

                case 3:
                    // Update data in any table
                    System.out.print("Enter the table name to update data: ");
                    tableName = scanner.nextLine();
                    System.out.print("Enter the column names to update (comma-separated): ");
                    columns = scanner.nextLine();
                    List<String> updateColumnNames = Arrays.asList(columns.split(","));
                    System.out.print("Enter the new values for the columns (comma-separated): ");
                    valuess = scanner.nextLine();
                    List<String> updateValues = Arrays.asList(valuess.split(","));
                    System.out.print("Enter the column name for the condition (e.g., 'ID'): ");
                    String conditionColumn = scanner.nextLine();
                    System.out.print("Enter the value for the condition: ");
                    String conditionValue = scanner.nextLine();

                    // Convert List<String> to List<Object>
                    List<Object> updateObjectValues = updateValues.stream().map(v -> (Object) v).collect(Collectors.toList());

                    // Call updateRow with List<Object> instead of List<String>
                    UpdateRow.updateRow(tableName, updateColumnNames, updateObjectValues, conditionColumn, conditionValue);
                    break;

                case 4:
                    // Delete data from any table
                    System.out.print("Enter the table name to delete data from: ");
                    tableName = scanner.nextLine();
                    System.out.print("Enter the column name for the condition (e.g., 'ID'): ");
                    String deleteConditionColumn = scanner.nextLine();
                    System.out.print("Enter the value for the condition: ");
                    String deleteConditionValue = scanner.nextLine();
                    DeleteRow.deleteRow(tableName, deleteConditionColumn, deleteConditionValue);
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting the system...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
