import java.util.Scanner;


public class Duke {
    /**
     * Main method which handles initialisation and closing interactions.
     * @param args
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Output.introduceDuke();
        Output.greetUser();
        

        scan.close();
        Output.byeUser();
    }

    private static void run() {
        TaskManager manager = RetrieveList.retrieveList(); // new TaskManager();
        
        while(manager.parseInput(scan.nextLine())) {
            Output.printBreak();
            System.out.println("\n");
        }             
    }
}
