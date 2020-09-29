import java.util.Scanner;


public class Duke {
    /**
     * Main method which handles initial and closing interactions.
     * @param args
     */
    public static void main(String[] args) {

        Output.introduceDuke();
        Output.greetUser();
        
        run();

        Output.byeUser();
    }


    /**
     *  Method containing the continuous while loop that parses user inputs and handles interactions accordingly
     *  Also initialises the task list. Attempts to retrieve a stored task list, if any.
     */
    private static void run() {

        Scanner scan = new Scanner(System.in);

        TaskManager manager = RetrieveList.retrieveList();
        
        while(manager.parseInput(scan.nextLine())) {
            Output.printBreak();
            Output.printEmptyLine();
        }

        scan.close();
    }

    
    
}
