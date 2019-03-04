import java.util.Scanner;

//test new old repo
public class Main {

    public static void main(String[] args){
        TaskList taskList = new TaskList();
        UserInterface userInterface = new UserInterface();
        // I make one object af my TaskList class becouse I will call all method that they are inside class .
        // I don't need to make one object of Task class becouse I already make it in TaskList class.
        while(true) {
           // Scanner scan = new Scanner(System.in);
            userInterface.printOptions();
        }



    }
}
