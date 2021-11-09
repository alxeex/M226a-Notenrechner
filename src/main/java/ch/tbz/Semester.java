package ch.tbz;

import java.util.ArrayList;

public class Semester  {
    private String semester;
    private ArrayList<MySubject> mySubjects = new ArrayList<>();
    private String germanName = "Semester";

    public Semester(String semester) {
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ArrayList<MySubject> getSubjects() {
        return mySubjects;
    }

    public void setSubjects(ArrayList<MySubject> mySubjects) {
        this.mySubjects = mySubjects;
    }

    public void addSubject(MySubject subject) {
        this.mySubjects.add(subject);
    }
}
