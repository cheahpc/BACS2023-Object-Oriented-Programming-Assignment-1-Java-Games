
public class FDice_Cmp {

    // find the winner
    public static void findWinner(int[] diceCountPC, int[] countPC, int round, int[] diceCountPlayer, int[] countPlayer,
            char[] result) {

        // find the player dice largest count of kind
        for (int k = 0; k < diceCountPlayer.length; k++) { // diceCountPC is store the face of dice number means has 6
                                                           // faces
            if (diceCountPlayer[k] > countPlayer[round]) { // compare each face of dice number which count the largest value
                countPlayer[round] = diceCountPlayer[k]; // then assign the largest value inside the countPlayer
            }
            diceCountPlayer[k] = 0; // each face of dice count will be reset to 0
        }

        // find the computer dice largest count of kind
        for (int k = 0; k < diceCountPC.length; k++) { // diceCountPC is store the face of dice number means has 6 faces
            if (diceCountPC[k] > countPC[round]) { // compare each face of dice number which count the largest value
                countPC[round] = diceCountPC[k]; // then assign the largest value inside the countPC
            }
            diceCountPC[k] = 0; // each face of dice count will be reset to 0
        }

        // find the winner
        if (countPlayer[round] > countPC[round]) { // if player dice of kind greater than computer
            result[round] = 'W'; // then assign 'W' means is player win
        } else if (countPlayer[round] < countPC[round]) { // else if player dice of kind lower than computer
            result[round] = 'L'; // then assign 'L' means is player lose
        } else { // else player dice of kind equal to computer dice of kind
            result[round] = 'T'; // then assign 'T' means tie
        }
    }
}
