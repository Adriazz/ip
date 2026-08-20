import java.util.Scanner;

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

        Task[] list = new Task[100];
        int index = 0;
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("bye")) {
            try{
                System.out.println(horizontalLine);
                if (input.equalsIgnoreCase("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < index; i++) {
                        System.out.println((i + 1) + "." + list[i]);
                    }
                } else if (input.toLowerCase().startsWith("mark ")) {
                    int taskNumber = Integer.parseInt(input.substring(5).trim());
                    if (taskNumber < 1 || taskNumber > index) {
                        throw new NimbusException("Invalid task number.");
                    }
                    Task task = list[taskNumber - 1];
                    task.markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + task);
                } else if (input.toLowerCase().startsWith("unmark ")) {
                    int taskNumber = Integer.parseInt(input.substring(7).trim());
                    if (taskNumber < 1 || taskNumber > index) {
                        throw new NimbusException("Invalid task number.");
                    }
                    Task task = list[taskNumber - 1];
                    task.unmarkAsDone();
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  " + task);
                } else if (input.toLowerCase().startsWith("todo ")) {
                    String name = input.substring(5).trim();
                    if (name.isEmpty()) {
                        throw new NimbusException("The description of a todo cannot be empty.");
                    }
                    Task newTask = new Todo(name);
                    list[index++] = newTask;
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + newTask);
                    System.out.println("Now you have " + index + " tasks in the list.");
                } else if (input.toLowerCase().startsWith("deadline ")) {
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
                    list[index++] = newTask;
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + newTask);
                    System.out.println("Now you have " + index + " tasks in the list.");
                } else if (input.toLowerCase().startsWith("event ")) {
                    String remainder = input.substring(6).trim();
                    String[] fromSplit = remainder.split("/from", 2);
                    String name = fromSplit[0].trim();
                    if (name.isEmpty()) {
                        throw new NimbusException("The description of an event cannot be empty.");
                    }
                    if(fromSplit.length < 2) {
                        throw new NimbusException("The event must have a start time.");
                    }
                    String[] toSplit = fromSplit[1].split("/to", 2);
                    if (toSplit.length < 2) {
                        throw new NimbusException("The event must have an end time.");
                    }
                    String from = toSplit[0].trim();
                    String to = toSplit[1].trim();
                    Task newTask = new Event(name, from, to);
                    list[index++] = newTask;
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + newTask);
                    System.out.println("Now you have " + index + " tasks in the list.");
                } else {
                    throw new NimbusException("I'm sorry, but I don't know what that means.");
                }
            } catch (NimbusException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println(horizontalLine);
                input = scanner.nextLine();
            }
        }

        System.out.println(horizontalLine);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(horizontalLine);
        scanner.close();
    }
}