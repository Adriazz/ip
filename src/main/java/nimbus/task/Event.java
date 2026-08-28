package nimbus.task;

import java.time.LocalDate;

public class Event extends Task {

    private final LocalDate from;
    private final LocalDate to;

    public Event(String name, LocalDate from, LocalDate to) {
        super(name, TaskType.EVENT);
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from.format(OUTPUT_FORMAT);
    }

    public String getTo() {
        return to.format(OUTPUT_FORMAT);
    }

    @Override
    public String toFileString() {
        return super.toFileString() + "|" + from.toString() + "|" + to.toString();
    }

    @Override
    public String toString() {
        return super.toString() + " (from: " + getFrom() + " to: " + getTo() + ")";
    }
}
