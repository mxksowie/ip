public class Deadline extends DatedTask {

    
    public Deadline(String description, String deadline) {
        super(description, deadline);

    }

    @Override
    public String toString() {
        return String.format("[D]%s (at: %s)", super.toString(), 
                super.getDateOrDetail());
    }
}