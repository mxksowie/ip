import java.nio.file.Path;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class SaveList {
    
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
