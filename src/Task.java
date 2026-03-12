import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task { //Objects created for Task
    int taskID;
    String title;
    String description;
    String priority;
    LocalDate dueDate;
    User assignedUser;

    public Task(int taskID, String title, String description, String priority, LocalDate dueDate, User assignedUser) {
        this.taskID = taskID; //ID number
        this.title = title; //Title
        this.description = description; //Description
        this.priority = priority; //Priority
        this.dueDate = dueDate; //Due Date
        this.assignedUser = assignedUser;
    }

    //Getters and Setters
    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    //Statement that loads at the end with all ticket credentials
    @Override
    public String toString() {
        String userName;

        if (assignedUser == null) {
            userName = "Unassigned";
        } else {
            userName = assignedUser.toString();
        }

        return "Task ID: " + taskID +
                ", Title: " + title +
                ", Description: " + description +
                ", Priority: " + priority +
                ", Due Date: " + dueDate +
                ", Ticket Claimed by: " + userName;
    }
}