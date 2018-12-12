
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;



public class BestenListeTabelRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
          JLabel l = new JLabel();
        Spieler s = (Spieler) o;
         Double d=0.0;
        switch (i1) {
            case 0:
                l.setText(s.getName());
                break;
            case 1:
                l.setText(s.getAnzGames()+"");
                break;
            case 2:
               d =(double)s.getAnzWins()/ s.getAnzGames()*100;
              
                l.setText(String.format("%.2f %s",d,"%"));
                break;
            case 3:
               d =(double)s.getAnzLos()/ s.getAnzGames()*100;
               
                l.setText(String.format("%.2f %s",d,"%"));
                break;
        }
       

        l.setOpaque(true);
        return l;
    }

}
