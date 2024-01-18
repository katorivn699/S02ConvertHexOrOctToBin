/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s02converthexorocttobin;

/**
 * S02 - Convert hexadecimal, octal to binary.
 *
 * @author CE181079 Duong Nhat Anh
 */
public class S02ConvertHexOrOctToBin {

    // Declare some variables to store the input and output numbers
    String original; // The original input number
    String hexnum; // The hexadecimal number without the 'h' suffix
    String octnum; // The octal number without the 'q' suffix
    String binnum; // The binary number
    boolean ishex; // A flag to indicate whether the input is hexadecimal or not

    boolean isError; // A flag to indicate whether there is an input error or not

    /**
     * A method to display the title of the program
     */
    public void startTitle() {
        // Check if there is an input error
        if (!isError) {
            // If not, print the title of the program
            System.out.println("Convert Hexadecimal number / Octal number to Binary program");
        }
        // Reset the error flag to false
        isError = false;
    }

    /**
     * A method to read the input number from the user
     */
    private void inputString() {
        // Prompt the user to enter a hexadecimal or octal number with a suffix
        original = MyLib.getString("Enter a Hexadecimal(h)/Octal(q) number: ");
        original = original.trim();
    }

    /**
     * This method checks if the input number is a valid octal number
     *
     * @param octnum the input number as a string
     * @return true if the input number is a valid octal number, false otherwise
     */
    private boolean checkOctal(String octnum) {
        // Declare a boolean variable to store the result
        boolean isOk = false;
        // Loop through each character of the input number
        for (int i = 0; i < octnum.length(); i++) {
            // If the character is between '0' and '7', the input number is valid
            if (octnum.charAt(i) >= '0' && octnum.charAt(i) <= '7') {
                isOk = true;
            } else {
                // If the character is not between '0' and '7', the input number is invalid
                isOk = false;
                // Return false and exit the loop
                return isOk;
            }
        }
        // Return the result
        return isOk;
    }

    /**
     * This method checks if the input number is a valid hexadecimal number
     *
     * @param hexnum the input number as a string
     * @return true if the input number is a valid hexadecimal number, false
     * otherwise
     */
    private boolean checkHexadecimal(String hexnum) {
        // Declare a boolean variable to store the result
        boolean isOk = false;
        // Loop through each character of the input number
        for (int i = 0; i < hexnum.length(); i++) {
            // If the character is between '0' and '9' or 'A' and 'F', the input number is valid
            if (hexnum.charAt(i) >= '0' && hexnum.charAt(i) <= '9') {
                isOk = true;
            } else if (hexnum.toUpperCase().charAt(i) >= 'A' && hexnum.toUpperCase().charAt(i) <= 'F') {
                isOk = true;
            } else {
                // If the character is not between '0' and '9' or 'A' and 'F', the input number is invalid
                isOk = false;
                // Return false and exit the loop
                return isOk;
            }
        }
        // Return the result
        return isOk;
    }

    /**
     * A method to convert the input number from hexadecimal or octal to binary
     */
    public void convertString() {
        // Initialize the ishex flag to false
        // This flag indicates whether the input string is a hexadecimal number or not
        ishex = false;
        // Initialize the binnum to an empty string
        // This string will store the binary representation of the input string
        binnum = "";
        // Check if the input string is a negative number using the MyLib class
        // If it is, print an error message and return
        if (!MyLib.checkNegative(original)) {
            // Check if the input string ends with "H" or "h"
            // If it does, it means the input string is a hexadecimal number
            if (original.endsWith("H") || original.endsWith("h")) {
                // Remove the last character "H" or "h" from the input string
                // and trim any leading or trailing spaces
                hexnum = original.substring(0, original.length() - 1).trim();
                // Check if the input string is a valid hexadecimal number using the checkHexadecimal method
                // If it is, convert it to a binary number using the convertHexadecimalToBinary method
                // and set the ishex flag to true
                if (checkHexadecimal(hexnum)) {
                    binnum = convertHexadecimalToBinary(hexnum);
                    ishex = true;
                    isError = false;
                    // Print the output string using the outputString method
                    outputString();
                    // Wait for the user to press a key using the pressKey method
                    pressKey();
                } else {
                    // If the input string is not a valid hexadecimal number, print an error message
                    isError = true;
                    System.out.println("String number must be from '0' to 'F'! Enter again.");
                }
                // Check if the input string ends with "Q" or "q"
                // If it does, it means the input string is an octal number
            } else if (original.endsWith("Q") || original.endsWith("q")) {
                // Remove the last character "Q" or "q" from the input string
                // and trim any leading or trailing spaces
                octnum = original.substring(0, original.length() - 1).trim();
                // Check if the input string is a valid octal number using the checkOctal method
                // If it is, convert it to a binary number using the convertOctalToBinary method
                // and set the ishex flag to false
                if (checkOctal(octnum)) {
                    binnum = convertOctalToBinary(octnum);
                    ishex = false;
                    isError = false;
                    // Print the output string using the outputString method
                    outputString();
                    // Wait for the user to press a key using the pressKey method
                    pressKey();
                } else {
                    isError = true;
                    // If the input string is not a valid octal number, print an error message
                    System.out.println("String number must be from '0' to '7'! Enter again.");
                }
            } else {
                // If the input string does not end with "H", "h", "Q", or "q", print an error message
                isError = true;
                System.out.println("Last letter must be 'h' or 'H' or 'Q' or 'q'! Enter again");
            }
        } else {
            // If the input string is a negative number, print an error message
            isError = true;
            System.out.println("String must be positive number! Enter again");
        }
    }

    /**
     * A method to display the binary number
     */
    public void outputString() {
        // Check if the input number is hexadecimal or not
        if (!ishex) {
            // If not, print the binary number with a 'b' suffix and a space after every 3 digits
            System.out.printf("Binary number: " + binnum.replaceAll("...", "$0 ").trim() + "b\n");
        } else {
            // If yes, print the binary number with a 'b' suffix and a space after every 4 digits
            System.out.printf("Binary number: " + binnum.replaceAll("....", "$0 ").trim() + "b\n");
        }
    }

    /**
     * This method converts a hexadecimal string to a binary string using simple
     * arithmetic operations.
     *
     * @param original A string hexadecimal
     * @return A string binary.
     */
    public String convertHexadecimalToBinary(String original) {
        String res = "";
        // Loop through each character of the original string
        for (int i = 0; i < original.length(); i++) {
            // Get the ASCII code of the current character
            int num = original.charAt(i);
            // Convert the ASCII code to a decimal number 
            // If the character is a digit from 0 to 9, subtract 48 from the ASCII code
            try {
                if (num >= '0' && num <= '9') {
                    num -= '0';
                    // If the character is a letter from A to F, subtract 55 from the ASCII code
                } else if (num >= 'A' && num <= 'F') {
                    num -= 'A' - 10;
                    // If the character is a letter from a to f, subtract 87 from the ASCII code
                } else if (num >= 'a' && num <= 'f') {
                    num -= 'a' - 10;
                    // If the character is not a valid hexadecimal digit, return an error message
                } else {
                    throw new Exception();
                }
                // Convert the decimal number to a binary string using a loop
                String bin = "";
                while (num > 0) {
                    // Get the remainder of dividing the number by 2
                    // If the remainder is 0, then append "0" to the beginning of the string
                    // If the remainder is 1, then append "1" to the beginning of the string 
                    bin = (num % 2 == 0 ? "0" : "1") + bin;
                    // Divide the number by 2 to get the next digit
                    num /= 2;
                }
                // Pad the binary string with zeros to make it 4 digits long
                while (bin.length() < 4) {
                    bin = "0" + bin;
                }
                // Append the binary string to the result
                res += bin;
            } catch (Exception e) {
                original = "";
            }
        }
        return res;
    }

    /**
     * This method converts a hexadecimal string to a hexadecimal string. using
     * for loops and bitwise operations.
     *
     * @param original A string hexadecimal
     * @return A string binary.
     */
    public String convertOctalToBinary(String original) {
        String res = "";
        // Loop through each character of the original string
        for (int i = 0; i < original.length(); i++) {
            // Get the ASCII code of the current character
            int num = original.charAt(i);
            // Convert the ASCII code to a decimal number 
            // If the character is a digit from 0 to 7, subtract 48 from the ASCII code
            try {
                if (num >= '0' && num <= '7') {
                    num -= '0';
                } else {
                    throw new Exception();
                }
                String bin = "";
                while (num > 0) {
                    // Get the remainder of dividing the number by 2
                    // If the remainder is 0, then append "0" to the beginning of the string
                    // If the remainder is 1, then append "1" to the beginning of the string 
                    bin = (num % 2 == 0 ? "0" : "1") + bin;
                    // Divide the number by 2 to get the next digit
                    num /= 2;
                }
                // Pad the binary string with zeros to make it 3 digits long
                while (bin.length() < 3) {
                    bin = "0" + bin;
                }
                res += bin;
            } catch (Exception e) {
                original = "";
            }
        }
        return res;
    }

    /**
     * A method to prompt the user to press any key to do another conversion
     */
    private void pressKey() {
        // Print the prompt message
        System.out.print("Press any key to do another conversion.");
        // Try to read the user input
        try {
            // Read the next line from the scanner
            this.original = MyLib.sc.nextLine();
            // Print a separator line
            System.out.println("-----------------------");
            // Reset the error flag to false
            isError = false;
        } catch (Exception e) {
        }
    }

    /**
     * This is the main method of the class
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Declare an object of the S02ConvertHexOrOctToBin class
        S02ConvertHexOrOctToBin app = new S02ConvertHexOrOctToBin();
        // Use a do-while loop to repeat the conversion process
        do {
            // Call the StartTitle method to display the title of the program
            app.startTitle();
            // Call the InputString method to read the input number from the user
            app.inputString();
            // Call the ConvertString method to convert the input number to binary
            app.convertString();
            // Repeat the loop while true
        } while (true);
    }

}
