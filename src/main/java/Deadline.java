public class Deadline extends Task {

    private final String by;

    public Deadline(String name, String by) {
        super(name, TaskType.DEADLINE);
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toFileString() {
        return super.toFileString() + "|" + by;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + by + ")";
    }
}