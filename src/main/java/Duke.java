import java.util.Scanner;


public class Duke {
    /**
     * Main method which (strictly) handles IO
     * @param args
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Output.introduceDuke();
        Output.greetUser();
        
        TaskManager manager = new TaskManager();
        
        while(manager.parseInput(scan.nextLine())) {
            Output.printBreak();
            System.out.println("\n");
        }             
        scan.close();
        Output.byeUser();
    }
}
