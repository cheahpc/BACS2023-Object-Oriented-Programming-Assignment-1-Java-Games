
import java.util.Scanner;

public class S_R_P_Output {
    
    public static Scanner scan = new Scanner(System.in);
    
    public static boolean msg_prompt(){
        System.out.print("Start game?(y/n): ");
        char ask_start = scan.next().charAt(0);
        
        while(ask_start != 'y' && ask_start != 'Y' && ask_start != 'n' && ask_start != 'N'){
            System.out.println("Invalid!!!");
            System.out.print("Start?(y/n): ");
            ask_start = scan.next().charAt(0);
        }
        
        if (ask_start == 'n' || ask_start == 'N') {
            return true;
        } else{
            return false;
        }
    }
    
    public static void result_output(String[] user_result_type, String[] ramdom_result_type, String[] result_store) {
        System.out.println("|=========================================|");
        System.out.println("|============= Final  Result =============|");
        System.out.println("|=========================================|");
        System.out.println("| User Input |   Random     |   Result    |");
        System.out.println("|=========================================|");
        
        for(int i = 0; i < 10; i++){
            System.out.println("| " + user_result_type[i] + ramdom_result_type[i] + result_store[i]);
        }
        System.out.println("|=========================================|");
    }
    
    public static void count_result(int winCount, int loseCount, int tieCount){
        System.out.println("|============ Result  Counter ============|");
        System.out.println("|=========================================|");
        System.out.println("|    Total win count: " + winCount + " time(s)           |");
        System.out.println("|    Total lose count: " + loseCount + " time(s)          |");
        System.out.println("|    Total tie count: " + tieCount + " time(s)           |");
        System.out.println("|=========================================|");
    }
    
    public static void ask_loop(){
        System.out.print("Do you want to play again?(y/n): ");
        char ask_continue = scan.next().charAt(0);
        
        while(ask_continue != 'y' && ask_continue != 'Y' && ask_continue != 'n' && ask_continue != 'N'){
            System.out.println("Invalid!!!");
            System.out.print("Start?(y/n): ");
            ask_continue = scan.next().charAt(0);
        }
        
        if(ask_continue == 'n' || ask_continue == 'N'){
            Display.mainMenu();
        } else{
            Scissor_Rock_Paper.srp_Execute();
        }
    }

    
}
