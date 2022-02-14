
import java.util.Random;

public class FDice_Player {

    public static void displayPlayerdice(int[] player, int y, int DICE, int[] diceCountPlayer) {

        Random randNum = new Random();
        // y is array number to store the random number 1 - 6 accordingly
        player[y] = (int) (randNum.nextInt(6) + 1);
        System.out.printf(" %2d ", player[y]);

        // DICE = 6 due to find the value of dice from 1-6 which value is same
        for (int k = 1; k <= DICE; k++) { // e.g. k=1
            if (player[y] == k) { // e.g. computer[x]=1 equal to 1
                diceCountPlayer[k - 1] += 1; // e.g. is equal it will increase the number in diceCountPC array 0
                break; // which means diceCountPC array 0 is store dice 1 count,
            } // diceCountPC array 1 is store dice 2 count and continuously
        }
    }
}
