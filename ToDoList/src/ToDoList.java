
import java.time.LocalDate;
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

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void addTask ()
    {
        Validation validation= new Validation();
        String title =null;
        //title
        Boolean noDuplicate = false;
        while (noDuplicate == false) {
            System.out.println("Please Enter Task title:");
            scanner.next();
            title = scanner.nextLine();
            noDuplicate = validation.titleValidation(title);
        }
        // duedate
        validation.dateValidation();
        LocalDate dueDate=null;
        // projectName
        System.out.println("Please Enter project name:");
        //scanner.next();
        String projectName = scanner.next();

        Task newTask = new Task(title, dueDate, projectName);
        taskList.add(newTask);
        System.out.println("your newTask have been added successfuly");
    }



    /*public Task selectTaskByTitle(String name) throws Exception
    {
        //TODO find using stream
        for (int i = 0; i < taskList.size(); i++)
        {
            if (taskList.get(i).getTitle().equals(name))
            {
                return taskList.get(i);
            }
        }

        throw new Exception("can't find that name");
        //return null;
    } */

    public Task selectTaskByTitle(String name)
    {
        return
        taskList.stream()
                .filter(x -> x.equals(name))
                .findFirst()
                .orElse(null);
    } 


    public Task findTaskByIndex(int index)
    {
        return taskList.get(index);
    }


    //TODO don't change this. it looks great
    public void printTaskList ()
    {
        taskList.stream()
                .forEach(task -> System.out.println(task.toString()));
    }


    public void printTaskWithIndex()
    {
        for (int i = 0; i < taskList.size(); i++)
        {
            System.out.println( i + ": " + taskList.get(i));
        }
    }
}

