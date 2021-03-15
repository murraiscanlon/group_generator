import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;


import static java.lang.System.currentTimeMillis;

public class Main {
    static int generation = 0;

    /**
     * Main method for generating groups
     * @param args
     */
    public static void main(String[] args) {
        //read in the csv with student data and save the return list of Student objects
        ArrayList<StudentModel> students = FileIO.readFile("C:\\Users\\murra\\IdeaProjects\\group_generator\\resources\\test.csv");

        //Use a while loop to continuously check for CLI user input
        String[] optionMenu1;
        optionMenu1 = ConsoleUI.menu1(); //Ask user for course, section, and group size
        String optionMenu2 = "";
        String quit = "";
        ArrayList<String> namesList = getClass(optionMenu1[0], optionMenu1[1], students); //get list of names corresponding to course and section
        ArrayList<String> output = generateGroups(optionMenu1[1], optionMenu1[2], namesList); //Generate groups based on user input/menu options
        while(!quit.equals("0")){


            optionMenu2 = ConsoleUI.menu2();
            if (optionMenu2.equals("0")){ //stop program when user enters "0"
                quit = "0";
            } else if (optionMenu2.equals("1")){ //regenerate groups
                output = generateGroups(optionMenu1[1], optionMenu1[2], namesList);
            } else if (optionMenu2.equals("2")){
                fileWrite(optionMenu1[1], "drivebase", output); //print groups

            } else {
                //TODO reword the options for "continue" after printing
            }
        }



    }


    /**
     * This function prints groups of students based on user parameters of course, section, and size.
     * @param section
     * @param groupSize
     * @param namesList
     */

    public static ArrayList<String> generateGroups(String section, String groupSize, ArrayList<String> namesList){
        ArrayList<String> output = new ArrayList<>();
        generation++;

        double groupNumber = Double.parseDouble(section); //class period/section number
        groupNumber  += .1; //add the decimal for the individual group numbers
        Collections.shuffle(namesList);
        System.out.println();
        output.add("\n");
        System.out.println("Report generation: " + generation);
        output.add("Report generation: " + generation + "\n");
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
     * This function selects specified course and section from the entire list of all students and returns
     * a String array with their full names for futher processing.
     * @param course
     * @param section
     * @param students
     * @return ArrayList<String> classList
     */
    public static ArrayList<String> getClass(String course, String section, ArrayList<StudentModel> students){
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

    public static void fileWrite(String section, String project, ArrayList<String> output){
        try {
            Timestamp timestamp = new Timestamp(currentTimeMillis());
            FileWriter myWriter = new FileWriter("C:/Users/Murrai.Scanlon/Desktop/generated_groups/groups" + section + project + ".txt");
            myWriter.write("\n" + timestamp + "\n");
            myWriter.write("\n");

            for (int i = 0; i < output.size(); i++){
                myWriter.write(output.get(i));
            }
            myWriter.close();
            //System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
