import static java.lang.System.out;

public class Display {

    public static void errorMessage(int menuType) {
        switch (menuType) {
            case 0: // Main Menu
                out.println("\n!!! ERROR !!! Option not available, please choose again. !!! ERROR !!!");
                out.print(">  Please enter the alphabet of your desired game: ");
                return;
            case 1: // Hangman
                out.println("!!! ERROR !!! Illegal character, please enter a letter from {a-z} only. !!! ERROR !!!");
                return;
            case 2: // Scissor Rock Paper
                out.println("!!! ERROR !!! Option not available, please enter {0}, {1}, or {2} only. !!! ERROR !!!");
                return;
            case 3: // Tic-Tac-Toe
                out.println("\n\n!!! ERROR !!! Illegal input detected. Please enter value {1-9} only. !!! ERROR !!!");
                return;
            case 4: // Flip and Match
                out.println("\n\n!!! ERROR !!! Invalid input. Please enter value {1-20} only.         !!! ERROR !!!");
                return;
            case 5: // Five Dice
                return;
            case 6: // Unexpected Error Occured
                out.println("\n!!! ERROR !!! Unexpected event occured. Program will go to main menu. !!! ERROR !!!\n");
                return;
            case 7: // Continue Game?
                out.println("\n!!! ERROR !!! Option not available, please choose again. !!! ERROR !!!");
                out.print(">  Please enter {Y} or {y} for Yes and {N} or {n}: ");
                return;
            case 11:
                out.println("!!! ERROR !!! You have guessed this letter, please choose letter. !!! ERROR !!!");
                return;
            case 31:
                out.println(
                        "\n\n!!! ERROR !!! Number already taken, please select form the avalable table. !!! ERROR !!!");
                return;
            case 41:
                out.println(
                        "\n\n!!! ERROR !!! Number already taken, please select form the avalable table. !!! ERROR !!!");
                return;
            default:
                out.println("!!! ERROR !!! Unexpected input detected. !!! ERROR !!!");
                return;
        }
    }

    public static void gameOver(char gameType, boolean userWin, int userResult[]) {

        switch (gameType) {
            case 'a':
                out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                if (userWin) { // If the user won
                    if (userResult[0] == 0) {
                        out.println("+++   Awesome! You didn't even miss a letter!             +++\n");
                    } else if (userResult[0] == 1) {
                        out.println("+++   Great Job! You missed just once!                    +++\n");
                    } else {
                        out.println(
                                "+++   Well Done! Too bad you missed " + userResult[0] + " times.              +++\n");
                    }
                } else { // If the user lose
                    out.println("+++   Opps, better luck next time!                        +++\n");
                }
                out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                break;
            case 'b':
                out.println("\n+++++++++++++++++++++      Result      ++++++++++++++++++++++");
                out.println("+++  Round    Computer      Player       Winner           +++");
                out.print("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                for (int i = 0; i < 10; i++) {
                    if (i == 9) {
                        out.print("\n+++    ");
                    } else {
                        out.print("\n+++     ");
                    }
                    out.print(i + 1);

                    for (int j = 0; j < 11; j += 10) {
                        switch (userResult[i + j]) {
                            case 0: // Scissor
                                out.print("     Scissor  ");
                                break;
                            case 1: // Rock
                                out.print("     Rock     ");
                                break;
                            case 2: // Paper
                                out.print("     Paper    ");
                                break;
                            default:
                                break;
                        }
                    }

                    if (userResult[i + 20] == 0) {
                        out.print("    Computer");
                    } else if (userResult[i + 20] == 1) {
                        out.print("    Player");
                    } else {
                        out.print("    Tie");
                    }
                }
                out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                if (userResult[30] > 1) { // Check if the computer win more than a game
                    out.println("+++   The Computer won " + userResult[30] + " games.");
                } else {
                    out.println("+++   The Computer won " + userResult[30] + " game.");
                }
                if (userResult[31] > 1) { // Check if the player win more than a game
                    out.println("+++   The Player won " + userResult[31] + " games.");
                } else {
                    out.println("+++   The Player won " + userResult[31] + " game.");
                }
                if (userResult[32] > 1) { // Check if there is more than a tie
                    out.println("+++   There are " + userResult[32] + " ties in the game.");
                } else {
                    out.println("+++   There is " + userResult[32] + " tie in the game.");
                }
                out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                break;
            case 'c':
                out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                if (userResult[0] == 0) { // If the game is a tie
                    out.println("+++   What a great match! It is a tie!                    +++\n");
                } else if (userResult[0] == 1) { // If the computer won
                    out.println("+++   Too bad, the Computer Wins!                         +++\n");
                } else if (userResult[0] == 2) { // If the player won
                    out.println("+++   Congratulations! You are smarter than the computer! +++\n");
                }
                out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                break;
            case 'd':
                out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                out.println("+++   Awesome! You have completed the puzzle!             +++\n");
                out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                break;
            case 'e':
                break;

            default:
                break;
        }

        out.println(">>>                       GAME OVER                       <<< ");
        out.println(">>>                     Continue? Y/N                     <<< ");
        out.print(">>> ");
        return;
    }

    public static void mainMenu() {
        out.println("+++++++++++++++++++++++++++++++++++++++++\n");
        out.println("              Java Games");
        out.println("\n+++++++++++++++++++++++++++++++++++++++++\n");
        out.println(">----------------------------------------");
        out.println(">  Options   |  Description");
        out.println(">----------------------------------------");
        out.println(">     A      |  Hangman");
        out.println(">     B      |  Scissor, Rock, Paper");
        out.println(">     C      |  Tic-Tac-Toe");
        out.println(">     D      |  Flip and Match");
        out.println(">     E      |  Five Dice");
        out.println(">----------------------------------------");
        out.print(">  Please enter the alphabet of your desired game: ");
    }

    public static void hangman() {
        out.println("\n\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        out.println("+++             Welcome to the Hangman Game!             ++++");
        out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        out.println("++++++++++++++++++++++++   Rule   +++++++++++++++++++++++++++");
        out.println("+++   1. You are given a random word wintin 10 letters    +++");
        out.println("+++   2. You have 10 chances to guess all the letters     +++");
        out.println("+++   3. Only one letter is allowed for each guess        +++");
        out.println("+++   4. All letters are in small capital                 +++");
        out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        return;
    }

    public static void scissorRockPaper() {
        out.println("\n\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        out.println("+++       Welcome to the Scissor Paper Rock Game!        ++++");
        out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        out.println("++++++++++++++++++++++++   Rule   +++++++++++++++++++++++++++");
        out.println("++++++++++   Digit   +++++++++++++++   Represents   +++++++++");
        out.println("+++            0            |          Scissor            +++");
        out.println("+++            1            |          Rock               +++");
        out.println("+++            2            |          Paper              +++");
        out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        return;
    }

    public static void ticTacToe() {
        out.println("\n\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        out.println("+++           Welcome to the Tic-Tac-Toe Game!           ++++");
        out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        out.println("++++++++++++++++++++++++   Rule   +++++++++++++++++++++++++++");
        out.println("+++   1. Select a number (1-9) to place your symbol       +++");
        out.println("+++   2. Form a straight line with 3 matching symbol      +++");
        out.println("+++   3. Horizontal, Vertical, and diagonal line accepted +++");
        out.println("+++   4. Player will be represented by 'X'                +++");
        out.println("+++   4. Computer will be represented by 'O'              +++");
        out.println("+++                                                       +++");
        out.println("+++                   Numbering Diagram                   +++");
        out.println("+++                      1 | 2 | 3                        +++");
        out.println("+++                     ---|---|---                       +++");
        out.println("+++                      4 | 5 | 6                        +++");
        out.println("+++                     ---|---|---                       +++");
        out.println("+++                      8 | 7 | 9                        +++");
        out.println("+++                                                       +++");
        out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        return;
    }

    public static void flipAndMatch() {
        out.println("\n\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        out.println("+++         Welcome to the Flip and Match Game!          ++++");
        out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        out.println("++++++++++++++++++++++++   Rule   +++++++++++++++++++++++++++");
        out.println("+++   1. Select a pair of available number                +++");
        out.println("+++   2. Find all matching pair to complete the game      +++");
        out.println("+++                                                       +++");
        out.println("+++                   Numbering Diagram                   +++");
        out.println("+++                    1 |  2 |  3 |  4                   +++");
        out.println("+++                  ----|----|----|----                  +++");
        out.println("+++                    5 |  6 |  7 |  8                   +++");
        out.println("+++                  ----|----|----|----                  +++");
        out.println("+++                    9 | 10 | 11 | 12                   +++");
        out.println("+++                  ----|----|----|----                  +++");
        out.println("+++                   13 | 14 | 15 | 16                   +++");
        out.println("+++                  ----|----|----|----                  +++");
        out.println("+++                   17 | 18 | 19 | 20                   +++");
        out.println("+++                                                       +++");
        out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        return;
    }
}
