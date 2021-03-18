import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class GroupManager {

    static int shuffled = 0; //to identify how many times the groups have been created

    //Helper function to: get only the students that correspond to user specifications
    public ArrayList<String> getStudentsInCourse(String course, String section, ArrayList<StudentModel> allRosters){
        ArrayList<String> studentsInCourse = new ArrayList<>();

        for (StudentModel s : allRosters){
            //System.out.println(s.getCourse());
            if (s.getCourse().equals(course)){
                //System.out.println(s.getCourse());
                if (s.getSection().equals(section)){
                    //System.out.println(s.getSection());
                    studentsInCourse.add(s.getFullName());
                    //System.out.println(s.getFullname());
                }
            }
        }
        return studentsInCourse;

    }
    //good

    //Helper function to: generate random groups of students
    public ArrayList<String> generateGroups(String course, String section, String groupSize, ArrayList<String> studentsInCourse){

        //this is printed to .txt file as output and to the console for previewing
        //TODO separate display function from output function
        ArrayList<String> output = new ArrayList<>();
        shuffled++;

        if (section == "") {
            section = "0";
        }
        double groupNumber = Double.parseDouble(section); //class period/section number
        groupNumber  += .1; //add the decimal for the individual group numbers
        Collections.shuffle(studentsInCourse);
        System.out.println();
        output.add("\n");
        ConsoleUI.sendMessage("\n+---------------------------------------------------+");
        ConsoleUI.sendMessage("\n+               Randomized Groups                   +");
        ConsoleUI.sendMessage("\n+---------------------------------------------------+\n\n");
        output.add("\n+---------------------------------------------------+");
        output.add("\n+               Randomized Groups                   +");
        output.add("\n+---------------------------------------------------+\n\n");
        System.out.println("Report generation: " + shuffled);
        output.add("Report generation: " + shuffled + "\n");
        System.out.println("Course: " + course);
        output.add("Course: " + course + "\n");
        System.out.println("Class Period: " + section);
        output.add("Class Period: " + section +"\n");
        System.out.println("Total Students in Period: " + studentsInCourse.size());
        output.add("Total Students in Period: " + studentsInCourse.size() + "\n");
        System.out.println();
        output.add("\n");

        if (groupSize == "") {
            groupSize = "0";
        }
        int size = Integer.parseInt(groupSize); //size of groups
        //Timestamp timestamp = new Timestamp(currentTimeMillis());
        //String fileName = new SimpleDateFormat("MM-dd-yyyy_HH-mm'.txt'").format(new Date());

        //try {
//            FileWriter myWriter = new FileWriter("C:/Users/Murrai.Scanlon/Desktop/generated_groups/groups" + section +"drivebase.txt");
//            myWriter.write("\n" + timestamp + "\n");
//            myWriter.write("\n");

        //Loop through the entire list of shuffled names, stepping matches group size

        for (int i = 0; i < studentsInCourse.size(); i += size) {
            System.out.println("GROUP: " + String.format("%.1f", groupNumber));
            //myWriter.write("GROUP: " + String.format("%.1f", groupNumber) + "\n");
            output.add("GROUP: " + String.format("%.1f", groupNumber) + "\n");

            try {
                for (int j = 0; j < size; j++) { //Print every name in groups of n-size

                    System.out.println(studentsInCourse.get(i + j)); // + ": " + String.format("%.1f", groupNumber));
                    //myWriter.write(namesList.get(i + j) + "\n");
                    output.add(studentsInCourse.get(i + j) + "\n");
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
    //good
}
