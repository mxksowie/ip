import java.util.ArrayList;
import java.nio.file.Path;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<Task>();
    }

    public TaskList(String description) {
        tasks = new ArrayList<Task>();
        tasks.add(new Task(description));
    }

    protected String addTask(String description) {

        tasks.add(new Task(description));
        
        return String.format("added: %s", description);
    }

    protected String addTodo(String description) {
        Task task = new Todo(description);
        tasks.add(task);
        
        return task.toString();
    }

    protected String addDeadline(String description, String deadline) {
        Task task = new Deadline(description, deadline);
        tasks.add(task);
        
        return task.toString();
    }

    
    protected String addEvent(String description, String detail) {
        Task task = new Event(description, detail);
        tasks.add(task);
        
        return task.toString();
    }

    protected String addTodo(String description, boolean status) {
        Task task = new Todo(description);
        if (status) {
            task.markAsComplete();
        }
        tasks.add(task);
        
        return task.toString();
    }

    protected String addDeadline(String description, String deadline, boolean status) {
        Task task = new Deadline(description, deadline);
        if (status) {
            task.markAsComplete();
        }
        tasks.add(task);
        
        return task.toString();
    }

    
    protected String addEvent(String description, String detail, boolean status) {
        Task task = new Event(description, detail);
        if (status) {
            task.markAsComplete();
        }
        tasks.add(task);
        
        return task.toString();
    }

    protected String markComplete(int index) {
        index = index - 1; // start from 0 instead of 1
        Task task = tasks.get(index);
        task.markAsComplete();
        return (task.toString());
    }

    protected int size() {
        return tasks.size();
    }

    protected String delete(int i) {
        return tasks.remove(i - 1).toString();
    }

    protected void saveToFile(Path path) {
        SaveList.saveListToFile(path, tasks);
    }


    @Override
    public String toString() {
        String result = "";
        //for (Task task : tasks) {
        for (int i = 1; i <= tasks.size(); i++) {
            Task task = tasks.get(i - 1);
            result += i + ". " // + task.getCompletionStatusIcon() + " "
                    + task.toString() + "\n";
        }
        result += String.format("Now you have %s tasks in the list.", tasks.size());

        return result;
    }


}