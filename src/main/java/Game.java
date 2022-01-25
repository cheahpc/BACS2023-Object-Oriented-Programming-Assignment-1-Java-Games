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

    public void Hangman() {

        return;
    }

    public void ScissorRockPaper(int[] userResultVar) {
        // Reset Variables
        gameCounter = 10;
        userResultVar[30] = 0; // Computer Win Counter
        userResultVar[31] = 0; // Player Win Counter
        userResultVar[32] = 0; // Tie Counter
        Input in = new Input();
        Display show = new Display();

        String temp = ""; // For temporary read user input and checking
        int temp2; // For storing user input

        show.ScissorRockPaper(); // Print the header
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
            // out.println("Comuter: " + userResultVar[x] + " Player: " + userResultVar[x +
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

    public void TicTacToe() {

        return;
    }

    public void FlipAndMatch() {

        return;
    }

    public void FiveDice() {

        return;
    }
}
