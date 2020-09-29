import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;
import java.nio.file.Files;
import java.io.IOException;


public class RetrieveList {
    private static int TASK_TYPE_INDEX = 1;
    private static int TASK_STATUS_INDEX = 4;
    private static int TASK_DESCRIPTION_INDEX = 7;
    
    public static TaskManager retrieveList() {
        try {
            String home = System.getProperty("user.home");
            Path path = Paths.get(home, "duke-data.txt");
            return parseTxt(path);
        } catch (InvalidPathException e) {
            Output.printError("Seems like this is your first time using Duke.");
            return new TaskManager();
        }
    }

    private static TaskManager parseTxt(Path path) {
        TaskList tasks = new TaskList();
        try {
            Files.lines(path).forEachOrdered(line -> {
                char key = line.charAt(TASK_TYPE_INDEX);
                Character statusChar = line.charAt(TASK_STATUS_INDEX);
                String description = line.substring(TASK_DESCRIPTION_INDEX);
                
                boolean status = false;
                if (statusChar.equals('\u2713')) {
                    status = true;
                }

                switch (key) {
                    case 'T':
                        addTodo(tasks, description, status);
                        break;
                    case 'D':
                        addDeadline(tasks, description, status);
                        break;
                    case 'E':
                        addEvent(tasks, description, status);
                }

            });
            return new TaskManager(tasks);
        } catch (IOException e) {
            return new TaskManager();
        }

    }

    private static void addTodo(TaskList tasks, String description, boolean status) {
        tasks.addTodo(description.strip(), status);
    }

    private static void addDeadline(TaskList tasks, String description, boolean status) {
        String cleanString = description.replace(')', ' ').replace('(', ' ').replaceFirst("by", " ");
        String[] inputs = cleanString.split(":", 2);
        tasks.addDeadline(inputs[0].strip(), inputs[1].strip(), status);
    }

    private static void addEvent(TaskList tasks, String description, boolean status) {
        // dev note: "repeated code"
        String cleanString = description.replace(')', ' ').replace('(', ' ').replaceFirst("at", " ");
        String[] inputs = cleanString.split(":", 2);
        tasks.addEvent(inputs[0].strip(), inputs[1].strip(), status);
    }

}
