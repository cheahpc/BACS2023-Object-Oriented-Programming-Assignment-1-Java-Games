import static java.lang.System.out;

public class Display {
    public void mainMenu() {
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

    public void errorMessage(int menuType) {
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
            case 4: // Flip and Match
            case 5: // Five Dice
            case 6: // Unexpected Error Occured
                out.println("\n!!! ERROR !!! Unexpected event occured. Program will go to main menu. !!! ERROR !!!\n");
                return;
            case 7:
                out.println("\n!!! ERROR !!! Option not available, please choose again. !!! ERROR !!!");
                out.print(">  Please enter {Y} or {y} for Yes and {N} or {n}: ");
                return;
            case 11:
                out.println("!!! ERROR !!! You have guessed this letter, please choose letter. !!! ERROR !!!");
                return;

            default:
                return;
        }
    }

    public void gameOver(char gameType, boolean userWin, int userResult[]) {

        if (gameType == 'a') { // Hangman
            out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            if (userWin) {
                if (userResult[0] == 0) {
                    out.println("\n+++   Awesome! You didn't even miss a letter!             +++\n");
                } else if (userResult[0] == 1) {
                    out.println("\n+++   Great Job! You missed just once!                    +++\n");
                } else {
                    out.println("\n+++   Well Done! Too bad you missed " + userResult[0] + " times.         <<<\n");
                }
            } else {
                out.println("\n+++   Opps, better luck next time!                        +++\n");
            }
            out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        } else if (gameType == 'b') { // Scissor Rock Paper

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
            if (userResult[30] > 1) {
                out.println("+++   The Computer won " + userResult[30] + " games.");
            } else {
                out.println("+++   The Computer won " + userResult[30] + " game.");
            }
            if (userResult[31] > 1) {
                out.println("+++   The Player won " + userResult[31] + " games.");
            } else {
                out.println("+++   The Player won " + userResult[31] + " game.");
            }
            if (userResult[32] > 1) {
                out.println("+++   There are " + userResult[32] + " ties in the game.");
            } else {
                out.println("+++   There is " + userResult[32] + " tie in the game.");
            }
            out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        } else if (gameType == 'c') { // Tic-Tac-Toe

        } else if (gameType == 'd') { // Flip and Match

        } else if (gameType == 'e') { // Five Dice

        } else {
        }

        out.println(">>>                       GAME OVER                       <<< ");
        out.println(">>>                     Continue? Y/N                     <<< ");
        out.print(">>> ");
        return;
    }

    public void Hangman() {
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

    public void ScissorRockPaper() {
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
}
