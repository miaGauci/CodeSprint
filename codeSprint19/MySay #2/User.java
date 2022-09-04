public class User {
    // instance variables - replace the example below with your own
    private String id;
    private String pin;
    private boolean voted;

    //Constructor for objects of class User
    public User(String userId,String userPin){
        // initialise instance variables
        id = userId;
        pin = userPin;
        voted = false;
    }

    public String getId(){
        return id;
    }
    
    public boolean getVoted(){
        return voted;
    }

    public void setVoted(boolean v){
        this.voted = v;
    }
    
    public String getPin(){
        return pin;
    }

    public boolean correctPin(String checkPin, User[] user){
        boolean found = false;
        for (int i=0; i<user.length; i++){
            if (checkPin.equals(user[i].getPin())){
                found = true;
                i=user.length;
            } else {
                found = false;
            }
        }
        return found;
    }

}
