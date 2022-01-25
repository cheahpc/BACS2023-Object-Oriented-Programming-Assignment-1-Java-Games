import java.util.Scanner;
import java.util.regex.*;

public class Input {

    public String Read() {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        return userInput;
    }

    public boolean validCheck(int menuType, String userInput) {
        Pattern p;
        Matcher m;
        // Check input type range
        switch (menuType) {
            case 0: // Main Menu
                p = Pattern.compile("[abcdeABCDE]{1}");
                break;
            case 1: // Hangman
                p = Pattern.compile("[a-z]");
                break;
            case 2: // Scissor Rock Paper
                p = Pattern.compile("[0-2]{1}");
                break;
            case 3: // Tic-Tac-Toe
                p = Pattern.compile("[1-9]{1}");
                break;
            case 4: // Flip and Match
                p = Pattern.compile("[0-9]{1,2}");
                break;
            // case 5: // Five Dice
            case 6: // Game Continue Option
                p = Pattern.compile("[yYnN]{1}");
                break;
            default:
                return false;
        }
        m = p.matcher(userInput);

        // Check input value range
        if ((menuType == 4) && (m.matches())) {
            if ((Integer.parseInt(userInput) <= 20) && (Integer.parseInt(userInput) >= 1)) {
                return true;
            } else {
                return false;
            }
        }
        // Return
        return m.matches();
    }
}
