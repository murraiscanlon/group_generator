import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = CsvReader.readFile("csv/test.csv");
        for (Student s : students){
            System.out.println(s.getLastname() + ", " + s.getFirstname());

        }



    }
}
