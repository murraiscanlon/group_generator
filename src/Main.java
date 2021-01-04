import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = CsvReader.readFile("csv/test.csv");
        ArrayList<String> roll =  getClass("GTE", "1", students );
        generateGroups(3, roll);






    }

    public static void generateGroups(int groupSize, ArrayList<String> roll){
        //TODO format group number to 1 decimal point

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
            if (s.getCourse().equals("gte")){
                //System.out.println(s.getCourse());
                if (s.getSection().equals("3")){
                    //System.out.println(s.getSection());
                    classlist.add(s.getFullname());
                    //System.out.println(s.getFullname());
                }

            }


        }

        return classlist;

    }
}
