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
            System.out.println(horizontalLine);

            if (input.equalsIgnoreCase("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < index; i++) {
                    System.out.println((i + 1) + "." + list[i]);
                }
            } else if (input.toLowerCase().startsWith("mark ")) {
                int taskNumber = Integer.parseInt(input.substring(5).trim());
                Task task = list[taskNumber - 1];
                task.markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + task);
            } else if (input.toLowerCase().startsWith("unmark ")) {
                int taskNumber = Integer.parseInt(input.substring(7).trim());
                Task task = list[taskNumber - 1];
                task.unmarkAsDone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  " + task);
            } else {
                list[index++] = new Task(input);
                System.out.println("added: " + input);
            }

            System.out.println(horizontalLine);
            input = scanner.nextLine();
        }

        System.out.println(horizontalLine);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(horizontalLine);
        scanner.close();
    }
}