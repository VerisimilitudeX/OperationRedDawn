// Cheget.java
// A fictional program that rewires a cheget to give the user access

import java.util.Scanner; // for user input
import java.io.IOException;
import java.util.Random; // for random numbers

public class Cheget {

    // A constant for the number of wires in the cheget
    public static final int NUM_WIRES = 10;

    // A constant for the number of attempts allowed
    public static final int NUM_ATTEMPTS = 1000;

    // A constant for the success message
    public static final String SUCCESS_MESSAGE = "You have successfully rewired the cheget and gained access to Kazbek!";

    // A constant for the failure message
    public static final String FAILURE_MESSAGE = "You have failed to rewire the cheget and triggered an alarm!";

    // A scanner object for user input
    public static Scanner input = new Scanner(System.in);

    // A random object for generating random numbers
    public static Random random = new Random();

    // A main method that runs the program
    public static void main(String[] args) throws InterruptedException, IOException {
        Puzzles.clearTerminal();
        // Create an array of wires with random colors
        String[] wires = new String[NUM_WIRES];
        String[] colors = {"red", "blue", "green", "yellow", "black", "white", "orange", "purple", "pink", "brown"};
        for (int i = 0; i < NUM_WIRES; i++) {
            wires[i] = colors[random.nextInt(colors.length)];
        }

        // Print a welcome message and instructions
        System.out.println("Welcome to Cheget Rewire!");
        System.out.println("Your goal is to rewire the cheget to give yourself access to Kazbek.");
        System.out.println("You have " + NUM_ATTEMPTS + " attempts to cut and swap two wires.");
        System.out.println("If you cut and swap the correct wires, you will succeed.");
        System.out.println("If you cut and swap the wrong wires, you will fail and trigger an alarm.");
        System.out.println("Good luck!");

        // Start a loop for each attempt
        boolean success = false; // a flag to indicate success or failure
        int attempt = 1; // a counter for the current attempt
        while (!success && attempt <= NUM_ATTEMPTS) {

            // Print the current attempt number and the wires
            System.out.println("\nAttempt #" + attempt + ":");
            printWires(wires);

            // Ask the user to enter two wire numbers to cut and swap
            System.out.print("Enter two wire numbers (1-" + NUM_WIRES + ") separated by a space: ");
            int wire1 = input.nextInt(); // read the first wire number
            int wire2 = input.nextInt(); // read the second wire number

            // Check if the wire numbers are valid
            if (wire1 < 1 || wire1 > NUM_WIRES || wire2 < 1 || wire2 > NUM_WIRES) {
                System.out.println("Invalid wire numbers. Try again.");
                continue; // skip the rest of this iteration and go back to the loop
            }

            // Check if the wire numbers are different
            if (wire1 == wire2) {
                System.out.println("Same wire numbers. Try again.");
                continue; // skip the rest of this iteration and go back to the loop
            }

            // Cut and swap the wires by swapping their colors in the array
            String temp = wires[wire1 - 1]; // store the color of the first wire in a temporary variable
            wires[wire1 - 1] = wires[wire2 - 1]; // assign the color of the second wire to the first wire
            wires[wire2 - 1] = temp; // assign the color of the first wire to the second wire

            // Check if the user has succeeded or failed
            success = checkSuccess(wires); // call a method to check the success condition
            if (success) {
                System.out.println(SUCCESS_MESSAGE); // print the success message
            } else {
                System.out.println(FAILURE_MESSAGE); // print the failure message
                attempt++; // increment the attempt counter
            }
        }

        // Print a goodbye message
        System.out.println("\nThank you for playing Cheget Rewire!");
    }

    // A method that prints the wires and their colors
    public static void printWires(String[] wires) {
        for (int i = 0; i < NUM_WIRES; i++) {
            System.out.println("Wire #" + (i + 1) + ": " + wires[i]);
        }
    }

    // A method that checks the success condition
    public static boolean checkSuccess(String[] wires) {
        // A fictional success condition: the first and last wires must be red, and the middle wires must be blue
        // To make it easier, we can add a hint that tells the user which wires are correct
        int correctWires = 0; // a counter for the number of correct wires
        if (wires[0].equals("red")) {
            correctWires++; // increment the counter if the first wire is red
            System.out.println("Hint: Wire #1 is correct."); // print a hint
        }
        if (wires[NUM_WIRES - 1].equals("red")) {
            correctWires++; // increment the counter if the last wire is red
            System.out.println("Hint: Wire #" + NUM_WIRES + " is correct."); // print a hint
        }
        for (int i = 1; i < NUM_WIRES - 1; i++) {
            if (wires[i].equals("blue")) {
                correctWires++; // increment the counter if a middle wire is blue
                System.out.println("Hint: Wire #" + (i + 1) + " is correct."); // print a hint
            }
        }
        return correctWires == NUM_WIRES; // return true if all wires are correct, false otherwise
    }
}
