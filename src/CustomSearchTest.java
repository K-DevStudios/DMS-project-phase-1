import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CustomSearchTest {
    @Test
    public void testSearchTaskByID() { //Tests for search tasks by ID
        CustomSearch customSearch = new CustomSearch();

        Task task1 = new Task(101, "Design Homepage","Create homepage layout", "High", LocalDate.of(2026,3,26), null);
        Task task2 = new Task(102, "Build login","Develop login system", "Medium", LocalDate.of(2026,3,26), null);

        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);

        List<Task> results = customSearch.searchByTaskID(102,  taskList); //Tests to search for task with that ID
        assertEquals(results.size(), 1); //Verifies to make sure there is only one result
        assertEquals(results.get(0).getTaskID(), 102); //confirms the id should be 102
    }

    @Test
    public void testSearchTaskByKeyword() { //Test to see if searching task my keyword actually works
        CustomSearch customSearch = new CustomSearch();
        Task task1 = new Task(101, "Design Homepage","Create homepage layout", "High", LocalDate.of(2026,3,26), null);
        Task task2 = new Task(102, "Build login","Develop login system", "Medium", LocalDate.of(2026,3,26), null);

        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        List<Task> results = customSearch.searchByKeyword("Homepage", taskList); //Tests to search for task with keyword
        assertEquals(1, results.size()); //Makes sure there is exactly one task
        assertEquals(101, results.get(0).getTaskID()); //makes sure the id of the task equals exactly 101
    }

    @Test
    public void testUpdateTitle() { //Test to see if updating the title actually changes
        Task task = new Task(101, "Title", "Description", "High", LocalDate.of(2026,3,26), null);
        task.setTitle("New Title");
        assertEquals("New Title", task.getTitle()); //checks to make sure title is changed
    }
}
