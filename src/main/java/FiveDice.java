import java.util.Scanner;

public class FiveDice {

    private static void continuePrompt(int continueType) {
        
        Scanner scan = new Scanner(System.in);

        switch (continueType) {
            case 1:
                // display prompt the user enter to start the game
                System.out.println("Press {ENTER} key to \"START\" the game!"); // Print prompt message
                try {
                    scan.nextLine(); // Read input enter
                } catch (Exception ex) {
                    System.out.println("ERROR! Unable to process input."); // Unexpected exception message
                }
                break;

            case 2:
                // display prompt the user enter to continue the game
                System.out.println("Press {ENTER} key to \"CONTINUE\" the game!"); // Print prompt message
                try {
                    scan.nextLine();// Read input enter
                } catch (Exception ex) {
                    System.out.println("ERROR! Unable to process input."); // Unexpected exception message
                }
                break;

            case 3:
                // display prompt the user enter to view the game result
                System.out.println("Press {ENTER} key to \"VIEW\" the game result!"); // Print prompt message
                try {
                    scan.nextLine();// Read input enter
                } catch (Exception ex) {
                    System.out.println("ERROR! Unable to process input."); // Unexpected exception message
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
        int[] computer = new int[SIZE * ROUND]; // store computer dice number of each dice in each round
        int[] player = new int[SIZE * ROUND]; // store player dice number of each dice in each round
        char[] result = new char[ROUND]; // store result of each round
        int[] diceCountPC = new int[DICE]; // store player dice number from 1-6 in each face of dice number means has 6 faces
        int[] diceCountPlayer = new int[DICE]; // store computer dice number from 1-6 in each face of dice number means has 6 faces
        int[] countPC = new int[ROUND]; // store computer count of dice the kind value in each round
        int[] countPlayer = new int[ROUND]; // store player count of dice the kind value in each round

        // data properties
        int indexPC = 0, indexPlayer = 0; // as index that in computer and player array to store dice number

        // display interface output
        FDice_Output.fiveDice();

        // display first type of continue prompt the use enter to start the game
        continuePrompt(1);

        // display each round
        for (int i = 0; i < ROUND; i++) {

            System.out.println("Round " + (i + 1) + ": ");

            // display player dice
            System.out.print("Player   : ");
            // SIZE = 5, dice 5 times random number
            for (int j = 0; j < SIZE; j++) {
                FDice_Random.displayPlayerdice(player, indexPlayer, DICE, diceCountPlayer);
                indexPlayer++; // increase the index of player array value
            }
            System.out.println();

            // display computer dice
            System.out.print("Computer : ");
            // SIZE = 5, dice 5 times random number
            for (int j = 0; j < SIZE; j++) {
                FDice_Random.displayPCdice(computer, indexPC, DICE, diceCountPC);
                indexPC++; // increase the index of computer array value
            }
            System.out.println("\n");

            // find the winner
            FDice_Cmp.findWinner(diceCountPC, countPC, i, diceCountPlayer, countPlayer, result);

            // display the type of continue prompt the user to enter
            if (i < (ROUND - 1)) { // after loop finish 10 times will display the else section
                continuePrompt(2); // display second type of continue prompt to continue the process
            } else
                continuePrompt(3); // display third type of continue prompt to view the game result
        }

        // display result
        FDice_Output.result(ROUND, SIZE, player, computer, countPC, countPlayer, result);
        System.out.println();
    }
}
