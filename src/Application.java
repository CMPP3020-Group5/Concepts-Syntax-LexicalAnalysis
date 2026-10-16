import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static final Pattern DECL_PATTERN = Pattern.compile("^\\s*(\\S+)\\s+(\\S+)\\s*=\\s*(.+)\\s*;\\s*$");
    private static final Pattern VARIABLE_PATTERN = Pattern.compile("^[a-z][a-z0-9_]*$");
    private static final Pattern AVERAGE_EXPR_PATTERN = Pattern.compile("^\\s*average\\s*\\(\\s*\\[([^]]*)]\\s*\\)\\s*$");
    private static final Pattern ARRAY_EXPR_PATTERN = Pattern.compile("^\\s*\\[([^]]*)]\\s*$");
    private static final Map<String, String> TYPE_LOOKUP_TABLE = Map.of(
        "int[]", "TYPE",
        "double", "TYPE"
    );

    public static void main(String[] args) {
        // Create a scanner to read user input from the console
        Scanner scanner = new Scanner(System.in);

        welcome();

        while (true) {
            String input = getUserInput(scanner);
            String trimInput = input.trim();
            // Check whether the input is empty
            if (trimInput.isEmpty()) {
                System.out.println("Error: Empty input.");
                continue;
            }
            // Check whether the input is ‘exit’
            if (trimInput.equalsIgnoreCase("exit")) {
                System.out.println("Program exited.");
                break;
            }

            //Parse and validate input based on Part B syntax
            Integer[] numbers = checkSyntaxAndParse(trimInput);
            if (null == numbers) {
                continue;
            }
            double average = calculateAverage(numbers);

            // Display the result
            System.out.println("Average: " + average);
        }
        scanner.close();
    }

    private static void welcome() {
        System.out.println("Average Calculator");
        System.out.println();
        System.out.println("Enter one declaration using either of the following formats:");
        System.out.println();
        System.out.println("  int[] numbers = [5, 8, 12, 4, 10];");
        System.out.println("  double result = average([5, 8, 12, 4, 10]);");
        System.out.println();
        System.out.println("Invalid variable name. Use lowercase letters, digits, or underscores, and start with a lowercase letter.");
        System.out.println("Only non-negative integers are supported.");
        System.out.println("Type 'exit' to quit.");
    }

    // Accept and read user input
    private static String getUserInput(Scanner scanner) {
        // Get the user's input (String)
        System.out.print("\nInput: ");
        return scanner.nextLine();
    }

    // Validate the declaration syntax and extract the numbers
    private static Integer[] checkSyntaxAndParse(String input) {
        Matcher declMatcher = DECL_PATTERN.matcher(input);

        if (!declMatcher.matches()) {
            if (!input.endsWith(";")) {
                System.out.println("Syntax error: Declaration must end with ';'.");
                return null;
            }
            System.out.println("Syntax error: Invalid declaration format. Expected: <type> <variable> = <expression>;");
            return null;
        }

        String type = declMatcher.group(1);
        String variable = declMatcher.group(2);
        String expr = declMatcher.group(3);

        if (type.isEmpty() || variable.isEmpty() || expr.isEmpty()) {
            System.out.println("Syntax error: Invalid declaration format. Expected: <type> <variable> = <expression>;");
            return null;
        }

        // Check type rule
        String lookupValue = TYPE_LOOKUP_TABLE.get(type);
        if (null == lookupValue || !lookupValue.equalsIgnoreCase("TYPE")) {
            System.out.println("Syntax error: Invalid type. Expected 'int[]' or 'double'.");
            return null;
        }

        // check variable rule
        Matcher variableMatcher = VARIABLE_PATTERN.matcher(variable);
        if (!variableMatcher.matches()) {
            System.out.println("Syntax error: Invalid variable name. It must start with a lowercase letter and contain only lowercase letters or digits.");
            return null;
        }

        // Check and parse expr
        return parseExpr(type, expr);

    }

    // Validate the expression and parse the number list
    private static Integer[] parseExpr(String type, String expr) {
        Matcher exprMatcher = AVERAGE_EXPR_PATTERN.matcher(expr);
        if (type.equals("int[]")) {
            exprMatcher = ARRAY_EXPR_PATTERN.matcher(expr);
        }

        if (!exprMatcher.matches()) {
            System.out.println(type.equals("int[]") ? "Syntax error: Invalid list expression. Expected format: [5, 8, 12]" : "Syntax error: Invalid average expression. Expected format: average([5, 8, 12])");
            return null;
        }

        String numbersInput = exprMatcher.group(1);

        // Split the input into individual number strings
        String[] numberStringArray = numbersInput.split(",", -1);
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String numberString : numberStringArray) {
                // According to the EBNF, numbers contain digits only
                if (!numberString.trim().matches("[0-9]+")) {
                    System.out.println("Syntax error: Invalid number. Only non-negative integers are allowed.");
                    return null;
                }
                numbers.add(Integer.parseInt(numberString.trim()));
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Number is out of range for an integer.");
            return null;
        }
        return numbers.toArray(new Integer[0]);

    }

    // Calculate the average
    private static double calculateAverage(Integer[] numbers) {
        // Initialize total and count
        long total = 0;
        int count = 0;
        for (int number : numbers) {
            total += number;
            count++;
        }
        // Calculate average
        return (double) total / count;
    }
}
