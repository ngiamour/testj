import java.util.ArrayList;

public class LoginSystem {
    private User loggedUser;

    public LoginSystem() {
        loggedUser = null;
    }

    public boolean login(ArrayList<User> userList, String username, String password) {
        for (User user : userList) {
            if(user.getUserName().equals(username) && user.getPassword().equals(password)) {
                loggedUser = user;
                System.out.println("Καλωσήρθες "+ loggedUser.getUserName() + "!");
                return true;
            }
        }
        System.out.println("Login failed!");
        return false;
    }

    public void logout() {
        if(loggedUser != null) {
            System.out.println("Logged out: "+ loggedUser.getUserName());
            loggedUser = null;
        } else{
            System.out.println("No user found");
        }
    }

    public boolean isLoggedIn(){
        return loggedUser != null;
    }
}
