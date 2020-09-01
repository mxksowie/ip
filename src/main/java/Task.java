public class Task {
    protected String description;
    private boolean isComplete;

    public Task(String description) {
        this.description = description;
        this.isComplete = false;
    }

    @Override
    public String toString() {
        return this.description; //Subject to change; return string rep for printing purposes
    }

    protected boolean markAsComplete() {
        this.isComplete = true;
        return this.isComplete;
    }
}