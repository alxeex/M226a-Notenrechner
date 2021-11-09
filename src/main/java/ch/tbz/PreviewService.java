package ch.tbz;

import java.util.ArrayList;

public class PreviewService {
    private final ArrayList<Mark> allMarks = new ArrayList<>();
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
        getMark(id).setSubject(subject);
        getMark(id).setValue(value);
        return getMark(id);
    }

    public void deleteMark(int id){
        allMarks.remove(getMark(id));
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

    public Mark getMark(int id) {
        for (Mark mark : allMarks) {
            if(mark.getId() == (id)){
                return mark;
            }
        }
        System.out.println("Diese Marke wurde nicht gefunden");
        return null;
    }

    public ArrayList<Mark> getAllMarks() {
        return this.allMarks;
    }

    public void addMarkToSubject(MySubject subject, Mark mark){
        subject.addMark(mark);
    }



}
