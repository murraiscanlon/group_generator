import java.util.Scanner;

public class View {

    public static String[] menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Class and Section:\n " +
                            "Courses: gte, stem lab, adv robo\n" +
                            "Sections: 1, 3, 4\n");
        String row = scanner.nextLine();
        String[] option = row.split(" ");
        scanner.close();

        return option;
    }

}
