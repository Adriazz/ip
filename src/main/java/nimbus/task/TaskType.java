package nimbus.task;
public enum TaskType {
    TODO("T"), DEADLINE("D"), EVENT("E");

    public final String type;

    TaskType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static TaskType fromString(String type) {
        for (TaskType taskType : TaskType.values()) {
            if (taskType.type.equals(type)) {
                return taskType;
            }
        }
        throw new IllegalArgumentException("Invalid task type: " + type);
    }
}
