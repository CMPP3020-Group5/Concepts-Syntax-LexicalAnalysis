import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // Wait for the user to enter numbers in the command line
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter numbers separated by commas, or type 'exit' to quit: ");

            // Get the user's input (String)
            String numbersString = scanner.nextLine();

            // Check whether the input is empty
            if (numbersString == null || numbersString.trim().isEmpty()) {
                System.out.println("Error: Empty input.");
                continue;
            }
            // Check whether the input is ‘exit’
            if (numbersString.trim().equalsIgnoreCase("exit")) {
                System.out.print("Program exited.");
                break;
            }

            // Split numberString into numberStringArray
            String[] numberStringArray = numbersString.split(",");
            // Check whether numberStringArray is empty
            if (numberStringArray.length == 0) {
                System.out.println("Error: Invalid input.");
                continue;
            }

            // Initialize total and count
            double total = 0;
            int count = 0;
            // Parse string to double, and calculate total and count
            try {
                for (String numberString : numberStringArray) {
                    total += Double.parseDouble(numberString.trim());
                    count++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input.");
                continue;
            }

            // Calculate average
            if (count == 0) {
                System.out.println("Error: Invalid input.");
                continue;
            }
            double average = total / count;

            // Display the result
            System.out.println("Total:" + total);
            System.out.println("Count:" + count);
            System.out.println("Average:" + average);
        }
        scanner.close();
    }
}
