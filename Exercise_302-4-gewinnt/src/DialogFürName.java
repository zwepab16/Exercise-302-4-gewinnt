
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class DialogFürName extends JDialog {

    private Boolean ok = false;
    private String[] names = new String[2];
    private int [] größe =new int[2];

    public Boolean getOk() {
        return ok;
    }

    public int[] getGröße() {
        return größe;
    }

    public String[] getNames() {
        return names;
    }

    public DialogFürName(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("4-Gewinnt");

        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(5, 2));
        this.add(new JLabel("  Name(Player 1):"));
        JTextField name1 = new JTextField("Player1");

        this.add(name1);
        this.add(new JLabel("  Name(Player 2): "));
        JTextField name2 = new JTextField("Player2");
        this.add(name2);
        this.add(new JLabel("  Spalten: "));
        JSlider spalten = new JSlider();
		spalten.setMinimum(5);
		spalten.setMaximum(25);
		spalten.setMajorTickSpacing(5);
		spalten.setMinorTickSpacing(1);
		spalten.createStandardLabels(1);
		spalten.setPaintTicks(true);
		spalten.setPaintLabels(true);
		spalten.setValue(6);
        spalten.setBackground(Color.pink);
      
        this.add(spalten);
        this.add(new JLabel("  Zeilen:"));
        JSlider zeilen = new JSlider();
		zeilen.setMinimum(5);
		zeilen.setMaximum(25);
		zeilen.setMajorTickSpacing(5);
		zeilen.setMinorTickSpacing(1);
		zeilen.createStandardLabels(1);
		zeilen.setPaintTicks(true);
		zeilen.setPaintLabels(true);
		zeilen.setValue(6);
        zeilen.setBackground(Color.yellow);
      
		this.add(zeilen);
        JButton bOK = new JButton("Start");
        bOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                names[0] = name1.getText();
                names[1] = name2.getText();
                größe[0]=spalten.getValue();
                größe[1]=zeilen.getValue();
                ok = true;

                dispose();
            }
        });
        JButton bCancle = new JButton("Close");
        bCancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ok = false;
                dispose();
            }
        });
        this.add(bOK);
        this.add(bCancle);
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
