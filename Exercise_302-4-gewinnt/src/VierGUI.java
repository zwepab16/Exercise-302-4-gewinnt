
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class VierGUI extends JFrame {

    private JLabel[][] labels = new JLabel[7][6];
    VierBL bl = new VierBL();

     
    public VierGUI() {
        for (int spalten = 6; spalten >= 0; spalten--) {
            for (int zeile = 5; zeile >= 0; zeile--) {
                JLabel l = new JLabel();
                l.setBorder(new LineBorder(Color.black, 1));
                l.setName(spalten + "" + zeile);
                l.setOpaque(true);
                labels[spalten][zeile] = l;
            }

        }

        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new LineBorder(Color.white, 1));
        buttonPanel.setLayout(new GridLayout(1, 7));
        for (int i = 0; i < 7; i++) {
            JButton b = new JButton();
            b.setText("V");
            b.setName("" + i);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    move(ae);
                }
            });
            buttonPanel.add(b);
        }

        this.add(buttonPanel, BorderLayout.NORTH);
       erstelleSpielfeld();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void erstelleSpielfeld(){
         JPanel playground = new JPanel();
        playground.setLayout(new GridLayout(6, 7));
        playground.setBackground(Color.LIGHT_GRAY);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {

                playground.add(labels[i][j]);
            }

        }
        this.add(playground);
    }

    public void move(ActionEvent event) {
        JButton b = (JButton) event.getSource();
        try {
            JLabel l = new JLabel();
            int platz = Integer.parseInt(b.getName());
           
            System.out.println(b.getName() + "Platz");

            Value winner = bl.makeMove(platz);
            System.out.println(winner);
            
            Value val = bl.getVAlueAt(platz);
            switch (val) {
                case PLAYER1:
                    labels[bl.getSpalteZeile()[0]][bl.getSpalteZeile()[1]].setBackground(Color.red);System.out.println(val);
                    System.out.println(bl.getSpalteZeile()[0]+"nji"+bl.getSpalteZeile()[1]+"");
                    break;
                case PLAYER2:
                    labels[bl.getSpalteZeile()[0]][bl.getSpalteZeile()[1]].setBackground(Color.blue);
                    break;
                    case DRAW:
                        System.out.println("Draw");break;

            }
         
         
            repaint();
            if (winner != Value.EMPTY) {
                JOptionPane.showMessageDialog(this, "The Winner is " + winner);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args) {
        new VierGUI().setVisible(true);

    }

}
