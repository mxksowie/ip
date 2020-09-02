import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public TaskList(String description) {
        this.tasks = new ArrayList<Task>();
        this.tasks.add(new Task(description));
    }

    protected String addTask(String description) {

        this.tasks.add(new Task(description));
        
        return String.format("added: %s", description);
    }

    protected String addTodo(String description) {
        Task task = new Todo(description);
        this.tasks.add(task);
        
        return task.toString();
    }

    protected String addDeadline(String description, String deadline) {
        Task task = new Deadline(description, deadline);
        this.tasks.add(task);
        
        return task.toString();
    }

    
    protected String addEvent(String description, String detail) {
        Task task = new Event(description, detail);
        this.tasks.add(task);
        
        return task.toString();
    }

    protected String markComplete(int index) {
        index = index - 1; // start from 0 instead of 1
        Task task = tasks.get(index);
        task.markAsComplete();
        return (task.toString());
    }

    protected int size() {
        return this.tasks.size();
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