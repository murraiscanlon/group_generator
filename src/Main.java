import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {



        ArrayList<Student> students = CsvReader.readFile("C:/Users/Murrai.Scanlon/IdeaProjects/group_generator/csv/test.csv");

        String quit = "n";
        while(quit.equals("n")){

            //String[] option = View.menu();
            ArrayList<String> roll = getClass("gte", "3", students); //option[0], option[1]
            generateGroups("3", "5", roll); //option[1], option[2],
            quit = View.continueOrQuit();
        }

        //TODO Group size is not dynamic yet. Must be 3 to work correctly because of hard coding in generateGroups().


    }

    public static void generateGroups(String section, String groupSize, ArrayList<String> namesList){
        //TODO avoid indexoutofbounds error when the groups aren't evenly divided


        double groupNumber = Double.parseDouble(section);
        groupNumber  += .1;
        Collections.shuffle(namesList);
        System.out.println();
        System.out.println("***************** NEW GROUPS *********************");
        System.out.println();
        int size = Integer.parseInt(groupSize);

            for (int i = 0; i < namesList.size(); i += size) {

                for (int j = 0; j < size; j++ ) {
                    System.out.println(namesList.get(i + j) + ": " + String.format("%.1f", groupNumber));

                    //System.out.println(namesList.get(i + 1) + ": " + String.format("%.1f", groupNumber));
                    //System.out.println(namesList.get(i + 2) + ": " + String.format("%.1f", groupNumber));

                }

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
