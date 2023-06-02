import java.io.IOException;

public class Puzzles {
    public static String getClue(String input) {
        String clue = switch (input) {
            case "8531" -> "2";
            case "1634" -> "5";
            case "4168" -> "9";
            case "1687" -> "1";
            default -> "No noticable response was recieved.";
        };
        return clue;
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
            for (int i = 0; i < 10; i++) {
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