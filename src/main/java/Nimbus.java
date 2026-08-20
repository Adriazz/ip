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

        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("bye")) {
            System.out.println(horizontalLine);
            System.out.println(input);
            System.out.println(horizontalLine);
            input = scanner.nextLine();
        }
        System.out.println(horizontalLine);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(horizontalLine);
        scanner.close();
    }
}