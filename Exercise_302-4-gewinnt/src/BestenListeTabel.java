
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class BestenListeTabel extends AbstractTableModel {
private String []names ={"Name","Spiele Gesamt","Wins in %","Loses in %"};
    public BestenListeTabel() {
     laden();
//         bestenListe.add(new Spieler("SuperGamer", 100, 0, 100));
//         save();
         
    }
    private ArrayList<Spieler> bestenListe = new ArrayList();

    @Override
    public int getRowCount() {
        return bestenListe.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return bestenListe.get(i);
    }
@Override
    public String getColumnName(int i){
        return names[i];
    }

    public void add(Spieler s) {
        int h=0;
        for (Spieler spieler : bestenListe) {
            if (spieler.getName().equals(s.getName())) {
                h++;
                spieler.setAnzGames(spieler.getAnzGames() + s.getAnzGames());
                spieler.setAnzWins(spieler.getAnzWins() + s.getAnzWins());
                spieler.setAnzLos(spieler.getAnzLos() + s.getAnzLos());
        
            }
            
        }
        if(h==0) bestenListe.add(s);
        fireTableDataChanged();
        save();
    }

    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream("daten.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bestenListe);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            System.out.println("Fehler speichern" + ex.getMessage());
        }

    }

    public void laden() {
        try {
            bestenListe.removeAll(bestenListe);
            FileInputStream fis = new FileInputStream("daten.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            bestenListe = (ArrayList<Spieler>) ois.readObject();
            fis.close();
            fireTableDataChanged();
        } catch (Exception ex) {
            System.out.println("Fehler laden" + ex.getMessage());
        }

    }

}
