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

    public static void greetUser() {
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
        printBreak();
    }

    public static void byeUser() {
        printBreak();
        System.out.println(" Bye. Hope to see you again soon!");
        printBreak();

    }

    public static void printError(String s) {
        Output.printBreak();
        System.out.println("    " + s);
    }
}
