import java.util.Random;

import static java.lang.System.out;

public class Game {
    private Random rand = new Random(); // instance of random class
    private static int[] resultArr = new int[33]; // Initialize Space to store game result
    private final String[] words = { "secretary", "determine", "baby", "cow", "robot", "tank", "begin", "root", "ride",
            "meaning", "ignorant", "retire", "link", "grimace", "summer", "listen" };

    private static String hangmanWord;

    static String getHangmanWord() {
        return hangmanWord;
    }

    static int getResultArr(int index) {
        return resultArr[index];
    }

    private static void continuePrompt() {
        System.out.println("Press {Enter} key to start the game!"); // Print prompt message
        try {
            Main.sc.nextLine(); // Read input
        } catch (Exception e) {
            System.out.println("Error! Unable to process input."); // Unexpected exception message
        }
    }

    private static void wait(int ms) {
        try {
            Thread.sleep(ms); // Try to sleep for ms milliseconds
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();// Unexpected error occur
        }
    }

    private static void tttPrintResult(int[] resultArr) {
        int dummyA = 0; // Counter for Available numbers
        int dummyB = 0; // Counter for Current Game

        out.print(">>>    Available    |   Current Game\n");
        for (int x = 0; x < 3; x++) { // For 3 lines
            out.print(">>>   ");
            for (int i = 0; i < 11; i++) { // Print the Available number
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
            out.print("   |   "); // Print seperating line for Available number and Current Game
            for (int j = 0; j < 11; j++) { // Print the Current Game
                if ((j == 1) || (j == 5) || (j == 9)) {
                    dummyB++;
                    if (resultArr[dummyB] == 1) { // If computer taken this number
                        out.print("O"); // Print the O symbol for computer
                    } else if (resultArr[dummyB] == 2) { // If Player taken this number
                        out.print("X"); // Print the X symbol for player
                    } else { // If this number is not taken
                        out.print(" "); // Print a space
                    }
                } else if ((j == 3) || (j == 7)) {
                    out.print("|");
                } else {
                    out.print(" ");
                }
            }
            // Print seperating line for each row
            out.println((x < 2) ? "\n>>>   ---|---|---   |   ---|---|---" : "\n");
        }
        return;
    }

    private static int tttCheckAlgorithm(int[] arr) {
        // Check winner for each possible winning condition
        if ((arr[1] != 0) && (arr[1] == arr[2]) // R1
                && (arr[1] == arr[3])) {
            return arr[1];
        } else if ((arr[4] != 0) && (arr[4] == arr[5]) // R2
                && (arr[4] == arr[6])) {
            return arr[4];
        } else if ((arr[7] != 0) && (arr[7] == arr[8]) // R3
                && (arr[7] == arr[9])) {
            return arr[7];
        } else if ((arr[1] != 0) && (arr[1] == arr[4]) // C1
                && (arr[1] == arr[7])) {
            return arr[1];
        } else if ((arr[2] != 0) && (arr[2] == arr[5]) // C2
                && (arr[2] == arr[8])) {
            return arr[2];
        } else if ((arr[3] != 0) && (arr[3] == arr[6]) // C3
                && (arr[3] == arr[9])) {
            return arr[3];
        } else if ((arr[1] != 0) && (arr[1] == arr[5]) // D\
                && (arr[1] == arr[9])) {
            return arr[1];
        } else if ((arr[3] != 0) && (arr[3] == arr[5]) // D/
                && (arr[3] == arr[7])) {
            return arr[3];
        } else {
            return 0;
        }
    }

    private static void srpCheckAlgorithm(int index) {
        // Check for each possible outcome and set the winner
        if (resultArr[index] == 0) {
            if (resultArr[index + 10] == 0) {
                resultArr[index + 20] = 2; // 00 Set Tie
            } else if (resultArr[index + 10] == 1) {
                resultArr[index + 20] = 1; // 01 Set Player Win
            } else if (resultArr[index + 10] == 2) {
                resultArr[index + 20] = 0; // 02 Set Computer Win
            }
        } else if (resultArr[index] == 1) {
            if (resultArr[index + 10] == 0) {
                resultArr[index + 20] = 0; // 10 Set Computer Win
            } else if (resultArr[index + 10] == 1) {
                resultArr[index + 20] = 2; // 11 et Tie
            } else if (resultArr[index + 10] == 2) {
                resultArr[index + 20] = 1; // 12 Set Player Win
            }
        } else if (resultArr[index] == 2) {
            if (resultArr[index + 10] == 0) {
                resultArr[index + 20] = 1; // 20 Set Player Win
            } else if (resultArr[index + 10] == 1) {
                resultArr[index + 20] = 0; // 21 Set Computer Win
            } else if (resultArr[index + 10] == 2) {
                resultArr[index + 20] = 2; // 22 Set Tie
            }
        }
    }

    public void execHangman() {

        // Predefined words with 10 letters
        hangmanWord = words[(int) (Math.random() * words.length)]; // Set a random word from the list of words
        boolean[] correctGuessArr = new boolean[10]; // Array to keep track of the correct guess
        boolean correctGuess = false; // Boolean to check if the user guessed correctly
        resultArr[0] = 0; // Reset the array

        Display.hangman(); // Print hangman UI and rules
        continuePrompt();
        hmLoop1: for (int i = 0; i < correctGuessArr.length; i++) {
            // #region Print prompt
            out.print("Guess this word: ");
            if (Main.DEBUG_HANGMAN) {
                out.print(hangmanWord + " | "); // Debug
            }
            for (int x = 0; x < hangmanWord.length(); x++) { // Print the random word
                out.print((correctGuessArr[x]) ? hangmanWord.charAt(x) : "*"); // Print the guessing
            }
            out.print((i == 9) ? ("\n>>>   Guess  " + (i + 1) + ": ") : ("\n>>>   Guess   " + (i + 1) + ": "));
            // #endregion Print prompt

            // Check input range
            do {
                if (!Input.validCheck(1)) { // If the input is not in range of regEx
                    Display.errorMessage(1); // Display invalid input message
                    i--; // Decrease the chance count
                    continue hmLoop1; // Loop back to ask for another input
                } else { // If input is in range of regEx
                    break; // Break the loop for asking user input
                }
            } while (true);

            // Check input value for repeating letter
            for (int x = 0; x < hangmanWord.length(); x++) { // For each letter
                if (correctGuessArr[x]) { // If the letter is guessed
                    if (Input.getUserInput().charAt(0) == hangmanWord.charAt(x)) { // If the current guess matches with
                                                                                   // the
                        // guessed letter
                        Display.errorMessage(11); // Display the letter guessed message
                        i--; // Decrease the chance count
                        continue hmLoop1; // Loop back to ask for guess
                    }
                }
            }

            // Check input value for matching letter
            for (int x = 0; x < hangmanWord.length(); x++) { // For each letter
                if (Input.getUserInput().charAt(0) == hangmanWord.charAt(x)) { // If the user input matches with one of
                                                                               // the
                    // random word letter
                    correctGuessArr[x] = true; // Set the correct guess array to true for the letter
                    correctGuess = true; // Set the correct guess status to true
                }
            }

            // Check completeness
            for (int x = 0; x < hangmanWord.length(); x++) {
                if (!correctGuessArr[x]) { // If any false in the array detected
                    break; // Continue the game
                } else if ((x == hangmanWord.length() - 1) && (correctGuessArr[x])) { // Else if the last guess is true
                    resultArr[0] = 1;
                    return; // End the exit the method with true
                }
            }
            if (correctGuess) { // Check if user input is a coorect guess
                correctGuess = false; // Correct guess reset status
            } else {
                resultArr[0]++; // Wrong guess increase counter
            }
        }
        resultArr[0] = 0;
        return; // Any other case, exit the method with false
    }

    public void execScissorRockPaper() {
        // Reset Variables
        resultArr[30] = 0; // Computer Win Counter
        resultArr[31] = 0; // Player Win Counter
        resultArr[32] = 0; // Tie Counter

        Display.scissorRockPaper(); // Show the game UI and Rules
        continuePrompt(); // Prompt the user to start the game

        // Loop the game for 10 rounds
        srpLoop1: for (int i = 0; i < 10; i++) {
            // Computer
            resultArr[i] = rand.nextInt(3); // Store random computer choice

            // Print player prompt
            out.print((i == 9) ? ">>>   Round " + (i + 1) + ": " : ">>>   Round  " + (i + 1) + ": ");
            // Check player's input
            do {
                if (!Input.validCheck(2)) { // If input is not in range of regEx
                    Display.errorMessage(2); // Invalid Input Message
                    i--; // Decrease chance counter
                    continue srpLoop1; // Loop back to ask for another input
                } else { // If input is in range of regEx
                    break; // Break the loop
                }
            } while (true);

            if (Main.DEBUG_SCISSOR_ROCK_PAPER) {
                for (int x = 0; i < 9; i++) { // Debug show player and computer's option
                    out.println("Computer: " + resultArr[x] + " Player: " + resultArr[x + 10]);
                }
            }
            resultArr[i + 10] = Integer.parseInt(Input.getUserInput()); // Store the player choice to array

            srpCheckAlgorithm(i);

            resultArr[30 + (resultArr[i + 20])]++; // Set Counter for each outcome
        }
        return;
    }

    public void execTicTacToe() {
        int dummyA; // For temporary random integer for computer
        int[] tttArr = new int[10]; // Game Array stores available slot

        Display.ticTacToe();
        continuePrompt();

        tttPrintResult(tttArr); // Print the game Interface
        tttLoop1: do {
            // #region Player
            out.print("\n>>> Enter an available number: ");
            // Check input type range
            do {
                if (!Input.validCheck(3)) { // Invalid Input
                    Display.errorMessage(3); // Invalid Input Message
                    continue tttLoop1;
                } else {
                    out.println("\n"); // Print new line
                    break;
                }
            } while (true);

            // Check input value range
            if (tttArr[Integer.parseInt(Input.getUserInput())] == 0) {
                tttArr[Integer.parseInt(Input.getUserInput())] = 2; // Set slot taken by player (2)
                out.println(">>>   Player's Move");
                tttPrintResult(tttArr); // Print the current game UI
                // Check Winner
                if (tttCheckAlgorithm(tttArr) != 0) { // Check if player won with the move
                    resultArr[0] = 2;
                    return; // Return the winner id
                }
            } else {
                Display.errorMessage(31); // Display not available message
                continue tttLoop1;
            }

            // Check game complete
            for (int i = 0; i < tttArr.length; i++) {
                if (tttArr[i] == 0) {
                    break; // Continue the game if there is a number still available
                } else if ((i == tttArr.length - 1) && (tttArr[i + 1] != 0)) {
                    resultArr[0] = 0;
                    return; // Return tie
                }
            }
            // #endregion Player
            wait(1000);
            // #region Computer

            do {
                dummyA = (rand.nextInt(9) + 1);
                if (tttArr[dummyA] != 0) { // If the number is taken, loop again to get new nubmer
                    continue;
                } else {
                    tttArr[dummyA] = 1; // Mark the number as computer's choice
                    out.println(">>>   Computer's Move");
                    tttPrintResult(tttArr); // Print the current game UI
                    // Check winner
                    if (tttCheckAlgorithm(tttArr) != 0) { // Check if computer won with the move
                        resultArr[0] = 1;
                        return; // Return winner id
                    }
                    break;
                }
            } while (true);
            // #endregion Computer

        } while (true);

    }

}