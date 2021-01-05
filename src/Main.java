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
            generateGroups("3", "2", roll); //option[1], option[2],
            quit = View.continueOrQuit();
        }



    }

    public static void generateGroups(String section, String groupSize, ArrayList<String> namesList){



        double groupNumber = Double.parseDouble(section);
        groupNumber  += .1;
        Collections.shuffle(namesList);
        System.out.println();
        System.out.println("Groups Generated for Period: " + section);
        System.out.println("Total Students in Period: " + namesList.size());
        System.out.println();
        int size = Integer.parseInt(groupSize);

            for (int i = 0; i < namesList.size(); i += size) {
                System.out.println("GROUP: " + String.format("%.1f", groupNumber));

                try {
                    for (int j = 0; j < size; j++) {

                        System.out.println(namesList.get(i + j)); // + ": " + String.format("%.1f", groupNumber));
                    }

                } catch (IndexOutOfBoundsException e) {
                    //System.out.println("in the else");

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
