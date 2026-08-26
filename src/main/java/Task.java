public abstract class Task {

    private String name;
    private boolean isDone;
    private TaskType type;

    public Task(String name, TaskType type) {
        this.name = name;
        this.type = type;
        this.isDone = false;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        this.isDone = true;
    }
    
    public void unmarkAsDone() {
        this.isDone = false;
    }

    public String toFileString() {
        return type.getType() + "|" + (isDone ? "1" : "0") + "|" + name;
    }

    @Override
    public String toString() {
        return "[" + type.getType() + "] " + (isDone ? "[X] " : "[ ] ") + name;
    }

    public static Task fromFileString(String fileString) throws NimbusException {
        try {
            String[] parts = fileString.split("\\|");
            TaskType type = TaskType.fromString(parts[0]);
            boolean isDone = parts[1].equals("1");
            String name = parts[2];

            Task task;
            switch (type) {
                case TODO:
                    task = new Todo(name);
                    break;
                case DEADLINE:
                    String by = parts[3];
                    task = new Deadline(name, by);
                    break;
                case EVENT:
                    String from = parts[3];
                    String to = parts[4];
                    task = new Event(name, from, to);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown task type: " + type);
            }

            if (isDone) {
                task.markAsDone();
            }

            return task;
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            throw new NimbusException("Unable to parse task from file. Recreating file...");
        }
        
    }
}