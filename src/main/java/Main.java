import static java.lang.System.out;

public class Main {

    public final static boolean DEBUG_MAIN = false;
    public final static boolean DEBUG_HANGMAN = false;
    public final static boolean DEBUG_SCISSOR_ROCK_PAPER = false;
    public final static boolean DEBUG_TIC_TAC_TOE = false;
    public final static boolean DEBUG_FLIP_AND_MATCH = false;
    public final static boolean DEBUG_FIVE_DICE = false;

    public static void main(String[] args) {

        Game run = new Game();
        Display.mainMenu(); // Print main menu interface

        menu: while (true) {
            if (!Input.validCheck(0)) { // Invalid Input
                Display.errorMessage(0); // Invalid Input Message
                continue menu; // Loop main menu again
            }

            if (DEBUG_MAIN) {
                out.println("The userInput is :" + Input.getUserInput().charAt(0) + ":"); // Debug
            }

            // Run the game
            game: while (true) {
                switch (Input.getGameOption()) {
                    case 'a':
                        run.execHangman();
                        break;
                    case 'b':
                        run.execScissorRockPaper();
                        break;
                    case 'c':
                        run.execTicTacToe();
                        break;
                    case 'd':
                        // Ler Shean
                        break;
                    case 'e':
                        FiveDice.execute();
                        break;
                    default:
                        Display.errorMessage(6); // Invalid or unexpected input from user
                        continue menu;
                }

                // Print the game result and game over
                Display.gameOver();
                gameEnd: while (true) {
                    if (!Input.validCheck(6)) { // Invalid Input
                        Display.errorMessage(7); // Invalid Input Message
                        continue gameEnd; // Loop back to prompt user input
                    } else {
                        if (Input.getUserInput().toLowerCase().charAt(0) == 'n') { // If the user choose no
                            Display.mainMenu(); // Display the main menu UI
                            continue menu; // Loop back to prompt user input
                        } else { // If user choose yes
                            continue game; // Loop back to game
                        }
                    }
                }
            }
        }
    }
}
