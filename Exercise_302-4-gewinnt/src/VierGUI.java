
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class VierGUI extends JFrame {

    private JLabel[][] labels = new JLabel[7][6];
    private VierBL bl; 
    private JLabel currentPlayer = new JLabel(Value.PLAYER1.getAction()+" beginnnt!", SwingConstants.CENTER);
    private int hauptSpalten=12,hauptZeilen=11;

    public VierGUI() {
        this.setTitle("4-Gewinnt.exe");
        DialogFürName d=new DialogFürName(new JFrame(),true);
        d.setVisible(true);
        if(d.getOk()){
            hauptSpalten=d.getGröße()[0];
            hauptZeilen=d.getGröße()[1];
            bl= new VierBL(hauptSpalten,hauptZeilen);
            Value.PLAYER1.setAction(d.getNames()[0]);
            Value.PLAYER2.setAction(d.getNames()[1]);
            currentPlayer=new JLabel(Value.PLAYER1.getAction()+" beginnnt!", SwingConstants.CENTER);
            }
        else{
           
                System.exit(0);
            
        }
        
        labels = new JLabel[hauptSpalten][hauptZeilen];
        setEnabled(false);
        
        setEnabled(true);
        befülle();
    }

    public void befülle() {
        int inter = 0;
        for (int zeile = 0; zeile < hauptZeilen; zeile++) {
            for (int spalten = 0; spalten < hauptSpalten; spalten++) {
                JLabel l = new JLabel();
                l.setBorder(new LineBorder(Color.black, 1));
                //l.setName(spalten + "" + zeile);
                //l.setText(spalten + ":::" + zeile + "Num:" + inter);
                l.setBackground(Color.WHITE);
                l.setOpaque(true);
                labels[spalten][zeile] = l;
                inter++;
            }

        }

        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel menü = new JPanel();
        menü.setBorder(new LineBorder(Color.black, 1));
        menü.setLayout(new GridLayout(3, 1));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new LineBorder(Color.white, 1));
        buttonPanel.setLayout(new GridLayout(1, hauptSpalten));
        for (int i = 0; i < hauptSpalten; i++) {
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

        JMenuBar menueBar = new JMenuBar();
        menueBar.setBorder(new LineBorder(Color.black, 2));
        JMenuItem newGame = new JMenuItem("neues Spiel");
        newGame.setBorder(new LineBorder(Color.black, 2));
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                neuStart();
            }
        });
       
        menueBar.add(newGame);
        JMenuItem end = new JMenuItem("Spiel beenden");
        end.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });
        end.setBorder(new LineBorder(Color.black, 2));
        menueBar.add(end);
        menü.add(menueBar);
        menü.add(currentPlayer);
        menü.add(buttonPanel);
        this.add(menü, BorderLayout.NORTH);

        JPanel playground = new JPanel();
        playground.setLayout(new GridLayout(hauptZeilen, hauptSpalten));
        playground.setBackground(Color.LIGHT_GRAY);
        for (int i = 0; i < hauptZeilen; i++) {
            for (int j = 0; j < hauptSpalten; j++) {

                playground.add(labels[j][i]);
            }

        }
        this.add(playground);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void move(ActionEvent event) {
        JButton b = (JButton) event.getSource();
        try {
            JLabel l = new JLabel();
            int platz = Integer.parseInt(b.getName());

//            System.out.println(b.getName() + "Platz");

            Value winner = bl.makeMove(platz);
//            System.out.println(winner);

            Value val = bl.getVAlueAt(platz);
            switch (val) {
                case PLAYER1:
                    labels[bl.getSpalteZeile()[0]][bl.getSpalteZeile()[1]].setBackground(Color.red);
//                    System.out.println("Spieler:" + val);
//                    System.out.println("Spalte:" + bl.getSpalteZeile()[0] + "Zeile:" + bl.getSpalteZeile()[1] + "");
                    currentPlayer.setText(Value.PLAYER2.getAction() + " ist jetzt dran!");

                    break;
                case PLAYER2:
                    labels[bl.getSpalteZeile()[0]][bl.getSpalteZeile()[1]].setBackground(Color.blue);
//                    System.out.println("Spieler:" + val);
//                    System.out.println("Spalte:" + bl.getSpalteZeile()[0] + "Zeile:" + bl.getSpalteZeile()[1] + "");
                    currentPlayer.setText(Value.PLAYER1.getAction() + " ist jetzt dran!");

                    break;
                case DRAW:
//                    System.out.println("Draw");
                    break;

            }

            if (winner != Value.EMPTY) {
               if(winner!= Value.DRAW) JOptionPane.showMessageDialog(this, "Der Gewinner ist:  " + winner.getAction());
               else JOptionPane.showMessageDialog(this, ""+winner.getAction());
                neuStart();

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        }
//        System.out.println("---------------Zug ende-------------------");
    }

    public void neuStart() {
        bl.reset();

        this.dispose();
        new VierGUI().setVisible(true);
    }

    

    public static void main(String[] args) {
        new VierGUI().setVisible(true);

    }

}
