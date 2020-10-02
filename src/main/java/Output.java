public class Output {

    /**
     * Prints a standard breakline meant to break up sections of text
     */
    public static void printBreak() {
        System.out.println("  ________________________________________________________");
    }
    
    /**
     * Prints out the logo to introduce the program
     */
    public static void introduceDuke() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printBreak();   
    }

    /**
     * Standard greeting that indicates program start / ready to recieve user input
     */
    public static void greetUser() {
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
        printBreak();
    }

    /**
     * Standard farewell that marks end of program
     */
    public static void byeUser() {
        printBreak();
        System.out.println(" Bye. Hope to see you again soon!");
        printBreak();

    }

    /**
     * Informs user of a caught error by providing a message with proper indentation/formating.
     */
    public static void printError(String s) {
        Output.printBreak();
        System.out.println("    " + s);
    }

    public static void printEmptyLine() {
        System.out.println("\n");
    }

    protected static void printDeletedTask(String taskString) {
        System.out.println(String.format("  Noted. I've removed this task: \n    %s", taskString));
    }

    protected static void printAddedTask(String taskString) {
        System.out.println("Got it. I've added this task :");
        System.out.println("   " + taskString);
    }

    protected static void printCompletedTask(String taskString) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("     " + taskString);
    }

    protected static void printTaskList (String listString) {
        System.out.println("Here are the tasks in your list:");
        System.out.println(listString);
    }

    protected static void printMatches (String matchList) {
        printBreak();
        if (matchList.length() == 0) {
            System.out.println("  Sorry! I couldn't find any matches.");
            return;
        }

        System.out.println("Here are the matching tasks in your list:");
        System.out.println(matchList);
    }

    protected static void printTaskCount(int count) {
        System.out.println(String.format("  Now you have %s tasks in the list.", count));
    }
}
