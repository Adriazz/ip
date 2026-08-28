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

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showWelcome() {
        System.out.println(horizontalLine);
        System.out.println(banner);
        System.out.println("Hello! I'm Nimbus.");
        System.out.println("What can I do for you?");
        System.out.println(horizontalLine);
    }

    public void showExitMessage() {
        System.out.println(horizontalLine);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(horizontalLine);
    }

    public void printTaskList(TaskList taskList) {
        System.out.println(horizontalLine);
        System.out.println("Here are the tasks in your list:");
        System.out.print(taskList.toString());
        System.out.println(horizontalLine);
    }

    public void printAddTask(Task task, TaskList taskList) {
        System.out.println(horizontalLine);
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
        printTaskSize(taskList);
        System.out.println(horizontalLine);
    }

    public void printDeleteTask(Task task, TaskList taskList) {
        System.out.println(horizontalLine);
        System.out.println("Noted. I've removed this task:");
        System.out.println(task.toString());
        printTaskSize(taskList);
        System.out.println(horizontalLine);
    }

    public void printMarkTask(Task task) {
        System.out.println(horizontalLine);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task.toString());
        System.out.println(horizontalLine);
    }

    public void printUnmarkTask(Task task) {
        System.out.println(horizontalLine);
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(task.toString());
        System.out.println(horizontalLine);
    }

    public void printTaskSize(TaskList taskList) {
        System.out.println("Now you have " + taskList.getSize() + " tasks in the list.");
    }

    public void showTasksLoaded(int taskCount) {
        System.out.println(horizontalLine);
        System.out.println("Successfully loaded " + taskCount + " tasks from file.");
        System.out.println(horizontalLine);
    }

    public void showTasksSaved(int taskCount) {
        System.out.println(horizontalLine);
        System.out.println("Successfully saved " + taskCount + " tasks to file.");
        System.out.println(horizontalLine);
    }

    public void printError(NimbusException e) {
        System.out.println(horizontalLine);
        System.out.println(e.getMessage());
        System.out.println(horizontalLine);
    }
}
