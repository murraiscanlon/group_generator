import java.sql.SQLOutput;
import java.util.Scanner;

public class ConsoleUI {
    static Scanner scanner = new Scanner(System.in); //closed at the end of the program


    public static void sendMessage(String message){
        System.out.print(message);
    } //good

    public static void welcomeMessage(){
        sendMessage("\n********************** WELCOME to the GROUP RANDOMIZER  *************************\n\n");

    } //good

    public static String getRosterFileName(){
        sendMessage("Enter the filename of the roster file: ");
        String filename = scanner.nextLine();
        String path = "C:\\Users\\murra\\IdeaProjects\\group_generator\\resources\\";
        return path + filename;
    } //good, but using hard code for testing right now

    public static String displayMainMenu(){
        String option = "";
        sendMessage("Choose an option below:\n");
        sendMessage("\tg = Generate initial groups for a project\n");
        sendMessage("\tr = Re-Shuffle the current groups\n");
        sendMessage("\ts = Save to file\n");
        sendMessage("\te = Exit the program\n");
        sendMessage("Enter your choice here: ");
        option = scanner.nextLine();
        return option;
    }//good

    public static String[] getProjectSpecs(){
        String[] projectDetails = new String[4];
        sendMessage("Enter the PROJECT name: ");
        projectDetails[0] = scanner.nextLine();
        sendMessage("Enter a COURSE name (gte, stemlab, or advrobo): ");
        projectDetails[1] = scanner.nextLine();
        sendMessage("Enter a SECTION number (1, 3, 4, 5, 6, 7, or 8): ");
        projectDetails[2] = scanner.nextLine();
        sendMessage("Enter group size: ");
        projectDetails[3] = scanner.nextLine();
        return projectDetails;
    }//good


}
