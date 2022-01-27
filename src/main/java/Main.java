import static java.lang.System.out;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public final static boolean DEBUG_MAIN = false;
    public final static boolean DEBUG_HANGMAN = false;
    public final static boolean DEBUG_SCISSOR_ROCK_PAPER = false;
    public final static boolean DEBUG_TIC_TAC_TOE = false;
    public final static boolean DEBUG_FLIP_AND_MATCH = false;
    public final static boolean DEBUG_FIVE_DICE = false;

    public static void main(String[] args) {

        
        String userInput; // To store user's input
        String gameOption; // To store game option

        Game run = new Game();

        boolean userWin = false; // To store the condition if the user win
        int[] Result = new int[33]; // Initialize Space to store game result

        Display.mainMenu(); // Print main menu interface

        menu: while (true) {

            // Ask for game option
            gameOption = Input.read();
            if (!Input.validCheck(0, gameOption)) { // Invalid Input
                Display.errorMessage(0); // Invalid Input Message
                continue menu; // Loop main menu again
            }

            gameOption = gameOption.toLowerCase(); // Convert to lower case

            game: while (true) {

                if (DEBUG_MAIN) {
                    out.println("The userInput is :" + userInput.charAt(0) + ":"); // Debug
                }

                switch (gameOption.charAt(0)) {
                    case 'a':
                        userWin = run.hangman(Result); // Execute hangman
                        break;
                    case 'b':
                        run.scissorRockPaper(Result); // Execute
                        break;
                    case 'c':
                        Result[0] = run.ticTacToe();
                        break;
                    case 'd':
                        run.flipAndMatch();
                        break;
                    case 'e':
                        run.fiveDice();
                        break;
                    default:
                        Display.errorMessage(6); // Invalid or unexpected input from user
                        continue menu;
                }

                // Ask if the user want to continue the game or try other game
                Display.gameOver(gameOption.charAt(0), userWin, Result);

                gameEnd: while (true) {
                    userInput = Input.read();
                    if (!Input.validCheck(6, userInput)) { // Invalid Input
                        Display.errorMessage(7); // Invalid Input Message
                        continue gameEnd;
                    } else {
                        if (userInput.toLowerCase().charAt(0) == 'n') {
                            Display.mainMenu();
                            continue menu;
                        } else {
                            continue game;
                        }
                    }

                }

            }

        }

    }

}
