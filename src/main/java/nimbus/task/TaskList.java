package nimbus.task;

import java.util.ArrayList;
import java.util.List;

import nimbus.exception.NimbusException;

public class TaskList {

    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(List<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getTask(int index) throws NimbusException {
        if (index < 0 || index >= tasks.size()) {
            throw new NimbusException("Invalid task index.");
        }
        return tasks.get(index);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public Task removeTask(int index) throws NimbusException {
        if (index < 0 || index >= tasks.size()) {
            throw new NimbusException("Invalid task index.");
        }
        return tasks.remove(index);
    }

    public Task markTask(int index) throws NimbusException {
        if (index < 0 || index >= tasks.size()) {
            throw new NimbusException("Invalid task index.");
        }
        tasks.get(index).markAsDone();
        return tasks.get(index);
    }

    public Task unmarkTask(int index) throws NimbusException {
        if (index < 0 || index >= tasks.size()) {
            throw new NimbusException("Invalid task index.");
        }
        tasks.get(index).unmarkAsDone();
        return tasks.get(index);
    }

    public int getSize() {
        return tasks.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + "." + tasks.get(i).toString() + "\n");
        }
        return sb.toString();
    }
}
