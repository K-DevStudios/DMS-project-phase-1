import java.time.LocalDate;

public class TaskDependency {
    int dependencyId;
     Task task;
     Task dependsOn;

     //For each depenency, if depends on is not completed then completion gets blocked.

     public TaskDependency(int dependencyId, Task task, Task dependsOn) {
        this.dependencyId = dependencyId;
        this.task = task;
        this.dependsOn = dependsOn;
     }
     public int getDependencyId() {
        return dependencyId;
     }

     public Task getTask() {
         return task;
     }

     public Task getDependsOn() {
         return dependsOn;
     }

}
