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

    public String addTask(String description) {

        this.tasks.add(new Task(description));
        
        return String.format("added: %s", description);
    }

    @Override
    public String toString() {
        String result = "";
        //for (Task task : tasks) {
        for (int i = 0; i < tasks.size(); i++){
            Task task = tasks.get(i);
            result += i + ". " + task.toString() + "\n";
        }
        return result;
    }
}