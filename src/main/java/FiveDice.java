import java.util.Scanner;

public class FiveDice {

    public static void continuePrompt(int continueType) {
        Scanner scan = new Scanner(System.in);
        switch (continueType) {
            case 1:
                // display prompt the user enter to continue
                System.out.println("Press {Enter} key to start the game!"); // Print prompt message
                try {
                    scan.nextLine();// Read input enter
                } catch (Exception e) {
                    System.out.println("Error! Unable to process input."); // Unexpected exception message
                }
                break;

            case 2:
                // display prompt the user enter to continue
                System.out.println("Press {Enter} key to continue the game!"); // Print prompt message
                try {
                    scan.nextLine();// Read input enter
                } catch (Exception e) {
                    System.out.println("Error! Unable to process input."); // Unexpected exception message
                }
                break;
        }

    }

    public static void execute() {
        // define constant data properties
        final int SIZE = 5; // dice 5 times random number
        final int DICE = 6; // 6 faces of dice
        final int ROUND = 10; // 10 round each game

        // array
        int[] computer = new int[SIZE * ROUND]; // computer dice number of each dice in each round
        int[] player = new int[SIZE * ROUND]; // player dice number of each dice in each round
        char[] result = new char[ROUND]; // store result of each round
        int[] diceCountPC = new int[DICE]; // store 1-6 dice count same value
        int[] diceCountPlayer = new int[DICE]; // store 1-6 dice count same value
        int[] countPlayer = new int[ROUND]; // store count of same value in each dice
        int[] countPC = new int[ROUND]; // store count of same value in each dice

        // data properties
        int x = 0, y = 0; // as index that store random number in computer and player array

        // display interface output
        Display.fiveDice();
        continuePrompt(1);

        // display each round
        for (int i = 0; i < ROUND; i++) {

            System.out.println("Round " + (i + 1) + ": ");

            // display player dice
            System.out.print("Player   : ");
            // SIZE = 5, dice random 5 number
            for (int j = 0; j < SIZE; j++) {
                FDice_Player.displayPlayerdice(player, y, DICE, diceCountPlayer);
                y++; // increase the y value
            }
            System.out.println();

            // display computer dice
            System.out.print("Computer : ");
            // SIZE = 5, dice random 5 number
            for (int j = 0; j < SIZE; j++) {
                FDice_PC.displayPCdice(computer, x, DICE, diceCountPC);
                x++; // increase the x value
            }
            System.out.println("\n");

            // find the winner
            FDice_Cmp.findWinner(diceCountPC, countPC, i, diceCountPlayer, countPlayer, result);
            continuePrompt(2);
        }

        // display result
        FDice_Output.result(ROUND, SIZE, player, computer, countPC, countPlayer, result);
        System.out.println();
    }
}
