import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.currentTimeMillis;

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

    public static void fileWrite(String section, String project, ArrayList<String> output){
        try {
            Timestamp timestamp = new Timestamp(currentTimeMillis());
            FileWriter myWriter = new FileWriter("C:\\Users\\murra\\IdeaProjects\\group_generator\\output\\section" + section + project + ".txt");
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
