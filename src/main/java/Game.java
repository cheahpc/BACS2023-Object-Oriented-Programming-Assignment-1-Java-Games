import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Game {
    public static int gameCounter;

    private void continuePrompt() {
        System.out.println("Press {Enter} key to start the game!");
        try {
            System.in.read();
        } catch (Exception e) {

        }
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    private void tttPrintResult(int[] resultArr) {
        int dummyA = 0;
        int dummyB = 0;
        out.print(">>>    Available    |   Current Game\n");
        for (int x = 0; x < 3; x++) {
            out.print(">>>   ");
            for (int i = 0; i < 11; i++) {
                if ((i == 1) || (i == 5) || (i == 9)) {
                    dummyA++;
                    if (resultArr[dummyA] == 0) {
                        out.print(dummyA);
                    } else {
                        out.print(" ");
                    }
                } else if ((i == 3) || (i == 7)) {
                    out.print("|");
                } else {
                    out.print(" ");
                }
            }
            out.print("   |   ");
            for (int j = 0; j < 11; j++) {
                if ((j == 1) || (j == 5) || (j == 9)) {
                    dummyB++;
                    if (resultArr[dummyB] == 1) { // Computer
                        out.print("O");
                    } else if (resultArr[dummyB] == 2) { // Player
                        out.print("X");
                    } else {
                        out.print(" ");
                    }
                } else if ((j == 3) || (j == 7)) {
                    out.print("|");
                } else {
                    out.print(" ");
                }
            }
            if (x < 2) {
                out.println("\n>>>   ---|---|---   |   ---|---|---");
            } else {
                dummyA = 0;
                dummyB = 0;
                out.println(); // Print new line
            }
        }
        return;
    }

    private int tttCheckAlgorithm(int[] resultArr) {
        // Check winner
        if ((resultArr[1] != 0) && (resultArr[1] == resultArr[2]) // R1
                && (resultArr[1] == resultArr[3])) {
            return resultArr[1];
        } else if ((resultArr[4] != 0) && (resultArr[4] == resultArr[5]) // R2
                && (resultArr[4] == resultArr[6])) {
            return resultArr[4];
        } else if ((resultArr[7] != 0) && (resultArr[7] == resultArr[8]) // R3
                && (resultArr[7] == resultArr[9])) {
            return resultArr[7];
        } else if ((resultArr[1] != 0) && (resultArr[1] == resultArr[4]) // C1
                && (resultArr[1] == resultArr[7])) {
            return resultArr[1];
        } else if ((resultArr[2] != 0) && (resultArr[2] == resultArr[5]) // C2
                && (resultArr[2] == resultArr[8])) {
            return resultArr[2];
        } else if ((resultArr[3] != 0) && (resultArr[3] == resultArr[6]) // C3
                && (resultArr[3] == resultArr[9])) {
            return resultArr[3];
        } else if ((resultArr[1] != 0) && (resultArr[1] == resultArr[5]) // D\
                && (resultArr[1] == resultArr[9])) {
            return resultArr[1];
        } else if ((resultArr[3] != 0) && (resultArr[3] == resultArr[5]) // D/
                && (resultArr[3] == resultArr[7])) {
            return resultArr[3];
        } else {
            return 0;
        }
    }

    public boolean Hangman(int[] userResultVar) {
        final String[] words = { "secretary", "determine", "baby", "cow", "robot", "tank", "begin", "root", "ride",
                "meaning", "ignorant", "retire", "link", "grimace", "summer", "listen" };

        String word = words[(int) (Math.random() * words.length)];
        String dummy;
        Input in = new Input();
        Display show = new Display();
        int wordLengh = word.length();
        boolean[] correctGuessArr = new boolean[10];
        boolean correctGuess = false;

        gameCounter = 10;
        userResultVar[0] = 0;

        show.Hangman();
        continuePrompt();

        hmLoop1: for (int i = 0; i < correctGuessArr.length; i++) {
            out.print("Guess this word: ");
            // out.print(word + " "); // Debug
            for (int j = 0; j < wordLengh; j++) {
                if (correctGuessArr[j]) {
                    out.print(word.charAt(j));
                } else {
                    out.print("*");
                }
            }
            out.println(); // New line

            if (i == 9) {
                out.print(">>>   Guess ");
            } else {
                out.print(">>>   Guess  ");
            }
            out.print((i + 1) + ": ");

            // Check input range
            do {
                dummy = in.Read();
                if (!in.validCheck(1, dummy)) { // Invalid Input
                    show.errorMessage(1); // Invalid Input Message
                    i--;
                    continue hmLoop1;
                } else {
                    break;
                }
            } while (true);

            // Check input value for repeating letter
            for (int x = 0; x < wordLengh; x++) {
                if (correctGuessArr[x]) {
                    if (dummy.charAt(0) == word.charAt(x)) {
                        show.errorMessage(11);
                        i--;
                        continue hmLoop1;
                    }
                }
            }
            // Check input value for matching letter
            for (int y = 0; y < wordLengh; y++) {
                if (dummy.charAt(0) == word.charAt(y)) {
                    correctGuessArr[y] = true;
                    correctGuess = true;
                }
            }

            // Check completeness
            for (int j = 0; j < wordLengh; j++) {
                if (!correctGuessArr[j]) { // If any false for the whole word
                    break;
                } else if ((j == wordLengh - 1) && (correctGuessArr[j])) {
                    gameCounter = 0;
                    return true;
                }
            }

            if (correctGuess) {
                correctGuess = false; // Correct guess reset status
            } else {
                userResultVar[0]++; // Wrong guess increase counter
            }
        }
        gameCounter = 0;
        return false;
    }

    public void scissorRockPaper(int[] userResultVar) {
        // Reset Variables
        gameCounter = 10;
        userResultVar[30] = 0; // Computer Win Counter
        userResultVar[31] = 0; // Player Win Counter
        userResultVar[32] = 0; // Tie Counter
        Input in = new Input();
        Display show = new Display();

        String temp = ""; // For temporary read user input and checking
        int temp2; // For storing user input

        show.scissorRockPaper(); // Print the header
        continuePrompt(); // Prompt the user to start the game

        // Loop the game for 10 rounds
        srpLoop1: for (int i = 0; i < 10; i++) {
            // Computer
            Random rand = new Random(); // instance of random class
            userResultVar[i] = rand.nextInt(3); // Generate random between 0 and 2

            // User
            if (i == 9) {
                out.print(">>>   Round " + (i + 1) + ": ");
            } else {
                out.print(">>>   Round  " + (i + 1) + ": ");
            }

            do {
                temp = in.Read();
                if (!in.validCheck(2, temp)) { // Invalid Input
                    show.errorMessage(2); // Invalid Input Message
                    i--;
                    continue srpLoop1;
                } else {
                    break;
                }
            } while (true);

            // Debug
            // for (int x = 0; i < 9; i++) {
            // out.println("Computer: " + userResultVar[x] + " Player: " + userResultVar[x +
            // 10]);
            // }

            temp2 = Integer.parseInt(temp);
            userResultVar[i + 10] = temp2; // Store the value to array

            if (userResultVar[i] == 0) {
                if (userResultVar[i + 10] == 0) {
                    userResultVar[i + 20] = 2; // 00
                } else if (userResultVar[i + 10] == 1) {
                    userResultVar[i + 20] = 1; // 01
                } else if (userResultVar[i + 10] == 2) {
                    userResultVar[i + 20] = 0; // 02
                }
            } else if (userResultVar[i] == 1) {
                if (userResultVar[i + 10] == 0) {
                    userResultVar[i + 20] = 0; // 10
                } else if (userResultVar[i + 10] == 1) {
                    userResultVar[i + 20] = 2; // 11
                } else if (userResultVar[i + 10] == 2) {
                    userResultVar[i + 20] = 1; // 12
                }
            } else if (userResultVar[i] == 2) {
                if (userResultVar[i + 10] == 0) {
                    userResultVar[i + 20] = 1; // 20
                } else if (userResultVar[i + 10] == 1) {
                    userResultVar[i + 20] = 0; // 21
                } else if (userResultVar[i + 10] == 2) {
                    userResultVar[i + 20] = 2; // 22
                }
            }
            userResultVar[30 + (userResultVar[i + 20])]++; // Set Winner
            gameCounter--;
        }
        return;
    }

    public int ticTacToe() {
        Random rand = new Random(); // instance of random class
        Input in = new Input();
        Display show = new Display();

        String dummyA; // For user input
        int dummyB; // For user input
        int winner;
        gameCounter = 9;

        int[] resultArr = new int[10];

        show.ticTacToe();
        continuePrompt();

        tttPrintResult(resultArr); // Print the game Interface
        tttLoop1: do {

            // #region Player
            out.print("\n>>> Enter an available number: ");

            // Check input type range
            do {
                dummyA = in.Read();
                if (!in.validCheck(3, dummyA)) { // Invalid Input
                    show.errorMessage(3); // Invalid Input Message
                    continue tttLoop1;
                } else {
                    out.println("\n"); // Print new line
                    break;
                }
            } while (true);

            // Check input value range
            dummyB = Integer.parseInt(dummyA);
            if (resultArr[dummyB] == 0) {
                resultArr[dummyB] = 2;
                gameCounter--;
                out.println(">>>   Player's Move");
                tttPrintResult(resultArr);
                // Check Winner
                winner = tttCheckAlgorithm(resultArr);
                if (winner != 0) {
                    gameCounter = 0;
                    return winner;
                }
            } else {
                show.errorMessage(31); // Show not available message
                continue tttLoop1;
            }
            if (gameCounter == 0) {
                return 0;
            }
            // #endregion Player

            // #region Computer
            int temp = 0;
            do {
                temp = rand.nextInt(9) + 1; // Generate a number for computer
                if (resultArr[temp] != 0) {
                    continue;
                } else {
                    resultArr[temp] = 1;
                    gameCounter--;
                    out.println(">>>   Computer's Move");
                    tttPrintResult(resultArr);
                    // Check winner
                    winner = tttCheckAlgorithm(resultArr);
                    if (winner != 0) {
                        gameCounter = 0;
                        return winner;
                    }
                    break;
                }
            } while (true);
            // #endregion Computer

        } while (true);

    }

    public void flipAndMatch() {

        return;
    }

    public void FiveDice() {

        return;
    }
}
