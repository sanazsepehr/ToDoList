import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {

    private String title;
    private LocalDate dueDate;
    private String projectName;
    private Boolean isDone = false;

    /**
     *
     * @param title
     * @param dueDate
     * @param projectName
     */
    public Task(String title, LocalDate dueDate, String projectName)
    {
        this.title = title;
        this.dueDate = dueDate;
        this.projectName = projectName;
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


    /**
     *
     * @param title
     */
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
        //TODO convert duedate and the boolean to a string and and seperator between them "=="
        //TODO read this again
        //Convert the local date to String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = formatter.format(dueDate);

        String status;
        if (isDone == true)
            status = "done";
        else
            status = "notDone";

        return title + "  " + date + "  " + isDone + "  "+ projectName;
    }

}
