import java.sql.SQLOutput;
import java.util.Scanner;

public class ConsoleUI {
    static Scanner scanner = new Scanner(System.in); //closed at the end of the program


    public static void sendMessage(String message){
        System.out.print(message);
    } //good

    public static void welcomeMessage(){
        sendMessage("\n+---------------------------------------------------+");
        sendMessage("\n+           Welcome to Group Randomizer             +");
        sendMessage("\n+---------------------------------------------------+\n\n");


    } //good

    public static String getRosterFileName(){
        sendMessage("Enter the filename of the roster file: ");
        String filename = scanner.nextLine();
        String path = "C:\\Users\\murra\\IdeaProjects\\group_generator\\resources\\";
        return path + filename;
    } //good, but using hard code for testing right now

    public static String displayMainMenu(){

        String option = "";
        String[] menuOptions = {"1", "2", "3", "0"};
        boolean isValid = false;
        while(!isValid) {
            sendMessage("Choose an option below:\n");
            sendMessage("\t1 = Generate initial groups for a project\n");
            sendMessage("\t2 = Re-Shuffle the current groups\n");
            sendMessage("\t3 = Save to file\n");
            sendMessage("\t0 = Exit the program\n");
            sendMessage("Enter your choice here: ");
            option = scanner.nextLine();
            for (String item: menuOptions){
                if (option.equals(item)){
                    isValid = true;
                    break;
                }
            }
            if(!isValid){
                sendMessage("----- Invalid entry. Please try again. -----\n\n");
            }

        }
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

    public static void goodbyeMessage(){
        sendMessage("\n+---------------------------------------------------+");
        sendMessage("\n+   This program was created with ❤ by Murrai      +");
        sendMessage("\n+---------------------------------------------------+\n\n");
    } //good



}
