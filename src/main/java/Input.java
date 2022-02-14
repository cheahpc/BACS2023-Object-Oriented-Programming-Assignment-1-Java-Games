import java.util.regex.*;
import java.util.Scanner;

public class Input {

    private static String userInput; // To store user's input
    private static String gameOption; // To store game option
    public static Scanner sc = new Scanner(System.in);

    static String getUserInput() {
        return userInput;
    }

    static char getGameOption() {
        return gameOption.charAt(0);
    }

    public static String read() {
        do {
            try {
                userInput = Input.sc.nextLine();
                return userInput;
            } catch (Exception e) {
                System.out.println("Error! Unable to process input.");
            }
        } while (true);
    }

    public static boolean validCheck(int menuType) {
        Pattern regExPat;
        Matcher matchVar;

        userInput = Input.read(); // Read user input

        // Check input type range
        switch (menuType) {
            case 0: // Main Menu
                gameOption = userInput;
                gameOption.toLowerCase(); // Convert to lower case
                regExPat = Pattern.compile("[abcde]{1}");
                break;
            case 1: // Hangman
                regExPat = Pattern.compile("[a-z]");
                break;
            case 2: // Scissor Rock Paper
                regExPat = Pattern.compile("[0-2]{1}");
                break;
            case 3: // Tic-Tac-Toe
                regExPat = Pattern.compile("[1-9]{1}");
                break;
            // case 4: // Flip and Match
            // regExPat = Pattern.compile("[0-9]{1,2}");
            // break;
            // case 5: // Five Dice
            // break;
            case 6: // Game Continue Option
                regExPat = Pattern.compile("[yYnN]{1}");
                break;
            default:
                return false;
        }
        matchVar = regExPat.matcher(userInput);

        // Check input value range
        if ((menuType == 4) && (matchVar.matches())) {
            if ((Integer.parseInt(userInput) <= 20) && (Integer.parseInt(userInput) >= 1)) {
                return true; // Value witin range of 0 to 20
            } else {
                return false; // Value out of range 0 to 20
            }
        }
        // Return
        return matchVar.matches();
    }
}
