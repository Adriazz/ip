public class Event extends Task {

    private final String from;
    private final String to;

    public Event(String name, String from, String to) {
        super(name, TaskType.EVENT);
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toFileString() {
        return super.toFileString() + "|" + from + "|" + to;
    }

    @Override
    public String toString() {
        return super.toString() + " (from: " + from + " to: " + to + ")";
    }
}