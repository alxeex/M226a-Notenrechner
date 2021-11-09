package ch.tbz;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class MySubject{
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String subject;
    @Getter
    @Setter
    private String semester;
    @Getter
    @Setter
    private ArrayList<Mark> marks = new ArrayList<>();
    @Getter
    @Setter
    private String germanName = "Themen";

    public MySubject(int id, String subject, String semester) {
        this.subject = subject;
        this.id = id;
        this.semester = semester;
    }

    public void addMark(Mark mark) {
        this.marks.add(mark);
    }
}
