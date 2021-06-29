import java.util.Collections;
import java.util.ArrayList;

public class GtStudent implements Comparable<GtStudent> {

    private String name;
    private Major major;
    private double GPA;
    private int year;

    public GtStudent(String name, Major major, double GPA, int year) {
        this.name = name;
        this.major = major;
        this.GPA = GPA;
        this.year = year;
    }

    public String toString() {
        return String.format("Student name is %s; major is %s; gpa is %f; year is %d", name, major.name, GPA, year);
    }

    public int compareTo(GtStudent other) {
        int value = (int) (this.GPA - other.GPA);
        return (this.major.difficulty - other.major.difficulty) + value;
    }

    public static void main(String[] args) {
        ArrayList<GtStudent> myList = new ArrayList<>();
        GtStudent stud1 = new GtStudent("sam", Major.CS, 2.4, 2021);
        GtStudent stud2 = new GtStudent("das", Major.LAW, 2.4, 2021);
        GtStudent stud3 = new GtStudent("hur", Major.ECON, 2.4, 2021);
        GtStudent stud4 = new GtStudent("lim", Major.CS, 2.5, 2021);

        myList.add(stud1);
        myList.add(stud2);
        myList.add(stud3);
        myList.add(stud4);
        Collections.sort(myList);
        System.out.println(myList);

    }
}