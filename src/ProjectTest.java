import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {

    @Test //runs method as a test
    public void testAddTask() { //Tests to add task (Adds project with new parameter)
        Project project = new Project(
                1,
                "Website Redesign",
                "Update company website",
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 6, 1),
                null
        );

        Task task = new Task(
                101,
                "Design Homepage",
                "Create homepage layout",
                "High",
                LocalDate.of(2024, 3, 1),
                null
        );

        boolean result = project.addTask(task); //calls method

        assertTrue(result); //checks if method returns true
        assertEquals(1, project.getTasks().size()); //checks to make sure the project has at least 1 task
        assertTrue(project.getTasks().contains(task)); //checks to make sure the task is inside the list
    }

    @Test //Tests to remove tasks (Adds project with new parameter)
    public void testRemoveTask() { //project created for tests
        Project project = new Project(
                1,
                "Website Redesign",
                "Update company website",
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 6, 1),
                null
        );

        Task task = new Task( //tasks created for tests
                101,
                "Design Homepage",
                "Create homepage layout",
                "High",
                LocalDate.of(2024, 3, 1),
                null
        );

        project.addTask(task);
        boolean result = project.removeTask(task);

        assertTrue(result); //makes sure removal was successful
        assertEquals(0, project.getTasks().size()); //checks to see if the list is empty or not
        assertFalse(project.getTasks().contains(task)); //checks to see if task is actually gone from lists
    }
}