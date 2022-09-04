import java.util.Scanner;

public class runAPP {
    
    static appEngine app = new appEngine(); //create instance of class appEngine
    static Scanner reader = new Scanner(System.in);
    static byte yes = 0;
    static byte no = 0;
    
    public static void main(String[] args){
        app.initialiseData(); //initialise pre-recorded records
        char option;
        logo();
        do{
            System.out.println("\n*** mySAY System ***");
            System.out.println("* 1. Log In        *");
            System.out.println("* 2. Sign Up       *");
            System.out.println("* 3. Exit          *");
            System.out.println("********************");
            System.out.print(">> Option: ");
            option = reader.next().charAt(0);
            switch (option){
                case '1': logSystem(); break;
                case '2': registerAcc(); break;
                case '3': exit(); break;
                default: System.out.println("!! INVALID OPTION !!\n");
            }
        } while (option != '3');  
    }
    
    public static void logo(){
        //title generated from http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20
        System.out.println("                                 _____                             "); 
        System.out.println("                                /  ___|                            ");
        System.out.println("                 _ __ ___  _   _\\ `--.  __ _ _   _                 ");
        System.out.println("                | '_ ` _ \\| | | |`--. \\/ _` | | | |                ");
        System.out.println("                | | | | | | |_| /\\__/ | (_| | |_| |                ");
        System.out.println("                |_| |_| |_|\\__, \\____/ \\__,_|\\__, |                ");
        System.out.println("                            __/ |             __/ |                ");
        System.out.println("                           |___/             |___/                 ");
        System.out.println(" _   _       _   _               _____           _                 ");
        System.out.println("| | | |     | | (_)             /  ___|         | |                ");
        System.out.println("| | | | ___ | |_ _ _ __   __ _  \\ `--. _   _ ___| |_ ___ _ __ ___  ");
        System.out.println("| | | |/ _ \\| __| | '_ \\ / _` |  `--. | | | / __| __/ _ | '_ ` _ \\ ");
        System.out.println("\\ \\_/ | (_) | |_| | | | | (_| | /\\__/ | |_| \\__ | ||  __| | | | | |");
        System.out.println(" \\___\\/ \\___/ \\__|_|_| |_|\\__, | \\____/ \\__, |___/\\__\\___|_| |_| |_|");
        System.out.println("                          __/ |         __/ |                      ");
        System.out.println("                         |___/         |___/                       ");
    }
    
    public static void logSystem(){
        String idNum = "";
        String password = "";
        
        System.out.print("> ID: ");
        idNum = reader.next();
        do {
            System.out.print(">> Password: ");
            password = reader.next();
        } while (password.length() != 4);
        int recordIndex = app.checkUser(idNum, password); //check for user account
        if (recordIndex >= 0) mainMenu(recordIndex); //enter main menu if id and password are correct
    }
    
    public static void mainMenu(int pointer){
        char option2;
        do{
            System.out.println("\n****** MAIN MENU ******");
            System.out.println("* 1. VOTE             *");
            System.out.println("* 2. See Results      *");
            System.out.println("* 3. Sign out         *");
            System.out.println("***********************");
            System.out.print(">> Option: ");
            option2 = reader.next().charAt(0);
            switch (option2){
                case '1': {
                    if (!app.votes[pointer]) userVote(pointer); //if user's vote is false enter voting method
                    else System.out.println(">> YOU HAVE ALREADY VOTED <<");
                } break;
                case '2': 
                        {
                            if (yes+no > 0) seeResult(); //if there are some votes
                            else System.out.println(">> NO VOTES SO FAR <<");
                        } break;
                case '3': break; //do nothing 
                default: System.out.println("!! INVALID OPTION !!\n");
            }
        } while (option2 != '3');
    }    
        
    public static void userVote(int userIndex){
        char userVote;
        do{
            System.out.println("\n***** VOTING QUESTION *****");
            System.out.println("Do you agree with the proposal to convert St Mark square to a parking lot? [Y]es or [N]o?");
            System.out.print(" > YOUR VOTE: ");
            userVote = reader.next().charAt(0);
            userVote = Character.toUpperCase(userVote); //change response to uppercase
            if (userVote == 'Y') {
                yes++;
                app.votes[userIndex] = true;
            } else if (userVote == 'N'){
                no++;
                app.votes[userIndex] = true;
            }
            else System.out.println("!! INVALID RESPONSE !!");
        } while (userVote != 'Y' && userVote != 'N');
        System.out.println("Vote submitted successfully");
    }
    
    public static void seeResult(){
        System.out.println("\n**** VOTING RESULTS ****");
        System.out.println("  YES: " + yes);
        System.out.println("  NO: " + no);
        System.out.println("************************");
    }
    
    public static void registerAcc(){
        int pass = 0;
        System.out.println("***** SIGN UP ACCOUNT *****");
        System.out.print("> ID: ");
        String userId = reader.next();
        int checkAccount = app.checkUser(userId, "n/a");
        if (checkAccount > 0) System.out.println("Your Password is " + checkAccount);
    }
    
    public static void exit(){
        System.out.println("\n**************************");
        System.out.println("* Vote System Terminated *");
        System.out.println("*        made by         *");
        System.out.println("*      JOSMAR BORG       *");
        System.out.println("**************************");
    }
    
}
