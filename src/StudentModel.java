import java.util.ArrayList;

public class StudentModel {
    private String id;
    private String lastname;
    private String firstname;
    private String course;
    private String section;
    private ArrayList<String> groups = new ArrayList<>();
    static int count = 0;


    public StudentModel(String id, String firstname, String lastname, String course, String section) {

        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.course = course;
        this.section = section;
        count++;
    }

    public String getFullName(){
        return firstname + " " + lastname;
    }

    public void printStudent(StudentModel s){
        System.out.println("[ " + s.getLastname() + ", " + s.getFirstname() + " ]");
    }

    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public ArrayList<String> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<String> groups) {
        this.groups = groups;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
