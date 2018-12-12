
import java.io.Serializable;



public class Spieler implements Serializable{
private String name;
private int anzWins, anzLos,anzGames;

    public Spieler(String name, int anzWins, int anzLos, int anzGames) {
        this.name = name;
        this.anzWins = anzWins;
        this.anzLos = anzLos;
        this.anzGames = anzGames;
    }

    public String getName() {
        return name;
    }

    public int getAnzWins() {
        return anzWins;
    }

    public int getAnzLos() {
        return anzLos;
    }

    public int getAnzGames() {
        return anzGames;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnzWins(int anzWins) {
        this.anzWins = anzWins;
    }

    public void setAnzLos(int anzLos) {
        this.anzLos = anzLos;
    }

    public void setAnzGames(int anzGames) {
        this.anzGames = anzGames;
    }

   
}
