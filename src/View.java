import java.util.Scanner;

public class View {
    static Scanner scanner = new Scanner(System.in);

    public static String[] menu1(){
        String[] optionMenu1 = new String[3];

        System.out.print("Enter a course name (gte, stem lab, or adv robo): ");
        optionMenu1[0] = scanner.nextLine();
        System.out.print("Enter a section number (1, 3, or 4): ");
        optionMenu1[1] = scanner.nextLine();
        System.out.print("Enter group size: ");
        optionMenu1[2] = scanner.nextLine();
       return optionMenu1;
    }

    public static String menu2(){
        String[] optionMenu2 = new String[1];
        System.out.print("Options:" + "\n");
        System.out.print("\t0 - Quit" + "\n");
        System.out.print("\t1 - Re-Generate Groups" + "\n");
        System.out.print("\t2 - Print Groups" + "\n");
        System.out.print("Enter an option now: ");
        optionMenu2[0] = scanner.nextLine();
        return optionMenu2[0];
    }



}
