import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        Display show = new Display();
        Input in = new Input();
        Game run = new Game();

        String userInput;

        String gameOption;
        boolean userWin = false;
        int[] Result = new int[33]; // Initialize Space to store game result

        // int[] Result = { 0, 2, 1, 2, 1, 2, 2, 1, 0, 2,
        // 1, 2, 1, 0, 2, 1, 0, 2, 1, 2,
        // 2, 1, 0, 0, 0, 2, 1, 2, 1, 2,
        // 1, 2, 3 };

        show.mainMenu();
        menu: while (true) {
            gameOption = in.Read();
            // Check input
            if (!in.validCheck(0, gameOption)) { // Invalid Input
                show.errorMessage(0); // Invalid Input Message
                continue menu; // Loop main menu again
            }
            gameOption = gameOption.toLowerCase();

            game:
            // Run the game in loop
            while (true) {
                // out.println("The gameOption is :" + gameOption.charAt(0) + ":"); // Debug

                switch (gameOption.charAt(0)) {
                    case 'a':
                        userWin = run.Hangman(Result);
                        break;
                    case 'b':
                        run.ScissorRockPaper(Result);
                        break;
                    case 'c':
                        run.TicTacToe();
                        break;
                    case 'd':
                        run.FlipAndMatch();
                        break;
                    case 'e':
                        run.FiveDice();
                        break;

                    default:
                        show.errorMessage(6);
                        continue menu;

                }

                // Game.gameCounter = 0;
                // Ask if the user want to continue the game or try other game
                if (Game.gameCounter == 0) {

                    show.gameOver(gameOption.charAt(0), userWin, Result);

                    gameEnd: while (true) {
                        userInput = in.Read();
                        if (!in.validCheck(6, userInput)) { // Invalid Input
                            show.errorMessage(7); // Invalid Input Message
                            continue gameEnd;
                        } else {
                            if (userInput.toLowerCase().charAt(0) == 'n') {
                                show.mainMenu();
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

}
