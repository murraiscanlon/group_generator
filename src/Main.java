import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //TODO create view file to get user input for parameters below

        ArrayList<Student> students = CsvReader.readFile("C:/Users/Murrai.Scanlon/IdeaProjects/group_generator/csv/test.csv");
        String[] option = View.menu();
        ArrayList<String> roll =  getClass(option[0], option[1], students );
        generateGroups(3, roll);


    }

    public static void generateGroups(int groupSize, ArrayList<String> roll){
        //TODO avoid indexoutofbounds error when the groups aren't even

        double groupNumber = 1.1;
        Collections.shuffle(roll);

            for (int i = 0; i < roll.size(); i += groupSize) {

                    System.out.println(roll.get(i) + ": " + String.format( "%.1f", groupNumber ));
                    System.out.println(roll.get(i + 1) + ": " + String.format( "%.1f", groupNumber ));
                    System.out.println(roll.get(i + 2) + ": " + String.format( "%.1f", groupNumber ));
                    System.out.println("--------------------");
                    groupNumber += .1;
            }

        }






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
