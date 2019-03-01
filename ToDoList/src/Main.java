import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        // I make one object af my ToDoList class becouse I will call all method that they are inside class .
        // I don't need to make one object of Task class becouse I already make it in ToDoList class.

        Scanner scan = new Scanner(System.in);
        ToDoList doList = new ToDoList();
        PrintOptionsView view = new PrintOptionsView();




    }
}
