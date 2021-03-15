import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {



    public static ArrayList<StudentModel> readFile(String path) {

        ArrayList<StudentModel> students = new ArrayList<>();

        File infile = new File(path);
        Scanner scanner;

        {
            try {
                scanner = new Scanner(infile);

                //scanner.nextLine();
                while (scanner.hasNextLine()) {
                    String row = scanner.nextLine();
                    String[] column = row.split(",");

                    String id = column[0];
                    String lastname = column[1];
                    String firstname = column[2];
                    String course = column[3];
                    String section = column[4];

                    StudentModel student = new StudentModel(id, firstname, lastname, course, section);
                    students.add(student);


                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        return students;
    }


}
