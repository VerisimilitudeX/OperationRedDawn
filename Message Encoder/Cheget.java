import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Cheget {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] wires = { "red", "blue", "green", "yellow", "black", "white" };
        String wire1 = wires[random.nextInt(wires.length)];
        String wire2 = wires[random.nextInt(wires.length)];
        System.out.println(
                "Two wires have been randomly selected. You must input the correct two wires to unlock the device.");
        System.out.println("The available wires are: red, blue, green, yellow, black, white");
        Scanner scanner = new Scanner(System.in);
        boolean unlocked = false; // Added a boolean variable to track if the device is unlocked
        while (!unlocked) { // Added a while loop to repeat until the device is unlocked
            System.out.print("Enter the first wire: ");
            String input1 = scanner.nextLine();
            System.out.print("Enter the second wire: ");
            String input2 = scanner.nextLine();
            if (input1.equalsIgnoreCase(wire1) && input2.equalsIgnoreCase(wire2) ||
                    input1.equalsIgnoreCase(wire2) && input2.equalsIgnoreCase(wire1)) {
                        System.out.println("Establishing secure connection...");
                    TimeUnit.SECONDS.sleep(random.nextInt(10) + 10); // Added wait
                System.out.println(
                        "Congratulations! You have unlocked the device. Now, please enter the access code: " + "\n");
                String access = scanner.nextLine();
                if (access.equals("1105annihilate")) {
                    System.out.println("Securing connection 0%->100%");
                    TimeUnit.SECONDS.sleep(random.nextInt(51) + 10); // Added wait
                    System.out.println("Connection secured");
                    System.out.println("Transferring signal 0%->100%");
                    TimeUnit.SECONDS.sleep(random.nextInt(51) + 10); // Added wait
                    System.out.println("Awaiting confirmation 0%->100%");
                    TimeUnit.SECONDS.sleep(random.nextInt(51) + 10); // Added wait
                    System.out.println("Attempting deactivation of nuclear warhead [Cuba]...");
                    TimeUnit.SECONDS.sleep(random.nextInt(51) + 10); // Added wait
                    System.out.println("Correct access code entered. Please enter the deactivation code: " + "\n");
                    int deactivation = scanner.nextInt();
                    if (deactivation == 493) {
                        // Added fluff lines
                        System.out.println("Securing connection 0%->100%");
                        TimeUnit.SECONDS.sleep(random.nextInt(51) + 10); // Added wait
                        System.out.println("Connection secured");
                        System.out.println("Transferring signal 0%->100%");
                        TimeUnit.SECONDS.sleep(random.nextInt(51) + 10); // Added wait
                        System.out.println("Awaiting confirmation 0%->100%");
                        TimeUnit.SECONDS.sleep(random.nextInt(51) + 10); // Added wait
                        System.out.println("Attempting deactivation of nuclear warhead [Cuba]...");
                        TimeUnit.SECONDS.sleep(random.nextInt(51) + 10); // Added wait
                        System.out.println("Cheget successfully deactivated.");
                        unlocked = true; // Set the variable to true to end the loop
                    }
                }
            } else {
                System.out.println("Sorry, the wires you entered are incorrect. Please try again."); // Changed the
                                                                                                     // message to not
                                                                                                     // reveal the
                                                                                                     // answer
            }
        }
    }
}
