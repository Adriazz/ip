package nimbus.ui;

import java.util.Scanner;

import nimbus.exception.NimbusException;
import nimbus.task.Task;
import nimbus.task.TaskList;

public class Ui {

    public static String horizontalLine = "____________________________________________________________";
    public static String banner = "#   #  #####  #   #  ####   #   #   ####\n"
            + "##  #    #    ## ##  #   #  #   #  #     \n"
            + "# # #    #    # # #  ####   #   #   ###  \n"
            + "#  ##    #    #   #  #   #  #   #     #  \n"
            + "#   #  #####  #   #  ####    ###   ####  \n";
    private final Scanner scanner;

    /**
     * Constructs a Ui that reads user input from standard input.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads a single line of input entered by the user.
     *
     * @return The line of text entered by the user.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Prints the welcome banner and greeting shown at startup.
     */
    public void showWelcome() {
        System.out.println(horizontalLine);
        System.out.println(banner);
        System.out.println("Hello! I'm Nimbus.");
        System.out.println("What can I do for you?");
        System.out.println(horizontalLine);
    }

    /**
     * Prints the farewell message shown when the application exits.
     */
    public void showExitMessage() {
        System.out.println(horizontalLine);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(horizontalLine);
    }

    /**
     * Prints every task currently in the given task list.
     *
     * @param taskList The task list to display.
     */
    public void printTaskList(TaskList taskList) {
        System.out.println(horizontalLine);
        System.out.println("Here are the tasks in your list:");
        System.out.print(taskList.toString());
        System.out.println(horizontalLine);
    }

    /**
     * Prints confirmation that a task was added, followed by the updated task
     * count.
     *
     * @param task     The task that was added.
     * @param taskList The task list the task was added to.
     */
    public void printAddTask(Task task, TaskList taskList) {
        System.out.println(horizontalLine);
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
        printTaskSize(taskList);
        System.out.println(horizontalLine);
    }

    /**
     * Prints confirmation that a task was deleted, followed by the updated task
     * count.
     *
     * @param task     The task that was removed.
     * @param taskList The task list the task was removed from.
     */
    public void printDeleteTask(Task task, TaskList taskList) {
        System.out.println(horizontalLine);
        System.out.println("Noted. I've removed this task:");
        System.out.println(task.toString());
        printTaskSize(taskList);
        System.out.println(horizontalLine);
    }

    /**
     * Prints confirmation that a task was marked as done.
     *
     * @param task The task that was marked done.
     */
    public void printMarkTask(Task task) {
        System.out.println(horizontalLine);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task.toString());
        System.out.println(horizontalLine);
    }

    /**
     * Prints confirmation that a task was marked as not done.
     *
     * @param task The task that was marked not done.
     */
    public void printUnmarkTask(Task task) {
        System.out.println(horizontalLine);
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(task.toString());
        System.out.println(horizontalLine);
    }

    /**
     * Prints the current number of tasks in the given task list.
     *
     * @param taskList The task list whose size is printed.
     */
    public void printTaskSize(TaskList taskList) {
        System.out.println("Now you have " + taskList.getSize() + " tasks in the list.");
    }

    /**
     * Prints confirmation that tasks were successfully loaded from file.
     *
     * @param taskCount The number of tasks loaded.
     */
    public void showTasksLoaded(int taskCount) {
        System.out.println(horizontalLine);
        System.out.println("Successfully loaded " + taskCount + " tasks from file.");
        System.out.println(horizontalLine);
    }

    /**
     * Prints confirmation that tasks were successfully saved to file.
     *
     * @param taskCount The number of tasks saved.
     */
    public void showTasksSaved(int taskCount) {
        System.out.println(horizontalLine);
        System.out.println("Successfully saved " + taskCount + " tasks to file.");
        System.out.println(horizontalLine);
    }

    /**
     * Prints the error message carried by the given exception.
     *
     * @param e The exception whose message is displayed to the user.
     */
    public void printError(NimbusException e) {
        System.out.println(horizontalLine);
        System.out.println(e.getMessage());
        System.out.println(horizontalLine);
    }
}
