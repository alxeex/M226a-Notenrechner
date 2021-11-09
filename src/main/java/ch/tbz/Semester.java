package ch.tbz;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Semester  {
    @Getter
    @Setter
    private String semester;
    @Getter
    @Setter
    private ArrayList<MySubject> mySubjects = new ArrayList<>();
    @Getter
    @Setter
    private String germanName = "Semester";

    public Semester(String semester) {
        this.semester = semester;
    }

    public void addSubject(MySubject subject) {
        this.mySubjects.add(subject);
    }
}
