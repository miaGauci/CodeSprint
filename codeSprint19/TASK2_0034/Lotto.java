
import javax.swing.JOptionPane;
import java.lang.String;
import static java.lang.Math.*;

public class Lotto{
    //declaring variables
    int num1;
    int num2;
    int num3;
    int num4;
    int num5;
    int i;
    double prize;
    //int max = 45;
    int numGuessed;
    
    //declaring array for lotto numbers
      int[] lottoNum = new int[5];
    //public Lotto(){
        
    //}
    public void lottoTicket(){
            
            //generating number for lotto ticket
            for (i=0;i<5;i++){
                lottoNum[0] = (int)(Math.random()*45)+1;                
                //JOptionPane.showMessageDialog(null,lottoNum[0]);
                
                while (lottoNum[1] == lottoNum[0])
                {
                     lottoNum[1] = (int)(random()*45)+1;
                    //lottoNum[1] = (int)(45*random());
                     
                     //JOptionPane.showMessageDialog(null,lottoNum[2]);
                }
                while ((lottoNum[2] == lottoNum[0]) || (lottoNum[2] == lottoNum[1]) )
                {
                     lottoNum[2] = (int)(Math.random()*45)+1;
                     
                     //JOptionPane.showMessageDialog(null,lottoNum[3]);
                }
                while ((lottoNum[3] == lottoNum[0]) || (lottoNum[3] == lottoNum[1]) || (lottoNum[3] == lottoNum[2]) )
                {
                     lottoNum[3] = (int)(45*random());
                     
                     //JOptionPane.showMessageDialog(null,lottoNum[4]);
                }
                while ((lottoNum[4] == lottoNum[0]) ||
                       (lottoNum[4] == lottoNum[1]) ||
                       (lottoNum[4] == lottoNum[2]) ||
                       (lottoNum[4] == lottoNum[3]) )
                {
                     lottoNum[4] = (int)(Math.random()*45)+1;
                     //OptionPane.showMessageDialog(null,lottoNum[4]);
                     
                }
                
            }
        
    }
    //creating a method for lotto ticket
    public void purchaseTicket(){
        //creating numbers for user ticket
        num1 = (int)(45*random()+1);
        num2 = (int)(45*random()+1);
        num3 = (int)(45*random()+1);
        num4 = (int)(45*random()+1);
        num5 = (int)(45*random()+1);
                     
        //JOptionPane.showMessageDialog(null,"The winning ticket is: \n"  + lottoNum[0] +" "+" "+ lottoNum[1] +" " + lottoNum[2] +" " + lottoNum[3] +" " + lottoNum[4]);
        JOptionPane.showMessageDialog(null,"Your ticket numbers are: \n"  + num1 +" "+" "+ num2 +" " + num3 +" " + num4 +" " + num5);
        //if any of the numbers match with the lotto numbers than count ~+ 1
        //if (lottoNum[i] == num1){        }
        if((lottoNum[0] == num1) ||
           (lottoNum[1] == num1) ||
           (lottoNum[2] == num1) ||
           (lottoNum[3] == num1) ||
           (lottoNum[4] == num1) ){
            numGuessed+=1;
        }
        if((lottoNum[0] == num2) ||
           (lottoNum[1] == num2) ||
           (lottoNum[2] == num2) ||
           (lottoNum[3] == num2) ||
           (lottoNum[4] == num2) ){
            numGuessed+=1;
        }
        if((lottoNum[0] == num3) ||
           (lottoNum[1] == num3) ||
           (lottoNum[2] == num3) ||
           (lottoNum[3] == num3) ||
           (lottoNum[4] == num3) ){
            numGuessed+=1;
        }
        if((lottoNum[0] == num4) ||
           (lottoNum[1] == num4) ||
           (lottoNum[2] == num4) ||
           (lottoNum[3] == num4) ||
           (lottoNum[4] == num4) ){
            numGuessed+=1;
        }
        if((lottoNum[0] == num5) ||
           (lottoNum[1] == num5) ||
           (lottoNum[2] == num5) ||
           (lottoNum[3] == num5) ||
           (lottoNum[4] == num5) ){
            numGuessed+=1;
        }
        
        JOptionPane.showMessageDialog(null,"numbers guessed = " + numGuessed);
        //according to the numbers guessed a message is displayed      
        
        switch(numGuessed){
            case 1:{
             JOptionPane.showMessageDialog(null,"The winning ticket is: \n"  + lottoNum[0] +" "+" "+ lottoNum[1] +" " + lottoNum[2] +" " + lottoNum[3] +" " + lottoNum[4]);
             JOptionPane.showMessageDialog(null,"Your ticket numbers are: \n"  + num1 +" "+" "+ num2 +" " + num3 +" " + num4 +" " + num5);
             JOptionPane.showMessageDialog(null,"You did not win");
             break;
            }
            case 2:{
                JOptionPane.showMessageDialog(null,"The winning ticket is: \n"  + lottoNum[0] +" "+" "+ lottoNum[1] +" " + lottoNum[2] +" " + lottoNum[3] +" " + lottoNum[4]);
                JOptionPane.showMessageDialog(null,"Your ticket numbers are: \n"  + num1 +" "+" "+ num2 +" " + num3 +" " + num4 +" " + num5);
             JOptionPane.showMessageDialog(null,"You did not win");
             break;
            }
            case 3:{
             this.prize = 10/100 * 500000;
             JOptionPane.showMessageDialog(null,"The winning ticket is: \n"  + lottoNum[0] +" "+" "+ lottoNum[1] +" " + lottoNum[2] +" " + lottoNum[3] +" " + lottoNum[4]);
             JOptionPane.showMessageDialog(null,"Your ticket numbers are: \n"  + num1 +" "+" "+ num2 +" " + num3 +" " + num4 +" " + num5);
                JOptionPane.showMessageDialog(null,"You won with 3 numbers hence you won £" + prize);
             break;
            }
            case 4:{
             this.prize = 25/100 * 500000;
             JOptionPane.showMessageDialog(null,"The winning ticket is: \n"  + lottoNum[0] +" "+" "+ lottoNum[1] +" " + lottoNum[2] +" " + lottoNum[3] +" " + lottoNum[4]);
             JOptionPane.showMessageDialog(null,"Your ticket numbers are: \n"  + num1 +" "+" "+ num2 +" " + num3 +" " + num4 +" " + num5);
                JOptionPane.showMessageDialog(null,"You won with 4 numbers hance you won £" + prize);
             break;
            }
            case 5:{
                this.prize = 500000;
                JOptionPane.showMessageDialog(null,"The winning ticket is: \n"  + lottoNum[0] +" "+" "+ lottoNum[1] +" " + lottoNum[2] +" " + lottoNum[3] +" " + lottoNum[4]);
                JOptionPane.showMessageDialog(null,"Your ticket numbers are: \n"  + num1 +" "+" "+ num2 +" " + num3 +" " + num4 +" " + num5);
             JOptionPane.showMessageDialog(null,"You won with 5 numbers hence you won £" + prize);
             break;
            }
            default:{
                JOptionPane.showMessageDialog(null,"The winning ticket is: \n"  + lottoNum[0] +" "+" "+ lottoNum[1] +" " + lottoNum[2] +" " + lottoNum[3] +" " + lottoNum[4]);
                JOptionPane.showMessageDialog(null,"no numbers guessed");
            }
        }
        //JOptionPane.showMessageDialog(null,"The winning ticket is: \n"  + lottoNum[0] +" "+" "+ lottoNum[1] +" " + lottoNum[2] +" " + lottoNum[3] +" " + lottoNum[4]);
        
        
    }
}