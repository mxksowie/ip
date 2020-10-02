import java.nio.file.Path;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Helper class to TaskList.
 * Saves the TaskList (which is an ArrayList) to a file.
 */
public class SaveList {
    /**
     * Writes tasks in their toString() representation directly to the text file specified in path.
     * @param path A path pointing to the text file in the system.
     * @param list
     */
    protected static void saveListToFile(Path path, ArrayList<Task> list) {
        try {
            FileWriter writer = new FileWriter(path.toString());
            list.forEach(x -> {
                try {
                    writer.write(x.toString() + "\n");
                } catch (IOException e) {
                    Output.printError("A task could not be saved: " + x.toString());
                }
            });
            writer.close();
        } catch (IOException e) {
            Output.printError("Not able to open or close the filewriter");
        }
    }

}
