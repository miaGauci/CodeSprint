public class Accounts
{
    public static User[] userData(){
        User[] user = new User[10];
        user[0]=new User("1265804L","2312"); 
        user[1]=new User("7654389M","4571");
        user[2]=new User("0981296M","6941"); 
        user[3]=new User("0056700L","4509"); 
        user[4]=new User("1234567M","2159"); 
        user[5]=new User("3548503L","3511"); 
        user[6]=new User("6576978M","5558"); 
        user[7]=new User("0006765M","4187"); 
        user[8]=new User("0455784M","9224");
        user[9]=new User("admin","9999");
        return user;
    }
    
    public static boolean uniqueUserId(String text,User[] user){
        boolean unique=false;

        for (int c=0; c<user.length; c++){
            String userId=user[c].getId();
            if (userId.equals(text)){
                unique=false;
                c=user.length;
            } else
                unique=true;
        }
        return unique;
    }
    
    //Generate a unique pincode
    public static String pinCode(User[] user) {
        boolean pinIsUnique = false; //set flag to true
        String generatedPin;
        do{
            generatedPin = ""; //refresh pinCode
            for (int i=0; i<4; i++){ //generate a 4 digit pin code
                int pin = (int)(Math.random()*10);
                generatedPin = generatedPin + pin;
            } 
            
            System.out.println("Generated: " + generatedPin + "\n");
            for (int c=0; c<user.length; c++){
                String userPin = user[c].getPin();
                if (userPin.equals(generatedPin)) {
                    pinIsUnique = false; 
                    break; //go out of loop
                } else
                    pinIsUnique = true; 
            }
        } while (!pinIsUnique);
        return generatedPin;
    }
    
    
    //Append user to the existing array of users
    public static User[] appendUser(User newUser, User[] user ){
        User[] addUser = new User[user.length + 1]; //add an instance of class User in the next index in line
        for (int i=0 ; i<user.length; i++){
            addUser[i] = user[i]; //refresh new array of users (addUser) with existing users
        }
        addUser[user.length] = new User(newUser.getId(),newUser.getPin()); //add the new user to array addUser
        return addUser;
    }


}
