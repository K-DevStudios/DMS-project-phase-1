import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {
    int projectID;
    String projectName;
    String projectDescription;
    LocalDate projectStartDate;
    LocalDate projectDueDate;
    User assignedUser;
    List<Task> tasks;

    //Constructors

    public Project(int projectID, String ProjectName, String ProjectDescription, LocalDate projectStartDate, LocalDate projectDueDate, User assignedUser) {
        this.projectID = projectID;
        this.projectName = ProjectName;
        this.projectDescription = ProjectDescription;
        this.projectStartDate = projectStartDate;
        this.projectDueDate = projectDueDate;
        this.assignedUser = assignedUser;
        this.tasks = new ArrayList<Task>();
    }

    //Getters and Setters
    public int getProjectID() {
        return projectID;
    }
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getProjectDescription() {
        return projectDescription;
    }
    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
    public LocalDate getProjectStartDate() {
        return projectStartDate;
    }
    public void setProjectStartDate(LocalDate projectStartDate) {
        this.projectStartDate = projectStartDate;
    }
    public LocalDate getProjectDueDate() {
        return projectDueDate;
    }
    public void setProjectDueDate(LocalDate projectDueDate) {
        this.projectDueDate = projectDueDate;
    }
    public User getAssignedUser() {
        return assignedUser;
    }
    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "Project ID: " + projectID +
                "\nProject Name: " + projectName +
                "\nDescription: " + projectDescription +
                "\nStart Date: " + projectStartDate +
                "\nDue Date: " + projectDueDate +
                "\nTasks: " + tasks + "\n";
    }

    //Adding task to user
   public boolean addTask(Task task) { //returns no task by default. If the user does not already have task assigned, they are assigned the task
       if(task != null && !tasks.contains(task)) {
           tasks.add(task); //Task returns true to add task
           return true;
       }
       return false;
   }

    //Removing task from project (Completing Ticket)
   public boolean removeTask(Task task) {
        if(task != null && tasks.contains(task)) { //if user has task, they are able to remove task successfully.
            tasks.remove(task);
            return true;
        }
        return false;
   }

   public void updateProjectDetails(String projectName, String projectDescription, LocalDate projectStartDate, LocalDate projectDueDate){
        if(projectName != null && projectDescription != null && projectStartDate != null && projectDueDate != null && assignedUser != null) {
            this.projectName = projectName;
            this.projectDescription = projectDescription; //User updates individual parameter of Project ticket as long as there is an assigned user and a task
            this.projectStartDate = projectStartDate;
            this.projectDueDate = projectDueDate;
        }

    }

   }

