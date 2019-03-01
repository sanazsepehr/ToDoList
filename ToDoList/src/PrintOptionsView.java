import java.util.Scanner;

public class PrintOptionsView {

    private ToDoList toDoList = new ToDoList();
    private Scanner scanner ;

    public PrintOptionsView()
    {
        scanner= new Scanner(System.in);
    }

    public void printOptions ()
    {
        System.out.println("Welcome toDoLy");
        System.out.println("You have option 1, 2, 3 and 4");
        System.out.println(" 1 = Show Task List by (date or project");
        System.out.println("2 = Add new task");
        System.out.println("3 = Edit Task update, mark as done, remove");
        System.out.println("4 = Save and Quit");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Show Task List by (date or project)");
                //showTaskList();
                //showtaskbydate();
                //showTaskbyproject();
                toDoList.printTaskList();
                break;
            case 2:
                System.out.println("Add new task");
                toDoList.addTask();
                break;
            case 3:
                System.out.println("Edit Task update, mark as done, remove");

                toDoList.printTaskWithIndex();
                System.out.println("choose task index to update");
                //editTask();
                //updateTask();
                //removeTask();
                break;
            case 4:
                System.out.println("Save and Quit");
                //saveTask();
                //QuitTask();
                //TODO have return here or system.exit
                break;
            default:
        }
    }

}

