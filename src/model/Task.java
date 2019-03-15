package model;
import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {

    private String title;
    private LocalDate dueDate;
    private String projectName;
    private String status;
    private static final long serialVersionUID=1L;

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
        this.status = "Not Done";
    }

    public String getTaskName()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public LocalDate getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate)
    {
        this.dueDate = dueDate;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = "Done";
    }

    public String toString()
    {
        return getTaskName() + "  " + getDueDate() + "  " + getProjectName() + "  "+ getStatus();
    }
}
