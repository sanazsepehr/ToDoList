package app;

import helper.FileHandling;
import model.Task;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.lang.String;

public class ToDoList {

    private ArrayList<Task> taskList;
    private String userName;
    //private static final long serialVersionUID=1L;


    public ToDoList()
    {
        taskList= FileHandling.openFile();
    }

    public void addToTaskList(Task t)
    {
        taskList.add(t);
    }

    public ArrayList<Task> getTaskList()
    {
        return taskList;
    }


     public void printTaskListOrderedByDate()
     {
         taskList.stream()
                 .sorted(Comparator.comparing(Task::getDueDate,Comparator.nullsLast(Comparator.naturalOrder())))
                 .forEach(task -> System.out.format("%-10s%-20s%-20s%20s\n", task.getTaskName(), task.getDueDate(),task.getProjectName(),task.getStatus()));
     }

    public void printTaskListFilteredByProjectName(String projectName)
    {
        boolean found=false;
        for(Task t:taskList)
        {
            if (projectName.equals(t.getProjectName())){
                found=true;
                break;
            }
        }

        if (found)
        {
            taskList.stream()
                    .filter(x -> x.getProjectName().equals(projectName))
                    .forEach(task -> System.out.format("%-10s%-20s%-20s%20s\n", task.getTaskName(), task.getDueDate(),task.getProjectName(),task.getStatus()));
        }
        else{
            System.out.println(projectName+" Doesn't Exist");
        }
    }

    public Task getTaskByIndex(int index)
    {
        return taskList.get(index);
    }


    public void updateTaskTitle(int index, String newTitle)
    {
        getTaskByIndex(index).setTitle(newTitle);
    }

    public void updateTaskProjectName(int index, String newProjectName )
    {
        getTaskByIndex(index).setProjectName(newProjectName);
    }

    public void updateTaskDate(int index, LocalDate newDueDate)
    {
        getTaskByIndex(index).setDueDate(newDueDate);
    }

    public void updateStatus(int index, String newStatus)
    {
        getTaskByIndex(index).setStatus(newStatus);
    }

    public void removeTaskByIndex(int index)
    {
      taskList.remove(index);
    }

    public long countTodo()
    {
        long counter = taskList.stream().filter(t->t.getStatus().equals("Not Done")).count();
        return counter;
    }

    public long countDone()
    {
        long counter = taskList.stream().filter(t->t.getStatus().equals("Done")).count();
        return counter;
    }

    public int getTaskListSize()
    {
        int sizeCounter = taskList.size();
        return sizeCounter;
    }

}


