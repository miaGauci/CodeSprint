

import java.lang.String;
import javax.swing.JOptionPane;
import static java.lang.Math.*;

public class SafeBox{
    //declaring variables
    int userPin;
    int input;
    String userInput;
    
    // method to reset safe box pin
    public void resetSafeBox(){
        
        JOptionPane.showMessageDialog(null,"Welcome to the Hotel Room Safe Box!");
        //Create a 6-digit pin
        int resetPin = (int)(1000000*random());
        //read the user input as a string
        this.userInput = JOptionPane.showInputDialog("To reset the safe box please enter this 6-digit pin: " + resetPin);
        //convert userInput into an integer
        this.input = Integer.parseInt(userInput);
        //checks whether pin is equal to input
        if (resetPin == input){
            user();
        }
        else{
            JOptionPane.showMessageDialog(null,"Wrong pin entered. Please try again.");
            resetSafeBox();
        }       
        
    }
    
    public void user(){
        //lets the user enter a 4-digit pin
        this.userInput = JOptionPane.showInputDialog("Please enter a 4-digit pin: ");
        //convert user input into an integer
        this.userPin = Integer.parseInt(userInput);
        //checks whether user input is a 4-digit pin
        if (userPin > 9999 || userPin < 1000){
            JOptionPane.showMessageDialog(null,"Wrong pin entered. Please try again.");
            user();
        }
        else{
            //display a message to confirm new pin
            JOptionPane.showMessageDialog(null,"Your new pin is " + this.userPin);
            openClose();
        }
        
    }
    
    public void openClose(){
        //lets the user enter c or x
        this.userInput = JOptionPane.showInputDialog("To close the safe Box please press 'c' and to exit the program press'x' ");
        switch(this.userInput){
            //case1, if c is entered the safe is closed
            case "c":{
                JOptionPane.showMessageDialog(null,"Safe closed.");
                //lets the user and 'o' to open and 'x' to exit
                this.userInput = JOptionPane.showInputDialog("To open please press 'o' and to exit press 'x' ");
                // if user input is 'o' then the user() method is called to let the user re-open the safe
                if(this.userInput.equals("o")){
                    user();
                }
                else{
                    exitApplication();
                }
                break;
            }
            case "x":{
                exitApplication();
                break;
            }
            default:{
                // if another key is pressed this message is shown
                JOptionPane.showMessageDialog(null,"Invalid choice");
                openClose();
            }
        }
    }
    //To exit the application
    public void exitApplication(){
        JOptionPane.showMessageDialog(null,"Hope you enjoyed the application!");
     }
}