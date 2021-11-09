package ch.tbz;

import java.util.ArrayList;

public class MySubject{
    private int id;
    private String subject;
    private String semester;
    private ArrayList<Mark> marks = new ArrayList<>();
    private String germanName = "Themen";

    public MySubject(int id, String subject, String semester) {
        this.subject = subject;
        this.id = id;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ArrayList<Mark> getMarks() {
        return marks;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMarks(ArrayList<Mark> marks) {
        this.marks = marks;
    }

    public void addMark(Mark mark) {
        this.marks.add(mark);
    }
}
