import java.util.ArrayList;
import java.util.List;

public class CustomSearch {
    public List<Task>searchByKeyword(String keyword, List<Task> tasks) {
        List<Task> results = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(task);
            }
        } return results;
    }

    public List<Task> searchByTaskID(int taskId, List<Task> tasks) {
        List<Task> results = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTaskID() == taskId) {
                results.add(task);
            }
        } return results;
    }

    public List<Task> searchByName(String taskTitle, List<Task> tasks) {
        List<Task> results = new ArrayList<>();
        for (Task task : tasks) {
            if(task.getTitle().toLowerCase().contains(taskTitle.toLowerCase())) {
                results.add(task);
            }
        } return results;
    }

    public List<Task> searchByUserid(int userID, List<Task> tasks) {
        List<Task> results = new ArrayList<>();
        for (Task task : tasks) {
          if(task.getAssignedUser() != null) {
              if (task.getAssignedUser().getUserID() == userID) {
                  results.add(task);
              }
          }
        } return results;
    }
}
