import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.time.*;


import static java.lang.System.currentTimeMillis;

public class Main {

    /**
     * Main method for generating groups
     * @param args
     */
    public static void main(String[] args) {
        //read in the csv with student data and save the return list of Student objects
        ArrayList<Student> students = CsvReader.readFile("C:/Users/Murrai.Scanlon/IdeaProjects/group_generator/csv/test2.csv");

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
        Timestamp timestamp = new Timestamp(currentTimeMillis());
        //String fileName = new SimpleDateFormat("MM-dd-yyyy_HH-mm'.txt'").format(new Date());

        try {
            FileWriter myWriter = new FileWriter("C:/Users/Murrai.Scanlon/Desktop/generated_groups/groups" + section +"drivebase.txt");
            myWriter.write("\n" + timestamp + "\n");
            myWriter.write("\n");

        //Loop through the entire list of shuffled names, stepping matches group size
        for (int i = 0; i < namesList.size(); i += size) {
                System.out.println("GROUP: " + String.format("%.1f", groupNumber));
                myWriter.write("GROUP: " + String.format("%.1f", groupNumber) + "\n");

                try {
                    for (int j = 0; j < size; j++) { //Print every name in groups of n-size

                        System.out.println(namesList.get(i + j)); // + ": " + String.format("%.1f", groupNumber));
                        myWriter.write(namesList.get(i + j) + "\n");
                    }

                } catch (IndexOutOfBoundsException e) {
                    //System.out.println("in the else");

                }
                    System.out.println("--------------------");
                    myWriter.write("--------------------" + "\n");
                    groupNumber += .1;//Update the group number for display
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("file written successfully!");

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
                    classlist.add(s.getFullName());
                    //System.out.println(s.getFullname());
                }

            }

        }

        return classlist;

    }

//    public static void fileWrite(){
//        try {
//            FileWriter myWriter = new FileWriter("C:/Users/Murrai.Scanlon/Desktop/groups.txt");
//
//            myWriter.write("Files in Java might be tricky, but it is fun enough!");
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
//
//    }
}
