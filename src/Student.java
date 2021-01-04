import java.util.ArrayList;

public class Student {
    String name;
    String id;
    String course;
    String section;
    ArrayList<String> groups = new ArrayList<>();


    public Student(String name, String id, String course, String section) {
        this.name = name;
        this.id = id;
        this.course = course;
        this.section = section;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
}
