
public class VierBL {

    private Value[][] field=new Value[7][6]; 
    private Value player;
    private int[] spalteZeile = new int[2];
    private int spielzug;
     private int hauptSpalten=12,hauptZeilen=11; 

    public VierBL(int sp,int ze) {
        hauptSpalten=sp;
        hauptZeilen=ze;
        field= new Value[hauptSpalten][hauptZeilen];//Spalten|Zeilen
        reset();
    }

    public void reset() {
    
        for (int spalten = 0; spalten < hauptSpalten; spalten++) {
            for (int zeilen = 0; zeilen < hauptZeilen; zeilen++) {
                field[spalten][zeilen] = Value.EMPTY;

            }
        }
        player = Value.PLAYER1;
    }

    public Value makeMove(int spalte) throws Exception {
       
        if (field[spalte][0] != Value.EMPTY) {
            throw new Exception("Nicht möglich!");

        }
        for (int i = hauptZeilen-1; i >= 0; i--) {
            if (field[spalte][i] == Value.EMPTY) {
                field[spalte][i] = player;
//                System.out.println("Spalte:" + spalte + " Zeile:" + i + " Spieler:" + player);
                break;
            }
        }

        if (player == Value.PLAYER1) {
            player = Value.PLAYER2;
        } else {
            player = Value.PLAYER1;
        }
        spielzug++;
        return testWinner();

    }

    public Value getVAlueAt(int spalte) {
        for (int i = hauptZeilen-1; i >= 0; i--) {
            if (i > 0) {
                if (field[spalte][i - 1] == Value.EMPTY) {

                    spalteZeile[0] = spalte;
                    spalteZeile[1] = i;
                    return field[spalte][i];

                }
            } else {
                spalteZeile[0] = spalte;
                spalteZeile[1] = 0;
                return field[spalte][0];
            }
        }

        return Value.EMPTY;

    }

    public Value testWinner() {
        //-----------Horizontal----------------
        for (int i = 0; i < hauptSpalten; i++) {

            for (int j = 0; j < hauptZeilen-3; j++) {
                if (field[i][j] == Value.PLAYER1
                        && field[i][j + 1] == Value.PLAYER1
                        && field[i][j + 2] == Value.PLAYER1
                        && field[i][j + 3] == Value.PLAYER1) {
                    return Value.PLAYER1;
                }
            }
            for (int j = 0; j < hauptZeilen-3; j++) {
                if (field[i][j] == Value.PLAYER2
                        && field[i][j + 1] == Value.PLAYER2
                        && field[i][j + 2] == Value.PLAYER2
                        && field[i][j + 3] == Value.PLAYER2) {
                    return Value.PLAYER2;
                }
            }

        }
        //------------------------Vertikal----------------------
        for (int i = 0; i < hauptSpalten-3; i++) {

            for (int j = 0; j < hauptZeilen; j++) {

                if (field[i][j] == Value.PLAYER1
                        && field[i + 1][j] == Value.PLAYER1
                        && field[i + 2][j] == Value.PLAYER1
                        && field[i + 3][j] == Value.PLAYER1) {
                    return Value.PLAYER1;
                }
            }
            for (int j = 0; j < hauptZeilen; j++) {

                if (field[i][j] == Value.PLAYER2
                        && field[i + 1][j] == Value.PLAYER2
                        && field[i + 2][j] == Value.PLAYER2
                        && field[i + 3][j] == Value.PLAYER2) {
                    return Value.PLAYER2;
                }
            }
        }

        //-----------------------diagonal------------------------
        for (int i = 0; i < hauptSpalten-3; i++) {

            for (int j = 0; j < hauptZeilen-3; j++) {

                if (field[i][j] == Value.PLAYER1
                        && field[i + 1][j + 1] == Value.PLAYER1
                        && field[i + 2][j + 2] == Value.PLAYER1
                        && field[i + 3][j + 3] == Value.PLAYER1) {
                    return Value.PLAYER1;
                }
            }
            for (int j = 0; j < hauptZeilen-3; j++) {

                if (field[i][j] == Value.PLAYER2
                        && field[i + 1][j + 1] == Value.PLAYER2
                        && field[i + 2][j + 2] == Value.PLAYER2
                        && field[i + 3][j + 3] == Value.PLAYER2) {
                    return Value.PLAYER2;
                }
            }
        }
        //---------------------------------------------------------
        for (int i = 0; i < hauptSpalten-3; i++) {
            for (int y = 3; y < hauptZeilen; y++) {
                if (field[i][y] == Value.PLAYER1
                        && field[i + 1][y - 1] == Value.PLAYER1
                        && field[i + 2][y - 2] == Value.PLAYER1
                        && field[i + 3][y - 3] == Value.PLAYER1) {
                    return Value.PLAYER1;
                }
            }
        }
        for (int i = 0; i < hauptSpalten-3; i++) {
            for (int y = 3; y < hauptZeilen; y++) {
                if (field[i][y] == Value.PLAYER2
                        && field[i + 1][y - 1] == Value.PLAYER2
                        && field[i + 2][y - 2] == Value.PLAYER2
                        && field[i + 3][y - 3] == Value.PLAYER2) {
                    return Value.PLAYER2;
                }
            }
        }

        //  System.out.println("Spielzug: "+spielzug);
        if (spielzug == hauptSpalten*hauptZeilen) {
            return Value.DRAW;
        }

        return Value.EMPTY;
    }

    public int[] getSpalteZeile() {
        return spalteZeile;
    }
}
