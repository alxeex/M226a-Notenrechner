package ch.tbz;

import java.util.ArrayList;

public class EditorService {

    private final ArrayList<Semester> allSemesters = new ArrayList<>();;
    private final ArrayList<MySubject> allSubjects = new ArrayList<>();;

    // Semester
    public Semester createSemester(String semesterName) {
        Semester semester = new Semester(semesterName);
        allSemesters.add(semester);
        return semester;
    }

    public Semester editSemester(String semesterName, ArrayList<MySubject>  subjects) {
        getSemester(semesterName).setSubjects(subjects);
        return getSemester(semesterName);
    }

    public void deleteSemester(String semesterName){
        allSemesters.remove(getSemester(semesterName));
    }

    public Semester getSemester(String semesterName) {
        for (Semester semester : allSemesters) {
            if(semester.getSemester().equals(semesterName)){
                return semester;
            }
        }
        System.out.println("Dieses Semester wurde nicht gefunden");
        return null;
    }

    public ArrayList<Semester> getAllSemesters() {
        return this.allSemesters;
    }

    // Subject
    public MySubject createSubject(int id, String subjectName, String semester) {
        MySubject subject = new MySubject(id, subjectName, semester);
        this.addSubjectToSemester(subject, getSemester(semester));
        allSubjects.add(subject);
        return subject;
    }

    public MySubject editSubject(int id, String subjectName, ArrayList<Mark> marks) {
        getSubject(id).setMarks(marks);
        return getSubject(id);
    }

    public void deleteSubject(int id){
        allSubjects.remove(getSubject(id));
    }

    public MySubject getSubject(int id) {
        for (MySubject subject : allSubjects) {
            if(subject.getId() == id){
                return subject;
            }
        }
        System.out.println("Dieses Thema wurde nicht gefunden");
        return null;
    }

    public MySubject getSubject(String name) {
        for (MySubject subject : allSubjects) {
            if(subject.getSubject().equals(name)){
                return subject;
            }
        }
        System.out.println("Dieses Thema wurde nicht gefunden");
        return null;
    }

    public ArrayList<MySubject> getAllSubjects() {
        return this.allSubjects;
    }

    public void addSubjectToSemester(MySubject subject, Semester semester){
        semester.addSubject(subject);
    }


}
