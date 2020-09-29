public class Event extends Task {
    private String event;
    
    public Event(String description, String event) {
        super(description);
        this.event = event;
    }

    public String getBy() {
        return this.event;
    }

    public void setBy(String newEvent) {
        this.event = newEvent;
    }

    @Override
    public String toString() {
        return String.format("[E]%s (at: %s)", super.toString(), this.event);
    }

}