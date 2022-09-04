class appEngine {
    String[] id = new String[20];
    String[] pass = new String[20];
    boolean[] votes = new boolean[20];

    public void initialiseData(){
        for (int i=0; i<20; i++){
            id[i] = "";
            pass[i] = "";
            votes[i] = false;
        }
        id[0] = "1265804L"; pass[0] = "2312";
        id[1] = "7654389M"; pass[1] = "4571";
        id[2] = "0981296M"; pass[2] = "6941";
        id[3] = "0056700L"; pass[3] = "4509";
        id[4] = "1234567M"; pass[4] = "2159";
        id[5] = "3548503L"; pass[5] = "3511";
        id[6] = "6576978M"; pass[6] = "5558";
        id[7] = "0006765M"; pass[7] = "4187";
        id[8] = "0455784M"; pass[8] = "9224";    
    }
    
    public int checkUser(String idNum, String pWord){
        byte index = 0;
        byte nextIndex = 0;
        boolean found = false;
        int pCode = 0;
        
        //check ID
        do {
            if (id[index].equals(idNum)) found = true; //if id is found
            else if (id[index].equals("")) { //if array index contains empty value
                nextIndex = index;
                break; //go out of loop
            }
            else index ++; 
        } while (!found && index < 20);
        
        if (!pWord.equals("n/a")){ //if logging in and not signing up a new account
            //if id found check for password
            if (!found) System.out.println("!! You are not registered in the system !!");
            else { //check password
                if (pWord.equals(pass[index])){
                    System.out.println("!! You are logged in successfully !!");
                    return index; //if found return index position
                } else System.out.println("!! Password is not correct!!");
            }
            return -1; //-1 will indicate not found
        } else { //if signing up
            if (found) System.out.println("!! You are already registered in the system !!");
            else {
                found = false; //reset variable
                index = 0; //reset variable
                               
                do{
                    pCode = 1000 + (int)(Math.random()*9999); //generate password - 4 digit code
                    if (pCode == Integer.parseInt(pass[index])) found = true; //type cast passwords stored into integer to be able to compare with pcode generated
                    index ++;
                } while (!found && index < nextIndex); //until password is found or reached an empty slot in array
                if (!found) {
                    id[nextIndex] = idNum; //store new user
                    pass[nextIndex] = Integer.toString(pCode); //convert password from integer to string and store new password
                } return  pCode;
            }
            return 0;
        }
    }   
}

