
public class VierBL {

    private Value[][] field = new Value[7][6];//Spalten|Zeilen
    private Value player;
    private int[]spalteZeile=new int[2];

    public VierBL() {
    reset();
    }
    public void reset() {
        
        for(int spalten=0; spalten<7;spalten++){
            for(int zeilen=0; zeilen<6; zeilen++){
               field[spalten][zeilen]=Value.EMPTY;
                       
            }
        }
        player = Value.PLAYER1;
    }
    public Value makeMove(int spalte) throws Exception{
        
        if (field[spalte][0] != Value.EMPTY) {
            throw new Exception("Nicht möglich!");

        }
        for(int i=5;i>=0;i--){
            if(field[spalte][i]==Value.EMPTY){
                field[spalte][i]=player;
                System.out.println("Spalte:"+spalte+" Zeile:"+i+" Spieler:"+player);
                break;
            }
        }
        

      if(player==Value.PLAYER1){
      player=Value.PLAYER2;
     }else player=Value.PLAYER1;

      return testWinner();
        
        
        
      
    }
    
    public Value getVAlueAt(int spalte) {
         for(int i=5;i>=0;i--){
             if(i>0){
            if(field[spalte][i-1]==Value.EMPTY){
                
                spalteZeile[0]=spalte;
         spalteZeile[1]=i;
             return field[spalte][i];
             
            }
             }
            else{
                 spalteZeile[0]=spalte;
         spalteZeile[1]=0;
                return field[spalte][0];
            }
         }
         
          return Value.EMPTY;
         
    }
    public Value testWinner(){
        for (int i = 0; i < 7; i++) {
           
            for (int j = 0; j < 3; j++) {
			if(	field[i][j] == Value.PLAYER1 &&
				field[i][j+1] == Value.PLAYER1 &&
				field[i][j+2] == Value.PLAYER1 &&
				field[i][j+3] == Value.PLAYER1)
			{
				return Value.PLAYER1;
			}
        }
             for (int j = 0; j < 3; j++) {
			if(	field[i][j] == Value.PLAYER2 &&
				field[i][j+1] == Value.PLAYER2 &&
				field[i][j+2] == Value.PLAYER2 &&
				field[i][j+3] == Value.PLAYER2)
			{
				return Value.PLAYER2;
			}
        }
       
    }
         return Value.EMPTY;
    }
    public int[] getSpalteZeile() {
        return spalteZeile;
    }
}
