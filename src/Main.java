import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = CsvReader.readFile("csv/test.csv");
        ArrayList<String> roll =  getClass("GTE", "1", students );






    }

    public static void generateGroups(int groupSize){

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
                    System.out.println(s.getFullname());
                }

            }


        }

        return classlist;

    }
}
