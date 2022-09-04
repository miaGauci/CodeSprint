
import java.util.Scanner;
import javax.swing.JOptionPane;
 public class Login{
     int i;
     String choice;
     
     Scanner input = new Scanner(System.in);
     User[] userList = new User[5];
     public Login(){
        for (i=0;i<5;i++){
            userList[i] = new User();
            
        } 
        userList[0].username = "matik_10\n";
        userList[0].password = "Matik.hello\n";
        
        userList[1].username = "gta_guru\n";
        userList[1].password = "gta!98\n";
        
        userList[2].username = "borgsteve\n";
        userList[2].password = "app_in?\n";
        
        userList[3].username = "alan_1979\n";
        userList[3].password = "mt\"ALAN\"\n";
        
        userList[4].username = "dieselmt\n";
        userList[4].password = "rock!N?Roll\n";
     }
     public void enterUsername(){
         choice = JOptionPane.showInputDialog("Enter Username");
         choice = choice.toUpperCase();
         for (i=0;i<5;i++){
        if (choice.equals(userList[i].username)){
            choice = JOptionPane.showInputDialog("Enter Password");
            if(choice.equals(userList[i].password)){
                    JOptionPane.showMessageDialog(null,"Logged-in Successfully");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Password");
               }
        }
        else{
            
        }
    }
     }
     public void enterPassword(){
         choice = JOptionPane.showInputDialog("Enter Password");
         
          if (choice.equals(userList[i].password)){
              JOptionPane.showMessageDialog(null,"Logged-in Successfully");
         }
         else{
              JOptionPane.showMessageDialog(null,"Incorrect Password");
         }
     }
     public void huh(){
        switch(choice){
            case "MATIK_10":{
                choice = JOptionPane.showInputDialog("Enter Password");
                if(choice.equals("Matik.hello")){
                    JOptionPane.showMessageDialog(null,"Logged-in Successfully");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Password");
               }
            }
            
            }
      }
 }
