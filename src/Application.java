import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // Wait for the user to enter numbers in the command line
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****Average Calculator*****");
        System.out.print("Enter a request in the following format: ");
        System.out.println("average([5, 8, 12, 4, 10])");
        System.out.println("Only non-negative integers are supported.");
        System.out.println("Type 'exit' to quit.");
        while (true) {
            String input = getUserInput(scanner);

            // Check whether the input is empty
            if (input.trim().isEmpty()) {
                System.out.println("Error: Empty input.");
                continue;
            }
            // Check whether the input is ‘exit’
            if (input.trim().equalsIgnoreCase("exit")) {
                System.out.print("Program exited.");
                break;
            }

            //Parse and validate input based on Part B syntax
            Integer[] numbers = parseInput(input);
            if (null == numbers) {
                System.out.println("Error: Invalid input.");
                continue;
            }
            double average = calculateAverage(numbers);

            // Display the result
            System.out.println("Average: " + average);
        }
        scanner.close();
    }

    // Accept and read user input
    private static String getUserInput(Scanner scanner) {
        // Get the user's input (String)
        System.out.print("\nInput: ");
        return scanner.nextLine();
    }

    // Parse and validate input based on Part B syntax
    private static Integer[] parseInput(String input) {
        String regex = "^\\s*average\\s*\\(\\s*\\[([^]]*)]\\s*\\)\\s*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            return null;
        }

        String numbersInput = matcher.group(1);

        // Split the input into individual number strings
        String[] numberStringArray = numbersInput.split(",", -1);

        List<Integer> numbers = new ArrayList<>();

        try {
            for (String numberString : numberStringArray) {
                // According to the EBNF, numbers contain digits only
                if (!numberString.trim().matches("[0-9]+")) {
                    return null;
                }
                numbers.add(Integer.parseInt(numberString.trim()));
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return numbers.toArray(new Integer[0]);

    }

    // Calculate the average
    private static double calculateAverage(Integer[] numbers) {
        // Initialize total and count
        int total = 0;
        int count = 0;
        for (int number : numbers) {
            total += number;
            count++;
        }
        // Calculate average
        return (double) total / count;
    }
}
