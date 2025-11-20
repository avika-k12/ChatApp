public class User{

    private static String username;
    private static String status;

    public User(String username) {
        this.username = username;
        this.status = "offline";
    }

    public String getUsername(){
        return this.username;
    }

    public String getStatus(){
        return this.status;
    }

    public String changeStatus(String newStatus){
        this.status = newStatus;
        return "Your new status is " + this.status;
    }

    public String changeUsername(String newUser) {
        this.username = newUser;
        return "Your new username is " + this.username;
    }

}
