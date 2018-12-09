
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
         for(int i=5;i>0;i--){
            if(field[spalte][i+1]==Value.EMPTY){
                spalteZeile[0]=spalte;
         spalteZeile[1]=i;
             return field[spalte][i];
            }
         }
         
          return Value.EMPTY;
         
    }
    public Value testWinner(){
        for (int i = 0; i < 7; i++) {
            int zeilensum = 0;
            for (int j = 0; j < 6; j++) {
                zeilensum += field[i][j].getNum();
            }
            if (zeilensum == 4) {
                return Value.PLAYER1;

            }
            if (zeilensum == -4) {
                return Value.PLAYER2;

            }
        }
        return Value.EMPTY;
    }

    public int[] getSpalteZeile() {
        return spalteZeile;
    }
}
