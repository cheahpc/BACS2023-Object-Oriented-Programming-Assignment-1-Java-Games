
import java.util.Random;


public class S_R_P_Random{
    
    public static void randomNum(int[] user_choice, int[] random_num){
        Random rand = new Random();
    
        int range = 2 - 0 + 1;
        
    
        for(int i = 0; i < user_choice.length; i++){
            random_num[i] = rand.nextInt(range) + 0;
        }
    }
}
