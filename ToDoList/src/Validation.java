import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
import java.util.logging.Filter;

public class Validation {
    Scanner scanner;
    ToDoList toDoList = new ToDoList();

    public Validation()
    {
        scanner = new Scanner(System.in);
    }

    public  void dateValidation()
    {
        LocalDate dueDate = null;
        Boolean success = false;
        do
        {
            try {
                System.out.println("Please Enter Task date: (dd/MM/yyyy)");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String stringToDate = scanner.next();
                dueDate = LocalDate.parse(stringToDate, formatter);
                success = true;

            } catch (Exception e) {
                System.out.println("Please Enter date in correct format!");
            }
        }
        while(success ==false);
    }

    public Boolean titleValidation(String title)
    {
       long counter = toDoList.getTaskList().stream()
       .filter(x -> x.getTitle().equals(title)).count();
       if(counter ==0)
         {
           return true;
         }else
             {
           return false;
         }
    }
}
