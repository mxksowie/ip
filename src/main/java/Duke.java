public class Duke {
    /**
     * Main method which (strictly) handles IO
     * @param args
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        printBreak();
        greetUser();

        printBreak();
        byeUser();
        
        printBreak();


    }

    /**
     * Prints a standard breakline meant to break up sections of text
     */
    private static void printBreak() {
        System.out.println("____________________________________________________________");
    }

    private static void greetUser() {
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
    }

    private static void byeUser() {
        System.out.println(" Bye. Hope to see you again soon!");
    }
}
