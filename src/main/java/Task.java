public class Task {
    protected String description;
    private boolean isComplete;

    public Task(String description) {
        this.description = description;
        this.isComplete = false;
    }

    @Override
    public String toString() {
        //Subject to change; return string rep for printing purposes
        return this.getCompletionStatusIcon() + " " + this.description; 
    }

    protected boolean markAsComplete() {
        this.isComplete = true;
        return this.isComplete;
    }

    protected boolean checkIsComplete() {
        return this.isComplete;
    }

    private String getCompletionStatusIcon() {
        return (isComplete ? "[\u2713]" : "[\u2718]");
    }


}