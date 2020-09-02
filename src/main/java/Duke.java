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
        
        TaskManager manager = new TaskManager();
        
        while(manager.parseInput(scan.nextLine())) {
            printBreak();
            System.out.println("\n");
        }             

        scan.close();
        byeUser();
        
    }

    /**
     * Prints a standard breakline meant to break up sections of text
     * Dev note: Might have cyclic dependencies because of printBreak usage
     */
    public static void printBreak() {
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
}
