package s02converthexorocttobin;

import java.util.Scanner;

/**
 * S02 - Convert hexadecimal, octal to binary.
 *
 * @author CE181079 Duong Nhat Anh
 */
public class MyLib {

    /**
     * Scanner object for user input.
     */
    public static Scanner sc = new Scanner(System.in);

    /**
     * Method to get a string from the user
     *
     * @param iMg Input message.
     * @return A String.
     */
    public static String getString(String iMg) {
        String x; // Variable to store the input
        boolean istype; // Flag to indicate if the input is valid
        do {
            System.out.print(iMg); // Print the input message
            x = sc.nextLine(); // Read the input as a string
            if (x.length() <= 0) { // Check if the input is empty
                System.out.println("Please type anything! don't leave it blank"); // Print a message to indicate the condition
                istype = false; // Set the flag to false
            } else {
                istype = true; // Set the flag to true
            }
        } while (!istype); // Loop until the flag is true
        return x; // Return the input
    }

    /**
     * Method to check if the string represents a negative number
     *
     * @param original Original string.
     * @return True if the string represents a negative number, false otherwise.
     */
    public static boolean checkNegative(String original) {
        char firstChar = original.charAt(0); // Get the first character of the string
        boolean isNegative; // Variable to store the result
        return isNegative = firstChar == '-'; // If the first character is a minus sign
    }

}
