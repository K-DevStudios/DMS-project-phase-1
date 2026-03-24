import java.util.ArrayList;
import java.util.List;

public class User {
    private final int userID;
    private String userName;
    private String userEmail;
    private String role;

    List<Task> tasks = new ArrayList<>();

    //Constructors
    public User(int userID, String userName, String userEmail, String role) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.role = role;
    }

    //Getters and Setters
    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }



    public List<Task> getAssignedTasks(){ //Gets displayed list of tasks assigned to user
        return tasks;
    }

    public boolean assignTask(Task task){ //assigns task to user
        if(task == null){
            return false;
        } else if(tasks.contains(task)){
            return false;
        }
        tasks.add(task);
        return true;
    }

    public boolean removeTask(Task task){ //removes task
        if(task == null){
            return false;
        } else if(tasks.contains(task)){
            tasks.remove(task);
            return true;
        }
        return false;
    }


}
