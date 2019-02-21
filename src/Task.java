
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Task {

    private String title;
    private LocalDate dueDate;
    private String projectName;
    private Boolean isDone = false;


    public Task ()
    {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Please Enter Task title:");
        title = scanner.nextLine();

        System.out.println("Please Enter Task date: (dd/MM/yyyy HH:mm)");
        Boolean success = false;
        do {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dueDate = LocalDate.parse(scanner.next(), formatter);
                success = true;

            } catch (Exception e) {
                System.out.println("Please Enter date in correct format!");
            }
        }
        while (success == false);

        System.out.println("Please Enter project name:");
        scanner.next();
        projectName = scanner.next();
    }

    public String getTitle()
    {
        return this.title;
    }

    public LocalDate getDueDate()
    {
        return this.dueDate;
    }

    public String getProjectName()
    {
        return this.projectName;
    }

    public Boolean getIsDone()
    {
        return this.isDone;
    }



    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setDueDate(LocalDate dueDate)
    {
        this.dueDate = dueDate;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public void setIsDone(Boolean isDone)
    {
        this.isDone = isDone;
    }


    // Task is an object. If I want to print my object I need to convert my object to String.
    public String toString()
    {
    return (title + dueDate + isDone + projectName);
    }

}
