package app;
import helper.FileHandling;
import helper.Validation;
import model.Task;
import java.lang.String;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private ToDoList toDoList = new ToDoList();
    private Scanner scanner = new Scanner(System.in);
    private boolean open;

    public UserInterface()
    {
        open = true;
    }

    public void welcome()
    {
        System.out.println("<< You have option 1, 2, 3 and 4 >>");
        System.out.println("==========================================================================================");
        System.out.println(">>> 1 = Show task list");
        System.out.println(">>> 2 = Add new task");
        System.out.println(">>> 3 = Edit task: update, remove");
        System.out.println(">>> 4 = Save and Quit");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(" Please choose an option : ");
    }

    public void showDone()
    {
        System.out.println("==========================================================================================");
        System.out.println("You have "+ toDoList.countTodo()+" tasks to do and "+toDoList.countDone()+" are done");
        System.out.println("==========================================================================================");
    }

    public void mainMenu()
    {
        while (open)
        {
            showDone();
            welcome();

               int min = 1;
               int max = 4;
               int choice = Validation.choiceValidation(min, max);
               switch (choice)
               {
                   case 1:
                        showListMenu();
                       break;
                   case 2:
                       addTask();
                       break;
                   case 3:
                       showEditMenu();
                       break;
                   case 4:
                       FileHandling.saveFile(toDoList);
                       open = false;
                       System.out.println("Goodbye! ;) ");
                       break;

               }
        }
    }

    private void printHeader()
    {
        System.out.println("==========================================================================================");
        System.out.printf("%-10s%-20s%-20s%20s", "TITLE", "DUE DATE", "PROJECT NAME", "STATUS");
        System.out.println();
        System.out.println("==========================================================================================");

    }

    private void showListMenu()
    {
        System.out.println(">>> 1 = Show task list:");
        System.out.println(">>> 2 = Show full Task List ordered by date:");
        System.out.println(">>> 3 = Show task list filtered By project name:");
        System.out.println("------------------------------------------------------------------------------------------");
        int min = 1;
        int max = 3;
        int choice = Validation.choiceValidation(min, max);
        switch (choice) {
            case 1:
                printFormattedTaskList();
                returnToMainMenu();
                break;
            case 2:
                printHeader();
                toDoList.printTaskListOrderedByDate();
                returnToMainMenu();
                break;
            case 3:
                System.out.println(" <<<Please enter project name: >>>");
                String projectName = scanner.nextLine();
                printHeader();
                toDoList.printTaskListFilteredByProjectName(projectName);
                returnToMainMenu();
                break;
            default:
        }
    }


    private void showEditMenu()
    {
        System.out.println(">>> 1 = Update task:");
        System.out.println(">>> 2 = Remove task:");
        System.out.println("------------------------------------------------------------------------------------------");
        int min = 1;
        int max = 2;
        int choice = Validation.choiceValidation(min, max);
        switch (choice)
        {
            case 1:
                updateTask();
                break;
            case 2:
                removeTask();
                break;
            default:
        }
    }

    private void showList()
    {
        System.out.println("Do you want to see the list: 1: yes, 2: No");
        int min = 1;
        int max = 2;
        int choice = Validation.choiceValidation(min, max);
        switch (choice)
        {
            case 1:
                printFormattedTaskList();
                returnToMainMenu();
                break;
            case 2:
                returnToMainMenu();
                break;
            default:
        }
    }

    private void returnToMainMenu()
    {
        System.out.println("<<< Please press Enter to continue >>>");
        scanner.nextLine();
    }


    public void addTask()
    {
        System.out.println("Please Enter Task title:");
        String title = Validation.inputValidation();
        System.out.println("Please Enter Task date: (dd/MM/yyyy)");
        String dateToValidate = scanner.nextLine();
        LocalDate dueDate = Validation.dateValidation(dateToValidate);
        System.out.println("Please Enter project name:");
        String projectName = Validation.inputValidation();
        Task newTask = new Task(title, dueDate, projectName);
        toDoList.addToTaskList(newTask); // EXTERNAL method call
        System.out.println("<<<<<<Your task added successfully To List!>>>>>>");
        showList();
    }

    public void updateTask()
    {
        System.out.println(">>> Please choose task index to update from list <<<");
        printFormattedTaskList();
        int index = Validation.choiceValidation(0, toDoList.getTaskListSize());
        Boolean updatingDone = false;
        while (!updatingDone)
        {
            System.out.println("Choose Option: 1 = Title, 2 = Date , 3 = Project Name, 4 = Status, 5 = Updating done");
            int min = 1;
            int max = 5;
            int choice = Validation.choiceValidation(min, max);

                switch (choice) {
                    case 1: {

                        System.out.println("Please Enter new Title:");
                        String newTitle = Validation.inputValidation();
                        toDoList.updateTaskTitle(index, newTitle);
                        System.out.println("Task title updated");
                        break;
                    }
                    case 2: {
                        System.out.println("Please Enter new date: (dd/MM/yyyy):");
                        LocalDate newDueDate = Validation.dateValidation(scanner.nextLine());
                        toDoList.updateTaskDate(index, newDueDate);
                        System.out.println("Task date updated");
                        break;
                    }
                    case 3: {
                        System.out.println("Please enter new Project Name:");
                        String newProjectName = Validation.inputValidation();
                        toDoList.updateTaskProjectName(index, newProjectName);
                        System.out.println("Project name updated");
                        break;
                    }
                    case 4: {
                        System.out.println("Please enter new Status: Done or NotDone:");
                        String newStatus = Validation.statusValidation();
                        toDoList.updateStatus(index, newStatus);
                        System.out.println("Status updated");
                        break;
                    }
                    case 5: {
                        updatingDone = true;
                        break;
                    }
                }
        }
    }

    public void removeTask()
    {
        if (toDoList.getTaskListSize()==0) {
            System.out.println("The list is empty. There is nothing to remove.");
        }
        else {
            try {
                printFormattedTaskList();
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("<<<<<< Please choose task index to remove from list : >>>>>>>");
                int index = Validation.choiceValidation(0, toDoList.getTaskListSize());
                toDoList.removeTaskByIndex(index);
                showList();
            } catch (NumberFormatException e) {
                System.out.println("<<< PLease write a number for your index >>>");
            }
        }
    }


    private void printFormattedTaskList()
    {
        List<Task> list = toDoList.getTaskList();
        System.out.println("==========================================================================================");
        System.out.printf("%-10s%-20s%-20s%-20s%20s", "INDEX", "TITLE", "DUE DATE", "PROJECT NAME", "STATUS");
        System.out.println();
        System.out.println("==========================================================================================");

        int index=0;

        for (Task task: list)
        {
            System.out.format("%-10s%-20s%-20s%-20s%20s\n",index , task.getTaskName(), task.getDueDate(),task.getProjectName(),task.getStatus());
            index++;
        }
    }
}


