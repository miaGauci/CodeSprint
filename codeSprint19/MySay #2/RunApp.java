class RunApp{

    //Main class starts here
    public static void main (String[] args){
        //load data of the residents' accounts
        User[] resident = Accounts.userData();
        
        //setting counters yes, no to 0
        int yes=0;
        int no=0;
        
        //rId, rPin temporary variables to hold userID and userPIN
        String rId="";
        String rPin="";
        
        boolean exitMenu1=false;
        
        do{
            Menu.logInMenu(); //call logInMenu method from class Menu
            int option = Keyboard.readInt();
            switch (option) {
                case 1: {
                    //Log In
                    System.out.println("-------------------------------------");
                    System.out.println("Enter the ID:");
                    rId=Keyboard.readString();
                    int userKey=0;
    
                    boolean found = false;
                    String rAccountPin="";
                    for (int i=0;i<resident.length;i++){
                        if (rId.equals(resident[i].getId())){
                            rAccountPin=resident[i].getPin();
    
                            userKey=i;
                            found = true;
                            i=resident.length;//to stop and exit loop
                        }
                    }
    
                    if (found){
                        System.out.println("Enter the PIN:");
                        rPin=Keyboard.readString();
                        if (rPin.equals(rAccountPin)){
                            System.out.println("Access granted. You can vote");
                            boolean exitMenu2=false;
                            do{
                                Menu.mainMenu();
                                int option2=Keyboard.readInt();
                                switch(option2){
                                    case 1: {
                                        if (resident[userKey].getVoted()) {
                                            System.out.println("This account holder already voted!");
                                            System.out.println("You can only Show Results (2) or Sign Out (3)");
                                        } else{
                                            boolean validVote=false;
        
                                            do{
                                                System.out.println("--------VOTE--------");
                                                System.out.println("Taqbel jew le xbin? (Y/N)");
                                                String yn=Keyboard.readString().toLowerCase();
                                                if (yn.equals("y")){
                                                    yes++;
                                                }
                                                if (yn.equals("n")){
                                                    no++;
                                                }
                                                validVote=( (yn.equals("y")) || (yn.equals("n"))  );
                                                if(!validVote) System.out.println("Enter y or n. Please try again");
                                            }while(!validVote);
                                            resident[userKey].setVoted(true);
                                        }
                                    } break;
                                    case 2: {
                                        System.out.println("-----------COUNTING HALL--------------");
                                        System.out.println("YES = " + yes);
                                        System.out.println("NO  = " + no);
                                    } break;
                                    case 3:{
                                        System.out.println("------------Signing Out-------------");
                                        exitMenu2=true;
                                    } break;
                                    default: System.out.println("Enter an integer from 1 to 3!");       
                                }
                            }while(!exitMenu2);
                        } else{
                            System.out.println("Access denied. You cannot vote unless with a valid account!");
                        }
                    }
                    else{
                        System.out.println("Account ID not found!");
                    }
                } break;

                case 2: {
                    System.out.println("------------Sign Up-------------");
                    System.out.println("Enter ID:");
                    rId=Keyboard.readString();
                    while((Accounts.uniqueUserId(rId,resident))){ //repeat until user does not exist
                        if (Accounts.uniqueUserId(rId,resident)){ //if id does not exist
                            //create pin and append record
                            //generate Pin
                            //require userID and userPIN
                            rPin = Accounts.pinCode(resident); //send array of accounts to generate a unique PIN
                            User newResident = new User(rId,rPin);//create a new resident
                            resident=Accounts.appendUser(newResident,resident); //append to existing table
                        } else{
                            //contact your system admin to change reset your password
                            System.out.println("Account ID " + rId + " already exists.");
                        }
                    }
                } break;
                case 3: exitMenu1=true; break;
                default: //do nothing
            }
        }while(!exitMenu1);

    }
}