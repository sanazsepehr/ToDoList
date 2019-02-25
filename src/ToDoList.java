import javax.naming.NameNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class ToDoList {
    private ArrayList<Task> taskList = new ArrayList<>();


    private Scanner scanner;

    public ToDoList()
    {
        scanner = new Scanner (System.in);
    }

    public void addTask ()
    {
        System.out.println("Please Enter Task title:");
        String title = scanner.nextLine();

        System.out.println("Please Enter Task date: (dd/MM/yyyy)");
        Boolean success = false;
        LocalDate dueDate = null;

        do {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String stringToDate = scanner.next();
                // dueDate is a local date
                dueDate = LocalDate.parse(stringToDate, formatter);
                success = true;

            } catch (Exception e) {
                System.out.println("Please Enter date in correct format!");
            }
        }
        while (success == false);

        System.out.println("Please Enter project name:");
        scanner.next();
        String projectName = scanner.next();

        Task task = new Task(title, dueDate, projectName);
        taskList.add(task);
    }

    public Task selectTask(String name ) {
        Task taskToSelect= null;
        Boolean success = false;
        do {
            try {
                for (int i = 0; i < taskList.size(); i++)
                {
                    if (taskList.get(i).getTitle().equals(name)) {
                        taskToSelect = taskList.get(i);
                    }
                    success = true;
                }

            } catch (Exception e) {
                System.out.println("llll");
            }
        } while (success == false);
        return taskToSelect;
    }




    public void printTaskList ()
    {
        taskList.stream()
                .forEach(task -> System.out.println(task.toString()));
    }

}

