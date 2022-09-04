
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.String;
import static java.lang.Math.*;

public class Game{
    String player1;
    String player2;
    String press;
    int x;
    int z;
    int place1;
    int place2;
    
    int[] snakePosition = new int[8];
    int[] ladderPosition = new int[7];
    int[] snakeDecrease = new int[8];
    int[] ladderIncrease = new int[7];
    
    public Game(){
        snakePosition[0] = 17;
        snakeDecrease[0] = 10;
        
        snakePosition[1] = 54;
        snakeDecrease[1] = 20;
        
        snakePosition[2] = 62;
        snakeDecrease[2] = 44;
        
        snakePosition[3] = 64;
        snakeDecrease[3] = 4;
        
        snakePosition[4] = 87;
        snakeDecrease[4] = 63;
        
        snakePosition[5] = 93;
        snakeDecrease[5] = 20;
        
        snakePosition[6] = 95;
        snakeDecrease[6] = 20;
        
        snakePosition[7] = 99;
        snakeDecrease[7] = 21;
        
        ladderPosition[0] = 4;
        ladderIncrease[0] = 14;
        
        ladderPosition[1] = 9;
        ladderIncrease[1] = 22;
        
        ladderPosition[2] = 20;
        ladderIncrease[2] = 18;
        
        ladderPosition[3] = 28;
        ladderIncrease[3] = 56;
        
        ladderPosition[4] = 40;
        ladderIncrease[4] = 19;
        
        ladderPosition[5] = 63;
        ladderIncrease[5] = 18;
        
        ladderPosition[6] = 71;
        ladderIncrease[6] = 20;
                
    }
    
    public void initialize(){
        player1 = JOptionPane.showInputDialog("Player 1, enter name:");
        player2 = JOptionPane.showInputDialog("Player 2, enter name:");
        JOptionPane.showMessageDialog(null,"Hello " + player1 + " and "+ player2);
        
        startPlayer1();
        
    }
    public void startPlayer1(){
        
        if (place1 <= 100){
            press = JOptionPane.showInputDialog("Player 1, please press 'x' to roll dice");
            
            if (press.equals("x")){
                x = (int)(6*random()+1);
                place1 += x;
                JOptionPane.showMessageDialog(null,"You rolled a " + x);
                JOptionPane.showMessageDialog(null,"Your current position is " + place1);
                for (int i=0;i<8;i++){
                    if (snakePosition[i] == place1){
                        place1 -= snakeDecrease[i];
                        JOptionPane.showMessageDialog(null,"You landed on a snake :(");
                        JOptionPane.showMessageDialog(null,"Your current position is " + place1);
                    }
                }                              
                
                if (x==6){
                         JOptionPane.showMessageDialog(null,"You rolled a 6! You get another turn");   
                         startPlayer1();
                        }
                else{
                        startPlayer2();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"You pressed the wrong key! Please press enter to try again");
                    startPlayer1();
                }
            
        }
        JOptionPane.showMessageDialog(null,"CONGRATULATION!!!! " + player2 + " YOU WON!");
    }
    public void startPlayer2(){
        if (place2 <= 100){
            press = JOptionPane.showInputDialog("Player 2, please press 'z' to roll dice");
        
            if (press.equals("z")){
                int z = (int)(6*random()+1);
                this.place2 += z;
                JOptionPane.showMessageDialog(null,"You rolled a " + z);
                JOptionPane.showMessageDialog(null,"Your current position is " + this.place2); 
                for (int w=0;w<7;w++){
                    if (ladderIncrease[w] == place2){
                        place2 += ladderIncrease[w];
                        JOptionPane.showMessageDialog(null,"You landed on a ladder :)");
                        JOptionPane.showMessageDialog(null,"Your current position is " + place2);
                    }
                }
                if (z==6){
                    JOptionPane.showMessageDialog(null,"You rolled a 6! You get another turn");    
                    startPlayer2();
                }
                else{
                    startPlayer1();
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"You pressed the wrong key! Please press enter to try again");
                startPlayer2();
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"CONGRATULATION!!!! " + player2 + " YOU WON!");
        }
    }
    
}
