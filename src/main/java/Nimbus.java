import java.util.Scanner;
import java.util.ArrayList;

public class Nimbus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String horizontalLine = "____________________________________________________________";
        String banner =
                  "#   #  #####  #   #  ####   #   #   ####\n"
                + "##  #    #    ## ##  #   #  #   #  #     \n"
                + "# # #    #    # # #  ####   #   #   ###  \n"
                + "#  ##    #    #   #  #   #  #   #     #  \n"
                + "#   #  #####  #   #  ####    ###   ####  \n";

        System.out.println(horizontalLine);
        System.out.println(banner);
        System.out.println("Hello! I'm Nimbus.");
        System.out.println("What can I do for you?");
        System.out.println(horizontalLine);
        ArrayList<Task> taskList = new ArrayList<>();
        String input = scanner.nextLine();
        Command command = parseCommand(input);

        while (!input.equalsIgnoreCase("bye")) {
            try{

                System.out.println(horizontalLine);
                switch (command) {
                    case LIST -> {
                        System.out.println("Here are the tasks in your list:");
                        for (int i = 0; i < taskList.size(); i++) {
                            System.out.println((i + 1) + "." + taskList.get(i));
                        }
                    }
                    case MARK -> {
                        int taskNumber = Integer.parseInt(input.substring(5).trim());
                        if (taskNumber < 1 || taskNumber > taskList.size()) {
                            throw new NimbusException("Invalid task number.");
                        }
                        Task task = taskList.get(taskNumber - 1);
                        task.markAsDone();
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println("  " + task);
                    }
                    case UNMARK -> {
                        int taskNumber = Integer.parseInt(input.substring(7).trim());
                        if (taskNumber < 1 || taskNumber > taskList.size()) {
                            throw new NimbusException("Invalid task number.");
                        }
                        Task task = taskList.get(taskNumber - 1);
                        task.unmarkAsDone();
                        System.out.println("OK, I've marked this task as not done yet:");
                        System.out.println("  " + task);
                    }
                    case DELETE -> {
                        int taskNumber = Integer.parseInt(input.substring(7).trim());
                        if (taskNumber < 1 || taskNumber > taskList.size()) {
                            throw new NimbusException("Invalid task number.");
                        }
                        Task task = taskList.remove(taskNumber - 1);
                        System.out.println("Noted. I've removed this task:");
                        System.out.println("  " + task);
                        printTaskNumber(taskList);
                    }
                    case TODO -> {
                        String name = input.substring(5).trim();
                        if (name.isEmpty()) {
                            throw new NimbusException("The description of a todo cannot be empty.");
                        }
                        Task newTask = new Todo(name);
                        addTask(taskList, newTask);
                    }
                    case DEADLINE -> {
                        String remainder = input.substring(9).trim();
                        String[] parts = remainder.split("/by", 2);
                        String name = parts[0].trim();
                        if (name.isEmpty()) {
                            throw new NimbusException("The description of a deadline cannot be empty.");
                        }
                        if (parts.length < 2) {
                            throw new NimbusException("The deadline must have a due date.");
                        }
                        String by = parts[1].trim();
                        Task newTask = new Deadline(name, by);
                        addTask(taskList, newTask);
                    }
                    case EVENT -> {
                        String remainder = input.substring(6).trim();
                        String[] fromSplit = remainder.split("/from", 2);
                        String name = fromSplit[0].trim();
                        if (name.isEmpty()) {
                            throw new NimbusException("The description of an event cannot be empty.");
                        }
                        if (fromSplit.length < 2) {
                            throw new NimbusException("The event must have a start time.");
                        }
                        String[] toSplit = fromSplit[1].split("/to", 2);
                        if (toSplit.length < 2) {
                            throw new NimbusException("The event must have an end time.");
                        }
                        String from = toSplit[0].trim();
                        String to = toSplit[1].trim();
                        Task newTask = new Event(name, from, to);
                        addTask(taskList, newTask);
                    }
                    case UNKNOWN -> throw new NimbusException("I'm sorry, but I don't know what that means.");
                    case BYE -> { } // unreachable — loop exits on BYE before this runs
                }
            } catch (NimbusException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println(horizontalLine);
                input = scanner.nextLine();
                command = parseCommand(input);
            }
        }

        System.out.println(horizontalLine);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(horizontalLine);
        scanner.close();
    }

    private static void addTask(ArrayList<Task> taskList, Task newTask) {
        taskList.add(newTask);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTask);
        printTaskNumber(taskList);
    }

    private static void printTaskNumber(ArrayList<Task> taskList) {
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    private static Command parseCommand(String input) {
        String commandWord = input.trim().split(" ", 2)[0].toLowerCase();
        try {
            return Command.valueOf(commandWord.toUpperCase());
        } catch (IllegalArgumentException e) {
            return Command.UNKNOWN;
        }
    }

}