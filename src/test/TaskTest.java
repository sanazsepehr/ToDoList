package test;
import model.Task;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    private LocalDate dueDate;
    private Task task;
    private String projectName;
    private String taskName;

    @BeforeEach
    public void setUp() {
        dueDate = LocalDate.now();
        projectName = "the name of the project";
        taskName = "the name of the task";
        task = new Task(taskName, dueDate,projectName);
    }


    @Test
    void getTaskNameTest() {
        String name=task.getTaskName();
        assertEquals(taskName,name);
    }

    @Test
    void getDueDateTest() {
        LocalDate date=task.getDueDate();
        assertEquals(dueDate,date);
    }

    @Test
    void getProjectNameTest() {
        String name=task.getProjectName();
        assertEquals(projectName,name);
    }

    @Test
    void setAndGetStatusTest() {
        task.setStatus("Done");
        assertEquals("Done",task.getStatus());
    }

    @Test
    void setTaskNameTest() {
        String name="name1";
        task.setTitle(name);
        assertEquals(name,task.getTaskName());
    }

    @Test
    void setDueDateTest() {
        LocalDate date = LocalDate.now();
        task.setDueDate(date);
        assertEquals(date,task.getDueDate());
    }

    @Test
    void setProjectNameTest() {
        String name="name2";
        task.setProjectName(name);
        assertEquals(name,task.getProjectName());
    }

}