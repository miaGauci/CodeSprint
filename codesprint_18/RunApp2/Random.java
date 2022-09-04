
import java.util.Scanner;
import javax.swing.JOptionPane;
import static java.lang.Math.*;
import java.lang.String;
import java.lang.Character;

public class Random{
    int points;
    String choice;
    int i;
    
    
    
    Scanner input = new Scanner(System.in);
      
    
      final static int PIN = 6502;
     
    Question[] questionList = new Question[3];
    
    public Random(){
        for(i=0;i<3;i++){
            questionList[i] = new Question();            
        }
        questionList[0].quest="Which element is used as fuel in a nuclear power stations?\n";
        questionList[0].option="A.water\nB.Gas\nC.Uranium";
        questionList[0].ans="c";
        
        questionList[1].quest="Which country uses the most nuclear power?\n";
        questionList[1].option="A.The United States\nB.Russia\nC.France";
        questionList[1].ans="a";
        
        questionList[2].quest="Which country opened the first nuclear power plant in 1954?\n";
        questionList[2].option="A.North Korea\nB.The Soviet Union\nC.Japan";
        questionList[2].ans="b";
    
    }
    
    public void addition(){
         
        int num1 = (int)(10*random()+1);
        int num2 = (int)(10*random()+1);
        int numTotal = num1 + num2;
        
        choice = JOptionPane.showInputDialog("What is the total value of these 2 numbers: \n" + num1 + "and " + num2);
        
        int choices = Integer.parseInt(choice);
        if (choices == numTotal){
            points +=1;
            question();
        }
        
        
    }
    public void question(){
        int random = (int)(3*random()+1);
        i = random;
        choice = JOptionPane.showInputDialog(
        questionList[i].quest +
        questionList[i].option );
        
                
        if (choice.equals (questionList[i].ans)){
            points +=1;
            enterPin();
        }
    }
    public void enterPin(){
        choice = JOptionPane.showInputDialog("Enter pin:");
        
        int choices = Integer.parseInt(choice);
         if (choices == PIN){
            points +=1;
            
        }
        if (points == 3){
            JOptionPane.showMessageDialog(null,"Access granted");
        }
        else{
            JOptionPane.showMessageDialog(null,"Access denied");
        }
    }

}
