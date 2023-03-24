import java.util.HashMap;
import java.util.Scanner;
import java.time.Instant;

public class MyClass {

    public static void main(String[] args) throws InterruptedException {
        // Create a HashMap to store the keys and values
        HashMap<Long, String> map = new HashMap<>();

        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Create a loop to get two inputs
        for (int i = 0; i < 2; i++) {
            // Display a drop down menu with yes or no options
            System.out.println("Please select yes or no from the drop down menu:");
            System.out.println("[yes] [no]");

            // Read the user input
            String input = scanner.nextLine();

            // Validate the input
            if (input.equals("yes") || input.equals("no")) {
                // Get the current timestamp as the key
                long key = Instant.now().getEpochSecond();

                // Store the key and value in the map
                map.put(key, input);

                // Print a confirmation message
                System.out.println("You selected " + input + " at " + key);

                // Wait for 5 seconds before getting the next input
                Thread.sleep(5000);
            } else {
                // Print an error message and exit the loop
                System.out.println("Invalid input. Please select yes or no.");
                break;
            }
        }

        // Close the scanner
        scanner.close();

        // Check if both answers are yes and print appropriate message
        int yesCount = 0;
        for (String value : map.values()) {
            if (value.equals("yes")) {
                yesCount++;
            }
        }
        if (yesCount == 2) {
            System.out.println("Agreement reached");
        } else {
            System.out.println("DENIED");
        }

        // Print the map contents
        System.out.println("The map contains:");
        for (Long key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }
}

