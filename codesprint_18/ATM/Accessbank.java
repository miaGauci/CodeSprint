import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.String;
public class Accessbank{
    int counter;
    String choices;
    
    Scanner input = new Scanner(System.in);
    
    static final int PIN = 9681;
     
    public void enterPin(){
        choices = JOptionPane.showInputDialog("ENTER 4-NUMBERED PIN");
        int choice = Integer.parseInt(choices);
        if (choice <= 999){
            JOptionPane.showMessageDialog(null,"INVALID PIN FORMAT");
            enterPin();
        }
        if (choice == PIN){
           JOptionPane.showMessageDialog(null,"CORRECT PIN"); 
        }
        else{
            counter += 1;
            JOptionPane.showMessageDialog(null,"INCORRECT PIN. PLEASE TRY AGAIN. "); 
            tryAgain();
            
        }
    }
    public void tryAgain(){
        if (counter>=3){
           JOptionPane.showMessageDialog(null,"BANK CARD HELD");
        }
        else{
            enterPin();
        }
    }
}