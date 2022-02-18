
import java.util.Random;

public class FDice_Random {

    public static void displayPlayerdice(int[] player, int indexPlayer, int DICE, int[] diceCountPlayer) {

        Random randNum = new Random();
        // indexPlayer is index number of int [] player
        player[indexPlayer] = (int) (randNum.nextInt(6) + 1);
        System.out.printf(" %2d ", player[indexPlayer]);

        // DICE = 6 due to find the value of dice from 1-6 which value is same
        for (int k = 1; k <= DICE; k++) { // e.g. k = 1 means the dice is 1
            if (player[indexPlayer] == k) { // e.g. player[indexPlayer]=1 equal to 1
                diceCountPlayer[k - 1] += 1; // e.g. if equal it will increase the number in diceCountPC array 0
                break; // which means diceCountPC array 0 is store dice 1 count,
            } // diceCountPC array 1 is store dice 2 count and continuously
        }
    }

    public static void displayPCdice(int[] computer, int indexPC, int DICE, int[] diceCountPC) {

        Random randNum = new Random();
        // indexPC is index number of int [] computer
        computer[indexPC] = (int) (randNum.nextInt(6) + 1);

        System.out.printf(" %2d ", computer[indexPC]);

        // DICE = 6 due to find the value of dice from 1-6 which value is same
        for (int k = 1; k <= DICE; k++) { // e.g. k=2
            if (computer[indexPC] == k) { // e.g. computer[indexPC]=2 equal to 2
                diceCountPC[k - 1] += 1; // e.g. if equal it will increase the number in diceCountPC array 1
                break; // which means diceCountPC array 1 is store dice of number 2,
            } // diceCountPC array 1 is store dice 2 count and continuously
        }
    }
}
