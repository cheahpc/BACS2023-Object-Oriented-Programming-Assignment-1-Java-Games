
import java.util.InputMismatchException;
import java.util.Scanner;


public class Scissor_Rock_Paper {
    
    public static Scanner scan = new Scanner(System.in);
    
    public static void srp_Execute(){
        
        final String[] game_choice = {"Scissor    |   ", "Rock       |   ", "Paper      |   "};
        final String[] result_type = {"Tie       |", "Win       |", "Lose      |"};
        
        int[] user_choice = new int[10];
        int[] random_num = new int[10];
        int winCount = 0;
        int loseCount = 0;
        int tieCount = 0;
        String[] user_result_type = new String[10];
        String[] ramdom_result_type = new String[10];
        String[] result_store = new String[10];
        boolean exception_error = false;
        
        Display.scissorRockPaper();
        if (S_R_P_Output.msg_prompt()) {
            Display.mainMenu(); // Print main menu interface
            return;
        }
        S_R_P_Random.randomNum(user_choice, random_num);
        
        for(int i = 0; i < user_choice.length; i++){
            do{
                exception_error = false;
                try{
                    System.out.print("Choose a number between 0 to 2: ");
                    user_choice[i] = scan.nextInt();
                    while(user_choice[i] != 0 && user_choice[i] != 1 && user_choice[i] != 2){
                        System.out.print("Just can choose a number between 0 to 2: ");
                        user_choice[i] = scan.nextInt();
                    }
                }catch(InputMismatchException e){
                    System.out.println("Please enter a valid number!!!");
                    exception_error = true;
                    scan.nextLine();
                }
            }while(exception_error);
            
            switch (user_choice[i]) {
                case 0:
                    switch(random_num[i]){
                        case 0:
                            tieCount = tieCount + 1;
                            user_result_type[i] = game_choice[0];
                            ramdom_result_type[i] = game_choice[0];
                            result_store[i] = result_type[0];
                            System.out.println("======================");
                            System.out.println("| " + (i + 1) + " round: " + result_store[i]);
                            System.out.println("======================");
                            break;
                        case 1:
                            loseCount = loseCount + 1;
                            user_result_type[i] = game_choice[0];
                            ramdom_result_type[i] = game_choice[1];
                            result_store[i] = result_type[2];
                            System.out.println("======================");
                            System.out.println("| " + (i + 1) + " round: " + result_store[i]);
                            System.out.println("======================");
                            break;
                        case 2:
                            winCount = winCount + 1;
                            user_result_type[i] = game_choice[0];
                            ramdom_result_type[i] = game_choice[2];
                            result_store[i] = result_type[1];
                            System.out.println("======================");
                            System.out.println("| " + (i + 1) + " round: " + result_store[i]);
                            System.out.println("======================");
                            break;
                        default:
                            System.out.println("Error");
                    }   break;
                case 1:
                    switch(random_num[i]){
                        case 0:
                            winCount = winCount + 1;
                            user_result_type[i] = game_choice[1];
                            ramdom_result_type[i] = game_choice[0];
                            result_store[i] = result_type[1];
                            System.out.println("======================");
                            System.out.println("| " + (i + 1) + " round: " + result_store[i]);
                            System.out.println("======================");
                            break;
                        case 1:
                            tieCount = tieCount + 1;
                            user_result_type[i] = game_choice[1];
                            ramdom_result_type[i] = game_choice[1];
                            result_store[i] = result_type[0];
                            System.out.println("======================");
                            System.out.println("| " + (i + 1) + " round: " + result_store[i]);
                            System.out.println("======================");
                            break;
                        case 2:
                            loseCount = loseCount + 1;
                            user_result_type[i] = game_choice[1];
                            ramdom_result_type[i] = game_choice[2];
                            result_store[i] = result_type[2];
                            System.out.println("======================");
                            System.out.println("| " + (i + 1) + " round: " + result_store[i]);
                            System.out.println("======================");
                            break;
                        default:
                            System.out.println("Error");
                    }   break;
                case 2:
                    switch(random_num[i]){
                        case 0:
                            loseCount = loseCount + 1;
                            user_result_type[i] = game_choice[2];
                            ramdom_result_type[i] = game_choice[0];
                            result_store[i] = result_type[2];
                            System.out.println("======================");
                            System.out.println("| " + (i + 1) + " round: " + result_store[i]);
                            System.out.println("======================");
                            break;
                        case 1:
                            winCount = winCount + 1;
                            user_result_type[i] = game_choice[2];
                            ramdom_result_type[i] = game_choice[1];
                            result_store[i] = result_type[1];
                            System.out.println("======================");
                            System.out.println("| " + (i + 1) + " round: " + result_store[i]);
                            System.out.println("======================");
                            break;
                        case 2:
                            tieCount = tieCount + 1;
                            user_result_type[i] = game_choice[2];
                            ramdom_result_type[i] = game_choice[2];
                            result_store[i] = result_type[0];
                            System.out.println("======================");
                            System.out.println("| " + (i + 1) + " round: " + result_store[i]);
                            System.out.println("======================");
                            break;
                        default:
                            System.out.println("Error");
                        }break;
                default:
                    System.out.println("Error");
            }
        

        }
        
        S_R_P_Output.result_output(user_result_type, ramdom_result_type, result_store);
        S_R_P_Output.count_result(winCount, loseCount, tieCount);
        S_R_P_Output.ask_loop();
    }
    
}
