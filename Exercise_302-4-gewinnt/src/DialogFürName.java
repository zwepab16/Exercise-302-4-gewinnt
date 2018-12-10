
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class DialogFürName extends JDialog{
    
    private Boolean ok=false;
    private String []names=new String[2];

    public Boolean getOk() {
        return ok;
    }

    public String[] getNames() {
        return names;
    }

   
    
    
public DialogFürName(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    
    
     this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(3, 2));
        this.add(new JLabel("Name(Player 1):"));
        JTextField name1=new JTextField();
       
        this.add(name1);
        this.add(new JLabel("Name(Player 2): "));
      JTextField name2=new JTextField();
        this.add(name2);
        JButton bOK=new JButton("OK");
       bOK.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
             names[0]=name1.getText();
             names[1]=name2.getText();
             ok=true;
        
        dispose();
         }
     });
         JButton bCancle=new JButton("Cancle");
          bCancle.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
             ok=false;
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
