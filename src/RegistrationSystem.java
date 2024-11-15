import java.io.*;
import java.util.ArrayList;

public class RegistrationSystem {
    private ArrayList<User> userList;
    private final String filename;

    public RegistrationSystem() {
        userList = new ArrayList<>();
        filename = "users.txt";
        initFromFile(filename);
    }

    private void initFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                if(data.length == 2){
                    String username = data[0].trim();
                    String password = data[1].trim();
                    userList.add(new User("","",username,password));
                }
            }
            System.out.println("INITFROMFILE(users) OK");
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    /**
     *
     * @param firstName Όνομα
     * @param lastName Επίθετο
     * @param userName  Username
     * @param password Κωδικός
     * @return
     */
    public boolean addUser(String firstName, String lastName, String userName, String password) {
        if(userNameIsTaken(userName)){
            return false;
        }
        User newUser = new User(firstName, lastName, userName, password);
        userList.add(newUser);
        saveUserToFile(newUser);
        return true;
    }

    private void saveUserToFile(User user) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true))){
            bw.write(user.getUserName() + "," + user.getPassword());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    private boolean userNameIsTaken(String userName){
        for(User user : userList){
            if(user.getUserName().equals(userName)){
                return true;
            }
        }
        return false;
    }


    public ArrayList<User> getUserList() {
        return userList;
    }

    /*
    public void printer(){
        System.out.println(userList.toString());
    }
    */

}
