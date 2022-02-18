
public class FDice_Output {

    public static void fiveDice() {
        System.out.println("\n\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++           Welcome to the Five Dice Game!             ++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.println("++++++++++++++++++++++++   Rule   +++++++++++++++++++++++++++");
        System.out.println("+++   1. 5 of a kind beats 4 of a kind                    +++");
        System.out.println("+++   2. 4 of a kind beats 3 of a kind                    +++");
        System.out.println("+++   3. 3 of a kind beats 2 of a kind                    +++");
        System.out.println("+++   4. 2 of a kind beats normal cards                   +++");
        System.out.println("+++   5. If both player and computer don't have a combo,  +++");
        System.out.println("+++      it will be a tie                                 +++");
        System.out.println("+++   6. If both player and computer get same combo,      +++");
        System.out.println("+++      the one side with larger comboo value wins       +++");
        System.out.println("+++                                                       +++");
        System.out.println("+++   Interface Design                                    +++");
        System.out.println("+++   Player   :   O   O   O   O   O                      +++");
        System.out.println("+++   Computer :   X   X   X   X   X                      +++");
        System.out.println("+++                                                       +++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        return;
    }
    
    public static void result(int ROUND, int SIZE, int[] player, int[] computer, int[] countPC, int[] countPlayer, char[] result) {
        // data properties
        int indexPC = 0, indexPlayer = 0;
        int countWin = 0, countLose = 0, countTie = 0;

        // display the result
        System.out.println("                +---------------------------+                 ");
        System.out.println("                | The Five Dice Game Result |                 ");
        System.out.println("                +---------------------------+                 ");
        System.out.println("+-------+---------------+---------------+-----------+--------+");
        System.out.println("| Round |    Player     |    Computer   |   Beats   | Result |");
        System.out.println("+-------+---------------+---------------+-----------+--------+");
        
        // display each round
        for (int i = 0; i < ROUND; i++) { // ROUND = 10
            System.out.printf("|   %-2d  | ", (i + 1));

            // if statement due to display properly
            for (int j = 0; j < SIZE; j++) {
                if (j < 4) {
                    System.out.print(player[indexPlayer] + ", ");
                } else {
                    System.out.print(player[indexPlayer] + " | ");
                }
                indexPlayer++; // increase the index of player array value
            }

            // if statement due to display properly
            for (int j = 0; j < SIZE; j++) {
                if (j < 4) {
                    System.out.print(computer[indexPC] + ", ");
                } else {
                    System.out.print(computer[indexPC] + " ");
                }
                indexPC++; // increase the index of computer array value
            }

            // display the result
            System.out.printf("| %d beats %d |  ", countPlayer[i], countPC[i]);
            if (result[i] == 'W') {
                System.out.printf("WIN   |\n");
                countWin += 1;
            } else if (result[i] == 'L') {
                System.out.printf("LOSE  |\n");
                countLose += 1;
            } else if (result[i] == 'T') {
                System.out.printf("TIE   |\n");
                countTie += 1;
            }

        }
        System.out.println("+-------+---------------+---------------+-----------+--------+\n");
        
        System.out.printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.printf("+         Total Player WIN         =         %d Win           +\n", countWin);
        System.out.printf("+         Total Computer WIN       =         %d Win           +\n", countLose);
        System.out.printf("+         Total Game TIE           =         %d Tie           +\n", countTie);
        System.out.printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }
}
