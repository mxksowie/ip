public class Event extends DatedTask {

    
    public Event(String description, String event) {
        super(description, event);
    }

    @Override
    public String toString() {
        return String.format("[E]%s (at: %s)", super.toString(), 
                super.getDateOrDetail());
    }

}