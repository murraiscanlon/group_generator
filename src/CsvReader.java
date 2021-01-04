import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvReader {



    public static ArrayList<Student> readFile(String path) {

        ArrayList<Student> students = new ArrayList<>();

        File infile = new File(path);
        Scanner scanner;

        {
            try {
                scanner = new Scanner(infile);

                //String firstrow = scanner.nextLine();
                while (scanner.hasNextLine()) {
                    String row = scanner.nextLine();
                    String[] column = row.split(",");

                    String id = column[0];
                    String lastname = column[1];
                    String firstname = column[2];
                    String course = column[3];
                    String section = column[4];

                    Student student = new Student(id, lastname, firstname, course, section);
                    students.add(student);


                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        return students;
    }


}
