import java.util.Arrays;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;
import java.time.format.DateTimeParseException;

/**
 * Manager class that interprets user commands and executes them.
 */
public class TaskManager {
    private TaskList tasks;
    private int COMMAND_START_INDEX= 1;

    /**
     * Default constructor method that creates a new TaskList.
     * Intended for first time use and when the previous list could not be retrieved.
     */
    public TaskManager() {
        this.tasks = new TaskList();
    }

    /**
     * Constructor method to allow TaskManager to be instantiated with an existing TaskList.
     * Necessary to support loading previously saved lists.
     * @param tasks
     */
    public TaskManager(TaskList tasks) {
        this.tasks = tasks;
    }

    /**
     * Parses the user input for keywords and commands.
     * Calls the relevant methods to manage the list.
     * Also informs user of parsing related errors: unrecognised keyword, not enough inputs, invalid input type.
     * 
     * @param userInput scanned user input
     * @return boolean that informs the while loop if the program should still proceed.
     */
    public boolean parseInput(String userInput) {
        String[] inputs = userInput.split(" ");

        String keyword = inputs[0];

        switch (keyword) {
            case "bye":
                return false;
            case "list":
                listTaskList();
                return true;
            case "save":
                saveTaskList();
                return true;
        }
        
        if (inputs.length == COMMAND_START_INDEX) {
            Output.printError("You need to tell me more about what you want to do.");
            return true;
        }
        
        switch (keyword) {
        case "done":
            try {
                markComplete(Integer.parseInt(inputs[COMMAND_START_INDEX]));
            } catch (NumberFormatException e) {
                Output.printError("You need to provide me with an integer index.");
            }
            return true;
        case "delete":
            try {
                deleteTask(Integer.parseInt(inputs[COMMAND_START_INDEX]));
            } catch (NumberFormatException e) {
                Output.printError("You need to provide me with an integer index.");
            }
            break;
        case "todo":
            addTodo(String.join(" ", Arrays.copyOfRange(inputs, COMMAND_START_INDEX, inputs.length)));
            break;
        case "deadline":
            addDeadline(Arrays.copyOfRange(inputs, COMMAND_START_INDEX, inputs.length));
            break;
        case "event":
            addEvent(Arrays.copyOfRange(inputs, COMMAND_START_INDEX, inputs.length));
            break;

        case "find":
            findTasks(String.join(" ", Arrays.copyOfRange(inputs, COMMAND_START_INDEX, inputs.length)));
            return true;
        case "dated":
            findDated(String.join(" ", Arrays.copyOfRange(inputs, COMMAND_START_INDEX, inputs.length)));
            return true;
        default: 
            Output.printError("Sorry. I don't know what that means");
            return true;
        }

        Output.printTaskCount(tasks.size());
        
        saveTaskList(); // task list is automatically saved without user input of save.

        return true;
    }

    private void findDated(String date) {
        try{
            Output.printMatches(tasks.findTasksWithDate(date));
        } catch (DateTimeParseException e) {
            Output.printError("Sorry, I could not figure out that date. It needs to be in ISO format.");
        }
        
    }

    private void findTasks(String keyword) {
        Output.printMatches(tasks.findTasksWithKeyword(keyword));
    }


    private void deleteTask(int index) {
        try{
            Output.printBreak();
            Output.printDeletedTask(tasks.delete(index));
        } catch (IndexOutOfBoundsException e) {
            Output.printError("I couldn't delete the task at position " + index +
                    "\n   I think you don't have that many tasks in your list.");
        }
        
    }

    /**
     * Saves the tasklist to the user's home directory under duke-data.txt
     * Informs user of error where their home directory is not available.
     */
    private void saveTaskList() {
        try {
            String home = System.getProperty("user.home");
            Path path = Paths.get(home, "duke-data.txt");
            tasks.saveToFile(path);
        } catch (InvalidPathException e) {
            Output.printError("Not able to path the file.");
        }
    }

    private void markComplete(int index) {
        try {
            Output.printBreak();
            Output.printCompletedTask(tasks.markComplete(index));
        } catch (IndexOutOfBoundsException e) {
            Output.printError("I couldn't mark the task at position " + index +
                    "\n   I think you don't have that many tasks in your list.");
        }
    }

    private void listTaskList() {
        Output.printBreak();
        Output.printTaskList(tasks.toString());
    }

    private void addTodo(String userInput) {
        Output.printBreak();
        Output.printAddedTask(tasks.addTodo(userInput));
    }

    private void addEvent(String[] userInput) {
        StringPair taskInfo = splitAtCommand(userInput, "at");
        Output.printBreak();
        Output.printAddedTask(tasks.addEvent(taskInfo.first, taskInfo.second));
    }

    private void addDeadline(String[] userInput) {
        StringPair taskInfo = splitAtCommand(userInput, "by");
        Output.printBreak();
        Output.printAddedTask(tasks.addDeadline(taskInfo.first, taskInfo.second));
    }

    /**
     * Helper method to parse userInput and get the pair of arguments for addDeadline and addEvent.
     * @param userInput
     * @param command the keyword that is used by the command to indicate that a timing/venue is subsequently written.
     * @return
     */
    private StringPair splitAtCommand(String[] userInput, String command) {
        boolean flag = false;
        ArrayList<String> detailWords = new ArrayList<>();
        ArrayList<String> descriptionWords = new ArrayList<>();
        
        for (String input : userInput) {
            if (flag) {
                detailWords.add(input);
                continue;
            }
            if (input.equals("/" + command) || input.equals(command)) {
                flag = true;
                continue;
            }
            descriptionWords.add(input);
        }
        return new StringPair(String.join(" ", descriptionWords), String.join(" ", detailWords));
        
    }



}

