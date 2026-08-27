import java.time.LocalDate;

public class Deadline extends Task {

    private final LocalDate by;

    public Deadline(String name, LocalDate by) {
        super(name, TaskType.DEADLINE);
        this.by = by;
    }

    public String getBy() {
        return by.format(OUTPUT_FORMAT);
    }

    @Override
    public String toFileString() {
        return super.toFileString() + "|" + getBy();
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + getBy() + ")";
    }
}