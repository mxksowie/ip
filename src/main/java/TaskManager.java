import java.util.Arrays;
import java.util.ArrayList;

public class TaskManager {
    private TaskList tasks;

    public TaskManager() {
        this.tasks = new TaskList();
    }

    /**
     * Parses the user input for keywords and commands.
     * Calls the relevant methods to manage the list and print outputs to the user.
     * @param userInput
     * @return
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
        }
        
        if (inputs.length == 1) {
            Output.printError("You need to tell me more about what you want to do.");
            return true;
        }
        
        switch (keyword) {
            case "done":
                try {
                    markComplete(Integer.parseInt(inputs[1]));
                } catch (NumberFormatException e) {
                    Output.printError("You need to provide me with an integer index.");
                }
                return true;
            case "delete":
                try {
                    deleteTask(Integer.parseInt(inputs[1]));
                } catch (NumberFormatException e) {
                    Output.printError("You need to provide me with an integer index.");
                }
                break;
            case "todo":
                addTodo(String.join(" ", Arrays.copyOfRange(inputs, 1, inputs.length)));
                break;
            case "deadline":
                addDeadline(Arrays.copyOfRange(inputs, 1, inputs.length));
                break;
            case "event":
                addEvent(Arrays.copyOfRange(inputs, 1, inputs.length));
                break;
            default: 
                Output.printError("Sorry. I don't know what that means");
                return true;
        }

        System.out.println(String.format("  Now you have %s tasks in the list.", tasks.size()));

        return true;
    }
    
    private void deleteTask(int i) {
        try{
            String task = tasks.delete(i);
            Output.printBreak();
            System.out.println(String.format("  Noted. I've removed this task: \n    %s", task));
        } catch (IndexOutOfBoundsException e) {
            Output.printError("I couldn't delete the task at position " + i +
                    "\n   I think you don't have that many tasks in your list.");
        }
        
    }

    private void markComplete(int i) {
        try {
            String msg = tasks.markComplete(i);
            Output.printBreak();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("     " + msg);
        } catch (IndexOutOfBoundsException e) {
            Output.printError("I couldn't mark the task at position " + i +
                    "\n   I think you don't have that many tasks in your list.");
        }
    }

    private void listTaskList() {
        Output.printBreak();
        System.out.println("Here are the tasks in your list:");
        System.out.println(tasks);
    }

    private void addTodo(String userInput) {
        Output.printBreak();
        System.out.println("Got it. I've added this task :");
        System.out.println("   " + tasks.addTodo(userInput));
    }

    private void addEvent(String[] userInput) {
        boolean flag = false;
        ArrayList<String> detailWords = new ArrayList<>();
        ArrayList<String> descriptionWords = new ArrayList<>();
        
        for (String input : userInput) {
            if (flag) {
                detailWords.add(input);
                continue;
            }
            if (input.equals("/at") || input.equals("at")){
                flag = true;
                continue;
            }
            descriptionWords.add(input);
        }

        Output.printBreak();
        System.out.println("Got it. I've added this task :");
        System.out.println("   " + tasks.addEvent(String.join(" ", descriptionWords),
                String.join(" ", detailWords)));
    }

    private void addDeadline(String[] userInput) {
        boolean flag = false;
        ArrayList<String> deadlineWords = new ArrayList<>();
        ArrayList<String> descriptionWords = new ArrayList<>();
        
        for (String input : userInput) {
            if (flag) {
                deadlineWords.add(input);
                continue;
            }
            if (input.equals("/by") || input.equals("by")) {
                flag = true;
                continue;
            }
            descriptionWords.add(input);
        }
        Output.printBreak();
        System.out.println("Got it. I've added this task :");
        System.out.println("   " + tasks.addDeadline(String.join(" ", descriptionWords),
                String.join(" ", deadlineWords)));
    }


}

