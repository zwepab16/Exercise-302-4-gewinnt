
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class VierGUI extends JFrame {

    public VierGUI() {
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new LineBorder(Color.white, 1));
        buttonPanel.setLayout(new GridLayout(1, 7));
        for (int i = 0; i < 7; i++) {
            JButton b = new JButton();
            b.setText("V");
            b.setName(""+i);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    move(ae);
                }
                });
            buttonPanel.add(b);
        }

        this.add(buttonPanel, BorderLayout.NORTH);
        JPanel playground = new JPanel();
        playground.setLayout(new GridLayout(6, 7));
        playground.setBackground(Color.LIGHT_GRAY);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                JLabel l = new JLabel();
                l.setBorder(new LineBorder(Color.black, 1));
                //   l.setBackground(Color.blue);
                l.setOpaque(true);
                playground.add(l);
            }

            this.add(playground);
        }
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new VierGUI().setVisible(true);

    }
    public void move(ActionEvent ae){
        JButton b=(JButton) ae.getSource();
        System.out.println(b.getName());
    }

}
