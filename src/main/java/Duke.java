import java.util.Scanner;


public class Duke {
    /**
     * Main method which (strictly) handles IO
     * @param args
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        introduceDuke();
        greetUser();
        
        TaskList tasks = new TaskList();
        
        while(parseInput(scan.nextLine(), tasks)) {
            printBreak();
            System.out.println("\n");
        }             

        scan.close();
        byeUser();
        
    }

    /**
     * Prints a standard breakline meant to break up sections of text
     */
    private static void printBreak() {
        System.out.println("  ________________________________________________________");
    }

    /**
     * Prints out the logo to introduce the program
     */
    private static void introduceDuke() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printBreak();   
    }

    private static void greetUser() {
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
        printBreak();
    }

    private static void byeUser() {
        printBreak();
        System.out.println(" Bye. Hope to see you again soon!");
        printBreak();

    }

    /**
     * Echos the String input while checking for "bye"s
     * @param userInput
     * @return
     */
    private static boolean echo(String userInput) {
        if (userInput.equals("bye")) {
            return false;
        }
        printBreak();
        System.out.println("   " + userInput);
        printBreak();
        return true;
    }


    private static boolean parseInput(String userInput, TaskList tasks) {
        String[] inputs = userInput.split(" ");

        String keyword = inputs[0];

        switch (keyword) {
            case "bye":
                return false;
            case "list":
                printBreak();
                System.out.println(tasks);
                return true;
            case "done":
                // change it
                String msg = tasks.markComplete(Integer.parseInt(inputs[1]));
                printBreak();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("     " + msg);
                return true;
        }

        /** 
        if (userInput.equals("bye")) {
            return false;
        }
        
        if (userInput.equals("list")) {
            printBreak();
            System.out.println(tasks);
            return true;
        }
        */

        printBreak();
        System.out.println("   " + tasks.addTask(userInput));

        return true;
    }
}
