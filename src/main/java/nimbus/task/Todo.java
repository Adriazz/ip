package nimbus.task;

public class Todo extends Task {

    public Todo(String name) {
        super(name, TaskType.TODO);
    }

    @Override
    public String toFileString() {
        return super.toFileString();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}