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
        String[] list = new String[100];
        int index = 0;
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("bye")) {
            if (input.equalsIgnoreCase("list")) {
                System.out.println(horizontalLine);
                for (int i = 0; i < index; i++) {
                    System.out.println((i + 1) + ". " + list[i]);
                }
                System.out.println(horizontalLine);
            } else {
                list[index++] = input;
                System.out.println(horizontalLine);
                System.out.println("added: " + input);
                System.out.println(horizontalLine);
            }
            input = scanner.nextLine();
        }
        System.out.println(horizontalLine);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(horizontalLine);
        scanner.close();
    }
}