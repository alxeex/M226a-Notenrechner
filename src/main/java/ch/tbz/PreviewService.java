package ch.tbz;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class PreviewService {
    @Getter
    private final ArrayList<Mark> allMarks = new ArrayList<>();
    @Getter
    private final ArrayList<Mark> currentMarks = new ArrayList<>();

    public void showMarks(int id, int userId) {

    }

    // Mark
    public Mark createMark(int id, float value, int userId, MySubject subject, String semester) {
        Mark mark = new Mark(id, value, userId, subject.getSubject(), semester);
        allMarks.add(mark);
        this.addMarkToSubject(subject, mark);
        return mark;
    }



    public Mark editMark(int id, float value, String subject) {
        getMarkById(id).setSubject(subject);
        getMarkById(id).setValue(value);
        return getMarkById(id);
    }

    public void deleteMark(int id){
        allMarks.remove(getMarkById(id));
    }

    public ArrayList<Mark> getMarks(int userid) {
        this.currentMarks.clear();
        for (Mark mark : allMarks) {
            if(mark.getUserId() == (userid)){
                this.currentMarks.add(mark);
            }
        }
        return this.currentMarks;
    }

    public Mark getMarkById(int id) {
        for (Mark mark : allMarks) {
            if(mark.getId() == (id)){
                return mark;
            }
        }
        System.out.println("Diese Marke wurde nicht gefunden");
        return null;
    }

    public void addMarkToSubject(MySubject subject, Mark mark){
        subject.addMark(mark);
    }



}
