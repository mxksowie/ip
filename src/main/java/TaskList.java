import java.util.ArrayList;
import java.nio.file.Path;

/**
 * Wrapper class for the underlying implementation of tasklist as an arraylist.
 * Is an abstraction barrier for Task and its subclasses:
 * TaskList does not return task objects, only strings.
 * No classes above has direct access to task objects.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<Task>();
    }

    public TaskList(String description) {
        tasks = new ArrayList<Task>();
        tasks.add(new Task(description));
    }
    /**
     * Depreciated method. Adds a generic task.
     * @param description
     * @return
     */
    protected String addTask(String description) {

        tasks.add(new Task(description));
        
        return String.format("added: %s", description);
    }

    /**
     * Adds a todo to the tasklist.
     * The call sequenence for this method should originate from TaskManager
     * The same applies to the subsequent add___ methods.
     * They should be the go-to method of adding tasks
     * @param description
     * @return
     */
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

    /**
     * Adds a todo to the tasklist while specifying its completion status.
     * The call sequence for this method should originate from RetrieveList only.
     * This is a non-default method of adding tasks, created to support adding completed tasks.
     * The same applies to the subsequent add___ methods.
     * @param description
     * @param status
     * @return
     */
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

    /**
     * Mark a task in the list at the specified index as completed.
     * Throws IndexOutOfBounds error.
     * @param index
     * @return the completed task in its string rep
     */
    protected String markComplete(int index) {
        index = index - 1; // start from 0 instead of 1
        Task task = tasks.get(index);
        task.markAsComplete();
        return (task.toString());
    }

    protected int size() {
        return tasks.size();
    }

    /**
     * Delete the task in the list at specified index
     * Throws IndexOutOfBounds error.
     * @param index
     * @return
     */
    protected String delete(int index) {
        return tasks.remove(index - 1).toString();
    }

    protected void saveToFile(Path path) {
        SaveList.saveListToFile(path, tasks);
    }

    protected String findTasksWithKeyword(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        CharSequence keywordCharSeq = new StringBuffer(keyword.toLowerCase());

        for (Task task : tasks) {
            // Use the task's description for a case insensitve comparison (all lower case)
            String taskDescription = task.getDescription().toLowerCase(); 
            if (! taskDescription.contains(keywordCharSeq)){
                continue;
            }
            matchingTasks.add(task);
        }

        return listToString(matchingTasks);
    }

    private String listToString(ArrayList<Task> list) {
        String listString = "";

        for (int i = 1; i <= list.size(); i++) {
            Task task = list.get(i - 1);
            listString += i + ". "
                    + task.toString() + "\n";
        }
        return listString;
    }

    @Override
    public String toString() {

        String result = listToString(tasks);

        result += String.format("Now you have %s tasks in the list.", tasks.size());

        return result;
    }


}