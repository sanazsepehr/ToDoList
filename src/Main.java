import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        /*final Formatter x;
        try{
            x = new Formatter ("file.txt");
            System.out.println("you created a file ");
        }catch (Exeption e){
            Syste.out.println("you got an error")
        }*/

        // I make one object af my ToDoList class becouse I will call all method that they are inside class .
        // I don't need to make one object of Task class becouse I already make it in ToDoList class.

        Scanner scan = new Scanner(System.in);
        ToDoList doList = new ToDoList();


        //Task t1 = new Task("novare", "22/01/1989", "ip");

        // make file


        System.out.println("Welcome toDoLy");
        doList.printTaskList();
        System.out.println("You have option 1, 2, 3 and 4");
        int option = scan.nextInt();
        switch (option)
        {
            case 1:
                System.out.println("Show Task List by (date or project)");
                //showTaskList();
                //showtaskbydate();
                //showTaskbyproject();
                doList.printTaskList();
                break;
            case 2:
                System.out.println("Add new task");
                doList.addTask();
                break;
            case 3:
                System.out.println("Edit Task update, mark as done, remove");
                //editTask();
                //updateTask();
                //removeTask();
                break;
            case 4:
                System.out.println("Save and Quit");
                //saveTask();
                //QuitTask();
                break;
            default:
        }


    }
}
