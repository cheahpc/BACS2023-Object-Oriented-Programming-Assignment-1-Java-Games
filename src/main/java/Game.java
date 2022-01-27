import java.util.Random;

import static java.lang.System.out;

public class Game {

    private void continuePrompt() {
        System.out.println("Press {Enter} key to start the game!"); // Print prompt message
        try {
            Main.sc.nextLine(); // Read input
        } catch (Exception e) {
            System.out.println("Error! Unable to process input."); // Unexpected exception message
        }
    }

    private void wait(int ms) {
        try {
            Thread.sleep(ms); // Try to sleep for ms milliseconds
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();// Unexpected error occur
        }
    }

    private void tttPrintResult(int[] resultArr) {
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

    private int tttCheckAlgorithm(int[] resultArr) {
        // Check winner for each possible winning condition
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

    private static void famPrintResult(char[] cardArr, boolean[] resultArr) {
        int dummyA = 0; // Counter for Available numbers
        int dummyB = 0; // Counter for Current Game

        out.print(">>>        Available        |     Current Game\n");
        for (int x = 0; x < 5; x++) { // Print 5 rows of the game interface
            out.print(">>>   ");
            for (int i = 0; i < 19; i++) { // Print the available option
                if (((dummyA + 1) < 10) && ((i == 2) || (i == 7) || (i == 12) || (i == 17))) { // If the number is below
                                                                                               // 10
                    dummyA++;
                    if (!resultArr[dummyA]) { // If number not taken
                        out.print(dummyA); // Print the number
                    } else { // If number is taken
                        out.print(" "); // Print a space
                    }
                } else if (((dummyA + 1) >= 10) && ((i == 1) || (i == 6) || (i == 11) || (i == 16))) { // If the number
                                                                                                       // is above 10
                    dummyA++;
                    if (!resultArr[dummyA]) { // If nuber is not taken
                        i++; // Increase the counter as the number is printed is printed
                        out.print(dummyA); // Print the number
                    } else { // If number is taken
                        out.print(" "); // Print a space
                    }
                } else if ((i == 4) || (i == 9) || (i == 14)) { // Print the seperating line
                    out.print("|");
                } else { // Print empty space in between the number and the seperating line
                    out.print(" ");
                }
            }
            out.print("   |   "); // Print a line seperating the Available number and the Current game section
            for (int i = 0; i < 15; i++) { // Print the actual game
                if ((i == 1) || (i == 5) || (i == 9) || (i == 13)) {
                    dummyB++;
                    if (resultArr[dummyB]) { // If the card is taken
                        out.print(cardArr[dummyB - 1]); // Print the card character
                    } else { // If the card is not taken
                        out.print(" "); // Print a space
                    }
                } else if ((i == 3) || (i == 7) || (i == 11)) { // Print the seperating line
                    out.print("|");
                } else { // Print empty space in between the number and the seperating line
                    out.print(" ");
                }
            }
            if (x < 4) { // Print the seperating row for lines below 4
                out.println("\n>>>   ----|----|----|----   |   ---|---|---|---");
            } else {
                dummyA = 0; // Reset the counter
                dummyB = 0; // Reset the counter
                out.println(); // Print new line
            }
        }
        return;
    }

    public boolean hangman(int[] userResultVar) {
        // Predefined words with 10 letters
        final String[] words = { "secretary", "determine", "baby", "cow", "robot", "tank", "begin", "root", "ride",
                "meaning", "ignorant", "retire", "link", "grimace", "summer", "listen" };

        String word = words[(int) (Math.random() * words.length)]; // Set a random word from the list of words
        String dummy; // Temporary store the user's guess
        int wordLengh = word.length(); // Prepare a variagle storing the random word's length
        boolean[] correctGuessArr = new boolean[10]; // Array to keep track of the correct guess
        boolean correctGuess = false; // Boolean to check if the user guessed correctly
        userResultVar[0] = 0; // Reset the array

        Display.hangman(); // Print hangman UI and rules
        continuePrompt();
        hmLoop1: for (int i = 0; i < correctGuessArr.length; i++) {
            // #region Print prompt
            out.print("Guess this word: ");
            if (Main.DEBUG_HANGMAN) {
                out.print(word + " "); // Debug
            }
            for (int j = 0; j < wordLengh; j++) { // Print the random word
                if (correctGuessArr[j]) { // If the letter is guessed corretly
                    out.print(word.charAt(j)); // Show the letter of the word
                } else { // IF the letter is not guessed
                    out.print("*"); // Show the * sign
                }
            }
            out.print((i == 9) ? "\n>>>   Guess : " : "\n>>>   Guess  : ");
            // #endregion Print prompt

            // Check input range
            do {
                dummy = Input.read();
                if (!Input.validCheck(1, dummy)) { // If the input is not in range of regEx
                    Display.errorMessage(1); // Display invalid input message
                    i--; // Decrease the chance count
                    continue hmLoop1; // Loop back to ask for another input
                } else { // If input is in range of regEx
                    break; // Break the loop for asking user input
                }
            } while (true);

            // Check input value for repeating letter
            for (int x = 0; x < wordLengh; x++) { // For each letter
                if (correctGuessArr[x]) { // If the letter is guessed
                    if (dummy.charAt(0) == word.charAt(x)) { // If the current guess matches with the guessed letter
                        Display.errorMessage(11); // Display the letter guessed message
                        i--; // Decrease the chance count
                        continue hmLoop1; // Loop back to ask for guess
                    }
                }
            }

            // Check input value for matching letter
            for (int y = 0; y < wordLengh; y++) { // For each letter
                if (dummy.charAt(0) == word.charAt(y)) { // If the user input matches with one of the random word letter
                    correctGuessArr[y] = true; // Set the correct guess array to true for the letter
                    correctGuess = true; // Set the correct guess status to true
                }
            }

            // Check completeness
            for (int j = 0; j < wordLengh; j++) {
                if (!correctGuessArr[j]) { // If any false in the array detected
                    break; // Continue the game
                } else if ((j == wordLengh - 1) && (correctGuessArr[j])) { // Else if the last guess is true
                    return true; // End the exit the method with true
                }
            }
            if (correctGuess) { // Check if user input is a coorect guess
                correctGuess = false; // Correct guess reset status
            } else {
                userResultVar[0]++; // Wrong guess increase counter
            }
        }
        return false; // Any other case, exit the method with false
    }

    public void scissorRockPaper(int[] userResultVar) {
        // Reset Variables
        userResultVar[30] = 0; // Computer Win Counter
        userResultVar[31] = 0; // Player Win Counter
        userResultVar[32] = 0; // Tie Counter

        String temp; // For temporary read user input and checking

        Display.scissorRockPaper(); // Show the game UI and Rules
        continuePrompt(); // Prompt the user to start the game

        // Loop the game for 10 rounds
        srpLoop1: for (int i = 0; i < 10; i++) {
            // Computer
            Random rand = new Random(); // instance of random class
            userResultVar[i] = rand.nextInt(3); // Store random computer choice

            // Print player prompt
            out.print((i == 9) ? ">>>   Round " + (i + 1) + ": " : ">>>   Round  " + (i + 1) + ": ");
            // Check player's input
            do {
                temp = Input.read();
                if (!Input.validCheck(2, temp)) { // If input is not in range of regEx
                    Display.errorMessage(2); // Invalid Input Message
                    i--; // Decrease chance counter
                    continue srpLoop1; // Loop back to ask for another input
                } else { // If input is in range of regEx
                    break; // Break the loop
                }
            } while (true);

            if (Main.DEBUG_SCISSOR_ROCK_PAPER) {
                for (int x = 0; i < 9; i++) { // Debug show player and computer's option
                    out.println("Computer: " + userResultVar[x] + " Player: " + userResultVar[x + 10]);
                }
            }

            userResultVar[i + 10] = Integer.parseInt(temp); // Store the player choice to array

            // Check for each possible outcome and set the winner
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
        }
        return;
    }

    public int ticTacToe() {
        Random rand = new Random(); // instance of random class

        String dummyA; // For user input
        int dummyB; // For temporary random integer

        int[] resultArr = new int[10];

        Display.ticTacToe();
        continuePrompt();

        tttPrintResult(resultArr); // Print the game Interface
        tttLoop1: do {
            // #region Player
            out.print("\n>>> Enter an available number: ");
            // Check input type range
            do {
                dummyA = Input.read();
                if (!Input.validCheck(3, dummyA)) { // Invalid Input
                    Display.errorMessage(3); // Invalid Input Message
                    continue tttLoop1;
                } else {
                    out.println("\n"); // Print new line
                    break;
                }
            } while (true);

            // Check input value range
            if (resultArr[Integer.parseInt(dummyA)] == 0) {
                resultArr[Integer.parseInt(dummyA)] = 2;
                out.println(">>>   Player's Move");
                tttPrintResult(resultArr); // Print the current game UI
                // Check Winner
                if (tttCheckAlgorithm(resultArr) != 0) { // Check if player won with the move
                    return tttCheckAlgorithm(resultArr); // Return the winner id
                }
            } else {
                Display.errorMessage(31); // Display not available message
                continue tttLoop1;
            }

            // Check game complete
            for (int i = 0; i < resultArr.length; i++) {
                if (resultArr[i] == 0) {
                    break; // Continue the game if there is a number still available
                } else if ((i == resultArr.length - 1) && (resultArr[i + 1] != 0)) {
                    return 0; // Return tie
                }
            }
            // #endregion Player
            wait(1000);
            // #region Computer

            do {
                dummyB = rand.nextInt(9) + 1; // Generate a number for computer
                if (resultArr[dummyB] != 0) { // If the number is taken, loop again to get new nubmer
                    continue;
                } else {
                    resultArr[dummyB] = 1; // Mark the number as computer's choice
                    out.println(">>>   Computer's Move");
                    tttPrintResult(resultArr); // Print the current game UI
                    // Check winner
                    if (tttCheckAlgorithm(resultArr) != 0) { // Check if computer won with the move
                        return tttCheckAlgorithm(resultArr); // Return winner id
                    }
                    break;
                }
            } while (true);
            // #endregion Computer

        } while (true);

    }

    public void flipAndMatch() {
        char[] card = { 'a', 'a', 'b', 'b', 'c', 'c', 'd', 'd', 'e', 'e', 'f', 'f',
                'g', 'g', 'h', 'h', 'i', 'i', 'j', 'j' }; // Prepare array of options

        boolean[] resultArr = new boolean[21]; // Array to store card flipped status

        String dummyA; // For storing player input
        int previousCard = 0; // To store the previous selectrion of the player
        int gameCounter = 10; // Set the count for the game base on card pair
        int index; // temporary index variable use for shuffling card array

        Random rand = new Random();
        // Card shuffle algorithm
        for (int i = card.length - 1; i > 0; i--) {
            index = rand.nextInt(i + 1);
            if (index != i) {
                card[index] ^= card[i];
                card[i] ^= card[index];
                card[index] ^= card[i];
            }
        }

        Display.flipAndMatch(); // Show game UI and Rules
        continuePrompt();

        famPrintResult(card, resultArr);
        famLoop1: do {
            out.print("\n>>> Enter an available card number: ");
            // Check input type range
            do {
                dummyA = Input.read();
                if (!Input.validCheck(4, dummyA)) { // Invalid Input
                    Display.errorMessage(4); // Invalid Input Message
                    famPrintResult(card, resultArr); // Print hte result again fore going back to prompt player
                    continue famLoop1;
                } else {
                    out.println("\n"); // Print new line
                    break;
                }
            } while (true);

            // Check input value range
            if (!resultArr[Integer.parseInt(dummyA)]) { // If the card is not flipped yet
                resultArr[Integer.parseInt(dummyA)] = true; // Set the card to flipped
                famPrintResult(card, resultArr); // Print the current game UI
            } else {
                Display.errorMessage(41); // Print the message telling user the number is taken
                famPrintResult(card, resultArr); // Print hte result again fore going back to prompt player
                continue famLoop1;
            }

            // Check if matching pair
            if (previousCard == 0) { // 1st card
                previousCard = Integer.parseInt(dummyA); // Set previous card to current selection
            } else if (card[Integer.parseInt(dummyA) - 1] != card[previousCard - 1]) { // 2nd card: If not match with
                                                                                       // previous card
                resultArr[Integer.parseInt(dummyA)] = false;// Set current selection to false
                resultArr[previousCard] = false; // Set previous selection to false
                previousCard = 0; // Reset the prev selection
                out.println("\n>>>    Opps, you missed! Try again!\n");
                wait(2000);
                famPrintResult(card, resultArr);
            } else { // 2nd card: and match with the previous card
                previousCard = 0; // Reset previous card and current card
                gameCounter--;
                out.println("\n>>>    It's a match!\n");
                wait(1000);
                if (gameCounter == 0) {
                    return;
                }
            }

        } while (true);

    }

    public void fiveDice() {

        return;
    }
}
