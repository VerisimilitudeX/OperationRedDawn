import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Puzzles {
    public static String getClue(String input) {
        // Use a map to store the input-clue pairs
        Map<String, String> clues = new HashMap<>();
        clues.put("5673", "No noticable response was recieved."); //Placeholder for lock
        clues.put("8531", "4");
        clues.put("1634", "9");
        clues.put("4168", "3");

        // Return the clue for the input or a default value if not found
        return clues.getOrDefault(input, "No noticable response was recieved.");
    }

    public static void clearTerminal() throws InterruptedException, IOException {
        if (System.getProperty("os.name").contains("Windows")) { // if the os is Windows
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.print("\u001b[H\u001b[2J"); // unicode string to clear everything logged above this
            System.out.flush();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        while (true) {
            
            clearTerminal();
            System.out.println("Welcome to the Universal Communication Device. Enter a recipient code (\"stop\" to exit): ");
            String input = System.console().readLine();

            System.out.println("IMPORTANT: You will only see the clue for 1 second, so be ready.");
            System.out.print("Processing request");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }

            System.out.println("\n" + getClue(input));
            Thread.sleep(1000);
            if (input.equals("stop")) {
                break;
            }
        }
    }
}
