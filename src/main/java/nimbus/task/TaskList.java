package nimbus.task;

import java.util.ArrayList;
import java.util.List;

import nimbus.exception.NimbusException;

public class TaskList {

    private ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList object.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList object from the provided list of Tasks.
     * 
     * @param tasks the list of tasks.
     */
    public TaskList(List<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    /**
     * Adds a task to the list of tasks.
     * 
     * @param task The task to add.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Returns the task at the given index.
     * 
     * @param index Index of the task in the list.
     * @return The task at the index.
     * @throws NimbusException If there is no task at the specified index.
     */
    public Task getTask(int index) throws NimbusException {
        if (index < 0 || index >= tasks.size()) {
            throw new NimbusException("Invalid task index.");
        }
        return tasks.get(index);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    /**
     * Removes and returns the task at the given index.
     * 
     * @param index The index of the task.
     * @return The removed task.
     * @throws NimbusException If there is no task at the specified index.
     */
    public Task removeTask(int index) throws NimbusException {
        if (index < 0 || index >= tasks.size()) {
            throw new NimbusException("Invalid task index.");
        }
        return tasks.remove(index);
    }

    /**
     * Marks the task at the index as completed.
     * 
     * @param index The index of the task.
     * @return The completed task.
     * @throws NimbusException If the task is already completed or if there is no task at that index.
     */
    public Task markTask(int index) throws NimbusException {
        if (index < 0 || index >= tasks.size()) {
            throw new NimbusException("Invalid task index.");
        }
        Task task = tasks.get(index);
        if (task.isDone()) {
            throw new NimbusException("You have already completed the task!");
        }
        task.markAsDone();
        return task;
    }

    /**
     * Unmarks the task as incomplete and returns it.
     * 
     * @param index The index of the task.
     * @return The unmarked task.
     * @throws NimbusException If the task is already incomplete or if there is no task at that index.
     */
    public Task unmarkTask(int index) throws NimbusException {
        if (index < 0 || index >= tasks.size()) {
            throw new NimbusException("Invalid task index.");
        }
        Task task = tasks.get(index);
        if (!task.isDone()) {
            throw new NimbusException("Your task is already incomplete!");
        }
        task.unmarkAsDone();
        return task;
    }

    /**
     * Returns the size of the task list
     */
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
