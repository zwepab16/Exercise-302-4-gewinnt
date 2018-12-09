
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;



public class DialogFürName extends JDialog{
public DialogFürName(){
     this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(new JLabel("saasf"));
}
   
        
    public static void main(String[] args) {
        new DialogFürName().setVisible(true);
 
    }
}
