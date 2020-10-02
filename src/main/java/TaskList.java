import java.util.ArrayList;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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

    /**
     * Searches the task list for (dated) tasks that match the date queried by the user
     * @param dateString ISO formated date as a string
     * @return list of matched tasks as a string
     * @throws DateTimeParseException exception thrown as is.
     */
    protected String findTasksWithDate(String dateString) throws DateTimeParseException {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        CharSequence dateCharSeq = new StringBuffer(dateString.strip());
        
        try {
            LocalDate localDate = LocalDate.parse(dateCharSeq);
            for (Task task : tasks) {
                if (!(task instanceof DatedTask)) {
                    continue;
                }
                DatedTask datedTask = (DatedTask) task;
                if (datedTask.getBy().isEmpty()) {
                    continue;
                }
                if (!(localDate.equals(datedTask.getBy().get()))) {
                    continue;
                }
                matchingTasks.add(task);
            }
        } catch (DateTimeParseException e) {
            throw e;
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