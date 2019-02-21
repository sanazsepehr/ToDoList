import javax.naming.NameNotFoundException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.stream.Stream;

public class ToDoList {
    private ArrayList<Task> taskList = new ArrayList<>();
    private Task t ;


    public void addTask ()
    {
        taskList.add(new Task());
    }

    public Task selectTask (String name ) throws NameNotFoundException
    {
        Iterator<Task> it = taskList.iterator();
        while(it.hasNext())
        {
            t = it.next();
            if(t.getTitle().equals(name))
            {
                return t;
            }
        }
        throw new NameNotFoundException("Task is not found");
    }

    public void printTaskList ()
    {
        taskList.stream()
        .forEach(task -> System.out.println(task.toString()));
    }

}

