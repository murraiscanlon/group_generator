import java.util.Scanner;

public class View {
    static Scanner scanner = new Scanner(System.in);

    public static String[] menu(){
        String[] option = new String[2];

        System.out.println("Enter a course name: (gte, stem lab, or adv robo)");
        option[0] = scanner.nextLine();
        System.out.println("Enter a section number: (1, 3, or 4)");
        option[1] = scanner.nextLine();



        return option;
    }

    public static String continueOrQuit(){
        System.out.println("Would you like to quit? (y/n): ");
        String continueOrQuit = scanner.nextLine();

        return continueOrQuit;
    }



}
