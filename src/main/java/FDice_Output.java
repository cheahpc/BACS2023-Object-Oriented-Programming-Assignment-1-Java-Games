
public class FDice_Output {
 
    public static void result(int ROUND, int SIZE, int [] player, int [] computer, int [] countPC, int [] countPlayer, char [] result){
        //initialize
        int x = 0;
        int y = 0;
        
        //display the result
        System.out.println("--------------------------------------------------------------");
        System.out.println("| Round |    Player     |    Computer   |   Beats   | Result |");
        System.out.println("--------------------------------------------------------------");
        
        //display each round
        for (int i = 0; i < ROUND; i++) { // ROUND = 10
            System.out.printf("| %4d  | ", (i+1));
            
            //if statement due to display properly
            for (int j = 0; j < SIZE; j++) {
                if (j < 4){
                 System.out.print(player[y] + ", ");
                } else{
                    System.out.print(player[y] + " | ");
                }
                y++; //increase the y value
            }
            
            //if statement due to display properly
            for (int j = 0; j < SIZE; j++) {
                if (j < 4){
                    System.out.print(computer[x] + ", ");
                }
                else{
                    System.out.print(computer[x] + " ");
                }
                x++; //increase the X value
            }
            
            //display the result
            System.out.printf("| %d beats %d |  ", countPlayer[i], countPC[i]);
            if(result[i] == 'W') {
                System.out.printf("WIN   |\n");
            }
            else if(result[i] == 'L') {
                System.out.printf("LOSE  |\n");
            }
            else if(result[i] == 'T') {
                System.out.printf("TIE   |\n");
            }
            
        }
        System.out.println("--------------------------------------------------------------");  
    }
}
