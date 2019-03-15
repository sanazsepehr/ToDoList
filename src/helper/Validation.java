package helper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.lang.String;

public class Validation {
    private static Scanner scanner = new Scanner(System.in);


    public static LocalDate dateValidation(String dateToBeValidated) {
        LocalDate dueDate = null;
        Boolean success = false;
        do {
            try {
                String date = dateToBeValidated;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dueDate2check = LocalDate.parse(date, formatter);
                if (LocalDate.now().isAfter(dueDate2check)){
                    System.out.println("Date in the past");
                    System.out.println("Try again");
                    dateToBeValidated = scanner.nextLine();
                }
                else{
                    dueDate=dueDate2check;
                    success = true;
                }
            } catch (Exception e) {
                System.out.println("Please Enter date in correct format: (dd/MM/yyyy)");
                dateToBeValidated = scanner.nextLine();
            }
        }
        while (success == false);
        return dueDate;
    }

    public static int choiceValidation(int min, int max)
    {
        int choice;
        while (true)
        {
            try {
                String strChoice = scanner.nextLine();
                choice = Integer.parseInt(strChoice);
                if (min <= choice &&  choice <= max)
                {
                    return choice;

                } else {
                    System.out.println("<<< Please choose a number between "+ min + " and " + max +" >>>");
                }
            } catch(Exception e){
              System.out.println("<<< Please write a number for your choice: >>>");
            }
        }
    }

    public static int indexValidation(int listSize)
    {
        int indexToValidate = 0;
        Boolean successful = false;
        while (!successful)
        {
            try {
                String strChoice = scanner.nextLine();
                int choice = Integer.parseInt(strChoice);
                if (choice < listSize) {
                    indexToValidate = choice;
                    successful = true;
                } else {
                    System.out.println("Index does not exist. Please choose a correct index:");
                }
            } catch (Exception e){
                System.out.println("The input is invalid");
            }
        }
         return indexToValidate;
    }

    public static String inputValidation()
    {
        String input = null;
        Boolean successful = false;
        while (!successful)
        {
            try {
                String inputToValidate = scanner.nextLine();
                if (inputToValidate != null && !inputToValidate.equals("") && !inputToValidate.isEmpty()) {
                    input = inputToValidate;
                    successful = true;
                } else {
                    System.out.println("<<< Please write a valid input, try again: >>>");
                }
            }catch (Exception e){
                System.out.println("<<< The input is invalid >>>");
            }
        }
        return input;
    }

    public static String statusValidation()
    {
        String input = null;
        Boolean successful = false;
        while (!successful)
        {
            try {
                String inputToValidate = scanner.nextLine();
                if ((inputToValidate.equals("Done")) || (inputToValidate.equals("NotDone"))) {
                    input = inputToValidate;
                    successful = true;
                } else {
                    System.out.println("<<< Please write a valid input, Done or NotDone: >>>");
                }
            }catch (Exception e){
                System.out.println("<<< The input is invalid >>>");
            }
        }
        return input;
    }
}