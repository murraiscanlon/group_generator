import java.util.Scanner;

public class View {
    static Scanner scanner = new Scanner(System.in);

    public static String[] menu(){
        String[] option = new String[3];

        System.out.print("Enter a course name (gte, stem lab, or adv robo): ");
        option[0] = scanner.nextLine();
        System.out.print("Enter a section number (1, 3, or 4): ");
        option[1] = scanner.nextLine();
        System.out.print("Enter group size: ");
        option[2] = scanner.nextLine();
       return option;
    }

    public static String continueOrQuit(){
        System.out.print("Would you like to quit? (y/n): ");
        String continueOrQuit = scanner.nextLine();

        return continueOrQuit;
    }



}
