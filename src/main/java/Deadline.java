public class Deadline extends Task {
    private String deadline;
    
    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    public String getBy() {
        return this.deadline;
    }

    public void setBy(String newDeadline) {
        this.deadline = newDeadline;
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), this.deadline);
    }
}