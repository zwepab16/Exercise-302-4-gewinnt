
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;

public class BestenListeGUI extends JDialog {

    private String[] names = {"Name", "Spiele Gesamt", "Wins in %", "Loses in %"};
    private BestenListeTabel model = new BestenListeTabel();

    public BestenListeGUI() {

        this.setTitle("Bestenliste");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JTable t = new JTable();
        t.setModel(model);
        t.setDefaultRenderer(Object.class, new BestenListeTabelRenderer());
        this.add(new JScrollPane(t));
        
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogFürName d = new DialogFürName(new javax.swing.JFrame(), true);
                d.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                d.setVisible(true);
            }
        });

    }

}
