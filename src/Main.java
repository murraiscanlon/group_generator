import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //read in the csv with student data and save the return list of Student objects
        ArrayList<Student> students = CsvReader.readFile("C:/Users/Murrai.Scanlon/IdeaProjects/group_generator/csv/test.csv");

        //Use a while loop to continuously check for CLI user input
        String quit = "n";
        while(quit.equals("n")){

            String[] option = View.menu(); //Ask user for course, section, and group size
            ArrayList<String> namesList = getClass(option[0], option[1], students); //get list of names corresponding to course and section
            generateGroups(option[1], option[2], namesList); //Generate groups based on user input/menu options
            quit = View.continueOrQuit(); //stop program when user enters "y"
        }
    }

    /**
     * This function prints groups of students based on user parameters of course, section, and size.
     * @param section
     * @param groupSize
     * @param namesList
     */

    public static void generateGroups(String section, String groupSize, ArrayList<String> namesList){

        double groupNumber = Double.parseDouble(section); //class period/section number
        groupNumber  += .1; //add the decimal for the individual group numbers
        Collections.shuffle(namesList);
        System.out.println();
        System.out.println("Groups Generated for Period: " + section);
        System.out.println("Total Students in Period: " + namesList.size());
        System.out.println();
        int size = Integer.parseInt(groupSize); //size of groups

        //Loop through the entire list of shuffled names, stepping matches group size
        for (int i = 0; i < namesList.size(); i += size) {
                System.out.println("GROUP: " + String.format("%.1f", groupNumber));

                try {
                    for (int j = 0; j < size; j++) { //Print every name in groups of n-size

                        System.out.println(namesList.get(i + j)); // + ": " + String.format("%.1f", groupNumber));
                    }

                } catch (IndexOutOfBoundsException e) {
                    //System.out.println("in the else");

                }
                    System.out.println("--------------------");
                    groupNumber += .1;//Update the group number for display
            }

        }


    /**
     * This function selects specified course and section from the entire list of all students and returns
     * a String array with their full names for futher processing.
     * @param course
     * @param section
     * @param students
     * @return ArrayList<String> classList
     */
    public static ArrayList<String> getClass(String course, String section, ArrayList<Student> students){
        ArrayList<String> classlist = new ArrayList<>();

        for (Student s : students){
            //System.out.println(s.getCourse());
            if (s.getCourse().equals(course)){
                //System.out.println(s.getCourse());
                if (s.getSection().equals(section)){
                    //System.out.println(s.getSection());
                    classlist.add(s.getFullname());
                    //System.out.println(s.getFullname());
                }

            }

        }

        return classlist;

    }
}
