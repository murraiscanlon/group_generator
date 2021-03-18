import java.io.File;
import java.util.ArrayList;
import java.util.Locale;


public class Main {


    /**
     * Main method for generating random groups of students for class projects.
     */
    public static void main(String[] args) {

        //Program Set Up
        ConsoleUI.welcomeMessage();

        //read in the csv with student data and save the return list of Student objects
        FileIO fileIO = new FileIO();
        ArrayList<StudentModel> allRosters = getStartupRosterData(fileIO);

        //Initialize a ton of stuff. This doesn't smell right. Figure out if there is a better way
        ArrayList<String> studentsInCourse = new ArrayList<>();
        String[] projectSpecs = new String[4];
        String projectName = "";
        String courseName = "";
        String sectionNumber = "";
        String groupSize = "";
        ArrayList<String> groupsOutput = new ArrayList<>();

        //Main loop. Displays choices to user
        GroupManager groupManager = new GroupManager();
        while (true) {
            //get main menu option from user
            String mainMenuOption = ConsoleUI.displayMainMenu(); //g, r, s, e
            switch (mainMenuOption.toLowerCase()){
                case "g": //generate initial groups
                    projectSpecs = ConsoleUI.getProjectSpecs();
                    projectName = projectSpecs[0];
                    courseName = projectSpecs[1];
                    sectionNumber = projectSpecs[2];
                    groupSize = projectSpecs[3];

                    studentsInCourse = groupManager.getStudentsInCourse(courseName, sectionNumber, allRosters);
                    groupsOutput = groupManager.generateGroups(courseName, sectionNumber, groupSize, studentsInCourse);
                    break;

                case "r": //reshuffle groups
                    groupsOutput = groupManager.generateGroups(courseName, sectionNumber, groupSize, studentsInCourse);
                    break;

                case "s": //save groups to file
                    fileIO.fileWrite(courseName, sectionNumber, projectName, groupsOutput);
                    break;

                case "e": //exit the program
                    System.out.println();
                    ConsoleUI.sendMessage("This program was created with ❤ by Murrai");
                    System.exit(0);

                default:
                    ConsoleUI.sendMessage("Something went wrong in the main switch. . .");
            }
        }//end while

    }//end main

    //helper method to get start info like file name etc
    private static ArrayList<StudentModel>  getStartupRosterData(FileIO fileIO){
        //ask user for filename (including file extension)
        String inFilePath = "C:\\Users\\murra\\IdeaProjects\\group_generator\\resources\\test.csv"; //ConsoleUI.getRosterFileName();
        ArrayList<StudentModel> allRosters = fileIO.readFile(inFilePath);
        return allRosters;
    }


}

