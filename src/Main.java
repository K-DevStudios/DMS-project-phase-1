import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Project> projects = new ArrayList<Project>();
        List<User> users = new ArrayList<User>();
        CustomSearch customSearch = new CustomSearch();

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("*** KIRA: PROJECT MANAGEMENT SYSTEM ***");
            System.out.println("Please choose from options below:");
            System.out.println("1. Display project tickets");
            System.out.println("2. Create project ticket");
            System.out.println("3. Search project ticket");
            System.out.println("4. Clear project ticket");
            System.out.println("5. Update project ticket");
            System.out.println("6. Load project data");
            System.out.println("7. Exit");


            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if(projects.isEmpty()) {
                        System.out.println("There are no projects to display");
                    } else {
                        for(Project project : projects) {
                            System.out.println(project);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter Project ID: ");
                    int projectID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Project Name: ");
                    String projectName = scanner.nextLine();

                    System.out.println("Enter Project Description: ");
                    String projectDescription = scanner.nextLine();

                    System.out.println("Enter Project Start Date (YYYY-MM-DD): ");
                    String startDateInput = scanner.nextLine();
                    LocalDate projectStartDate = LocalDate.parse(startDateInput);

                    System.out.println("Enter Project Due Date (YYYY-MM-DD): ");
                    String dueDateInput = scanner.nextLine();
                    LocalDate projectDueDate = LocalDate.parse(dueDateInput);

                    Project newProject = new Project(
                            projectID,
                            projectName,
                            projectDescription,
                            projectStartDate,
                            projectDueDate,
                            null
                    );

                    projects.add(newProject);
                    System.out.println("Project created successfully!");
                    break;
                case 3:
                    List<Task> allTasks = new ArrayList<>();
                    for (Project project : projects) {
                        allTasks.addAll(project.getTasks());
                    }
                        if(allTasks.isEmpty()) {
                            System.out.println("There are no tasks to search");
                        } else{
                            System.out.println("Select search option:");
                            System.out.println("1. Search by keyword");
                            System.out.println("2. Search by task ID");
                            System.out.println("3. Search by task name");
                            System.out.println("4. Search by user ID");
                            int choice3 = scanner.nextInt();
                            scanner.nextLine();
                            List<Task> searchResults = new ArrayList<>();
                            switch (choice3) {
                                case 1:
                                    System.out.println("Enter keyword: ");
                                    String keyword = scanner.nextLine();
                                    searchResults = customSearch.searchByKeyword(keyword, allTasks);
                                    break;
                                case 2:
                                    System.out.println("Enter task ID: ");
                                    int taskID = scanner.nextInt();
                                    searchResults = customSearch.searchByTaskID(taskID, allTasks);
                                    break;
                                case 3:
                                    System.out.println("Enter task name: ");
                                    String taskName = scanner.nextLine();
                                    searchResults = customSearch.searchByName(taskName, allTasks);
                                    break;
                                case 4:
                                    System.out.println("Enter user ID: ");
                                    int userID = scanner.nextInt();
                                    searchResults = customSearch.searchByUserid(userID, allTasks);
                                    break;
                            }
                            if(searchResults.isEmpty()) {
                                System.out.println("There are no tasks to search");
                            } else{
                                for(Task searchResult : searchResults) {
                                    System.out.println(searchResult);
                                }
                            }
                        }
                    break;
                case 4: {
                    if(projects.isEmpty()) {
                        System.out.println("No projects available. Create or load a project first");
                    } else {
                        System.out.println("Enter Project ID:");
                        int projectID2 = scanner.nextInt();
                        scanner.nextLine();

                        Project selectedProject = null;
                        for(Project project : projects) {
                            if(project.getProjectID() == projectID2) {
                                selectedProject = project;
                                break;
                            }
                        }

                        if (selectedProject == null) {
                            System.out.println("Project not found.");
                        } else {
                            System.out.println("Enter Task ID: ");
                            int taskID = scanner.nextInt();
                            scanner.nextLine();

                            Task selectedTask = null;
                            for(Task task : selectedProject.getTasks()) {
                                if(task.getTaskID() == taskID) {
                                    selectedTask = task;
                                    break;
                                }
                            }

                            if (selectedTask == null) {
                                System.out.println("Task could not be found.");
                            } else {
                                if(selectedProject.removeTask(selectedTask)) {
                                    System.out.println("Project Ticket Completed Successfully!");
                                } else {
                                    System.out.println("Task could not be removed.");
                                }
                            }
                        }
                    }
                    break;
                }

                case 5: {
                    if(projects.isEmpty()) {
                        System.out.println("There are no projects to display");
                    } else {
                        System.out.println("Enter Project ID:");
                        int projectID3 = scanner.nextInt();
                        scanner.nextLine();

                        Project selectedProject = null;
                        for(Project project : projects) {
                            if(project.getProjectID() == projectID3) {
                                selectedProject = project;
                                break;
                            }
                        }

                        if (selectedProject == null) {
                            System.out.println("Project not found.");
                        } else {
                            System.out.println("Enter Task ID: ");
                            int taskID = scanner.nextInt();
                            scanner.nextLine();

                            Task selectedTask = null;
                            for(Task task : selectedProject.getTasks()) {
                                if(task.getTaskID() == taskID) {
                                    selectedTask = task;
                                    break;
                                }
                            }

                            if(selectedTask == null) {
                                System.out.println("Task could not be found.");
                            } else {
                                System.out.println("Ticket update options");
                                System.out.println("1. Update Title");
                                System.out.println("2. Update Description");
                                System.out.println("3. Update Priority");
                                System.out.println("4. Update Due Date");

                                int choice4 = scanner.nextInt();
                                scanner.nextLine();

                                switch (choice4) {
                                    case 1:
                                        System.out.println("Enter new title: ");
                                        String newTitle = scanner.nextLine();
                                        selectedTask.setTitle(newTitle);
                                        System.out.println("Title updated successfully!");
                                        break;
                                    case 2:
                                        System.out.println("Enter new description: ");
                                        String newDescription = scanner.nextLine();
                                        selectedTask.setDescription(newDescription);
                                        System.out.println("Description updated successfully!");
                                        break;
                                    case 3:
                                        System.out.println("Enter new priority: ");
                                        String newPriority = scanner.nextLine();
                                        selectedTask.setPriority(newPriority);
                                        System.out.println("Priority updated successfully!");
                                        break;
                                    case 4:
                                        System.out.println("Enter new due date (YYYY-MM-DD): ");
                                        String newDueDate = scanner.nextLine();
                                        selectedTask.setDueDate(LocalDate.parse(newDueDate));
                                        System.out.println("Due date updated successfully!");
                                        break;
                                    default:
                                        System.out.println("Invalid choice.");
                                        break;
                                }
                            }
                        }
                    }
                    break;
                }
                case 6:
                    // Inform the user that sample data is being loaded
                    System.out.println("Loading sample project data...");

                    // Create sample projects with IDs, names, descriptions, and dates
                    Project project1 = new Project(
                            1,
                            "Website Redesign",
                            "Update company website layout and functionality",
                            LocalDate.of(2024, 1, 1),
                            LocalDate.of(2024, 6, 1),
                            null
                    );
                    Project project2 = new Project(
                            2,
                            "Mobile App Development",
                            "Develop a mobile version of the company platform",
                            LocalDate.of(2024, 2, 1),
                            LocalDate.of(2024, 8, 1),
                            null
                    );
                    // Create tasks that will belong to the projects
                    Task task1 = new Task(
                            101,
                            "Design homepage",
                            "Create layout and visual design for homepage",
                            "High",
                            LocalDate.of(2024, 3, 1),
                            null
                    );
                    Task task2 = new Task(
                            102,
                            "Build login system",
                            "Develop authentication system for users",
                            "Medium",
                            LocalDate.of(2024, 4, 1),
                            null
                    );
                    Task task3 = new Task(
                            201,
                            "Design mobile UI",
                            "Create mobile interface mockups",
                            "High",
                            LocalDate.of(2024, 3, 15),
                            null
                    );
                    // Add tasks to their corresponding projects
                    project1.addTask(task1);
                    project1.addTask(task2);
                    project2.addTask(task3);

                    // Add the projects (with their tasks) to the main project list
                    projects.add(project1);
                    projects.add(project2);

                    // Confirm that sample data was loaded successfully
                    System.out.println("Sample project data loaded successfully!");

                    break;
                case 7:
                    isRunning = false;
                    System.out.println("Bye! :)");
                    break;


                    default:
                        System.out.println("Invalid menu choice. Please try again.");
                        break;
            }
        }
    }
}