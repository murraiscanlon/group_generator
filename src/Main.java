import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int shuffled = 0; //to identify how many times the groups have been shuffled

    /**
     * Main method for generating random groups
     */
    public static void main(String[] args) {

        //ask user for filename (including file extension)
        String path = "C:\\Users\\murra\\IdeaProjects\\group_generator\\resources\\test.csv"; //ConsoleUI.getRosterFileName();

        //read in the csv with student data and save the return list of Student objects
        ArrayList<StudentModel> allRosters = FileIO.readFile(path);

        //Ask user for course, section, and group size
        String[] groupDetails = {"gte", "3", "3"};
        //groupDetails = ConsoleUI.getGroupDetails();
        String course = groupDetails[0];
        String section = groupDetails[1];
        String group_size = groupDetails[2];
        //TODO ask for the name of the project to be used in outfile name later


        //get list of names corresponding to course and section
        ArrayList<String> studentsInCourse = getCourse(course, section, allRosters);


        //Generate random groups based on user input - group details
        ArrayList<String> groups = generateGroups(section, group_size, studentsInCourse);


        //Secondary actions after 1st generation of groups: Quit, Regenerate groups, Write to file
        secondaryActions(section, group_size, studentsInCourse, groups);

    }//end main


    /**
     * Helper function to: generate random groups of students
     */
    private static ArrayList<String> generateGroups(String section, String groupSize, ArrayList<String> namesList){
        ArrayList<String> output = new ArrayList<>();
        shuffled++;

        double groupNumber = Double.parseDouble(section); //class period/section number
        groupNumber  += .1; //add the decimal for the individual group numbers
        Collections.shuffle(namesList);
        System.out.println();
        output.add("\n");
        System.out.println("Report generation: " + shuffled);
        output.add("Report generation: " + shuffled + "\n");
        System.out.println("Groups Generated for Period: " + section);
        output.add("Groups Generated for Period: " + "\n");
        System.out.println("Total Students in Period: " + namesList.size());
        output.add("Total Students in Period: " + "\n");
        System.out.println();
        output.add("\n");

        int size = Integer.parseInt(groupSize); //size of groups
        //Timestamp timestamp = new Timestamp(currentTimeMillis());
        //String fileName = new SimpleDateFormat("MM-dd-yyyy_HH-mm'.txt'").format(new Date());

        //try {
//            FileWriter myWriter = new FileWriter("C:/Users/Murrai.Scanlon/Desktop/generated_groups/groups" + section +"drivebase.txt");
//            myWriter.write("\n" + timestamp + "\n");
//            myWriter.write("\n");

        //Loop through the entire list of shuffled names, stepping matches group size

        for (int i = 0; i < namesList.size(); i += size) {
                System.out.println("GROUP: " + String.format("%.1f", groupNumber));
                //myWriter.write("GROUP: " + String.format("%.1f", groupNumber) + "\n");
                output.add("GROUP: " + String.format("%.1f", groupNumber) + "\n");

                try {
                    for (int j = 0; j < size; j++) { //Print every name in groups of n-size

                        System.out.println(namesList.get(i + j)); // + ": " + String.format("%.1f", groupNumber));
                        //myWriter.write(namesList.get(i + j) + "\n");
                        output.add(namesList.get(i + j) + "\n");
                    }

                } catch (IndexOutOfBoundsException e) {
                    //System.out.println("in the else");

                }
                    System.out.println("--------------------");
                    //myWriter.write("--------------------" + "\n");
                    output.add("--------------------" + "\n");

                    groupNumber += .1;//Update the group number for display
            }
            //myWriter.close();
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//        System.out.println("file written successfully!");
//
        return output;
      }


    /**
     * Helper function to: get only the students that correspond to user specifications
     */
    private static ArrayList<String> getCourse(String course, String section, ArrayList<StudentModel> students){
        ArrayList<String> classlist = new ArrayList<>();

        for (StudentModel s : students){
            //System.out.println(s.getCourse());
            if (s.getCourse().equals(course)){
                //System.out.println(s.getCourse());
                if (s.getSection().equals(section)){
                    //System.out.println(s.getSection());
                    classlist.add(s.getFullName());
                    //System.out.println(s.getFullname());
                }

            }

        }

        return classlist;

    }


    /**
     * Helper function to: repeatedly ask user for secondary actions until they wish to exit the program
     */
    private static void secondaryActions(String section, String group_size, ArrayList<String> studentsInCourse, ArrayList<String> groups){
        String continueResult = ""; //0 = quit, 1 = regenerate groups, 2 = write groups to file
        String quit = "";
        while(!quit.equals("0")){

            continueResult = ConsoleUI.getContinueResults();
            if (continueResult.equals("0")){ //stop program when user enters "0"
                quit = "0";
            } else if (continueResult.equals("1")){ //regenerate groups
                groups = generateGroups(section, group_size, studentsInCourse);
            } else if (continueResult.equals("2")){
                FileIO.fileWrite(section, "drivebase", groups); //print groups

            } else {
                //TODO reword the options for "continue" after printing
            }
        }
    }
}
