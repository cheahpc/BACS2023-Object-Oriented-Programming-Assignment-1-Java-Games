
public class FDice_Cmp {
    // find the winner
    public static void findWinner(int [] diceCountPC, int [] countPC, int round, int [] diceCountPlayer, int [] countPlayer, char [] result) {
        //find the coputer dice largest count of kind
        for(int k=0; k<diceCountPC.length; k++){
            if(diceCountPC[k] > countPC[round]){
                countPC[round] = diceCountPC[k]; 
            }
            diceCountPC[k] = 0;
        }
            
        //find the player dice largest count of kind 
        for(int k=0; k<diceCountPlayer.length; k++){
            if(diceCountPlayer[k] > countPlayer[round]){
                countPlayer[round] = diceCountPlayer[k];   
            } 
            diceCountPlayer[k] = 0;
        }
           
        //find the winner
        if(countPlayer[round] > countPC[round]) {
            result[round] = 'W';
        }else if(countPlayer[round] < countPC[round]) {
            result[round] = 'L';
        }else {
            result[round] = 'T';
        }    
    }
}
