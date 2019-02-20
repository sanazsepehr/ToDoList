import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task {

    private String title;
    private Date dueDate;
    private String projectName;
    private Boolean isDone = false;




    public Task ()
    {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Please Enter Task title:");
        title = scanner.nextLine();

        System.out.println("Please Enter Task date: (dd/MM/YYYY hh:mm)");
        Boolean success = false;
        do {
            try {
                scanner.next();
                dueDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(scanner.nextLine());
                success = true;

            } catch (ParseException e) {
                System.out.println("Please Enter date in correct format!");
            }
        }
        while (success == false);

        System.out.println("Please Enter project name");
        projectName = scanner.next();
    }

    public String getTitle()
    {
        return this.title;
    }

    public Date getDueDate()
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

    public void setDueDate(Date dueDate)
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
}
