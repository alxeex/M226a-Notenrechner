package ch.tbz;

import lombok.Getter;

import java.util.ArrayList;

public class EditorService {

    @Getter
    private final ArrayList<Semester> allSemesters = new ArrayList<>();;
    @Getter
    private final ArrayList<MySubject> allSubjects = new ArrayList<>();;

    // Semester
    public Semester createSemester(String semesterName) {
        Semester semester = new Semester(semesterName);
        allSemesters.add(semester);
        return semester;
    }

    public Semester editSemester(String semesterName, ArrayList<MySubject>  subjects) {
        getSemesterByName(semesterName).setMySubjects(subjects);
        return getSemesterByName(semesterName);
    }

    public void deleteSemester(String semesterName){
        allSemesters.remove(getSemesterByName(semesterName));
    }

    public Semester getSemesterByName(String semesterName) {
        for (Semester semester : allSemesters) {
            if(semester.getSemester().equals(semesterName)){
                return semester;
            }
        }
        System.out.println("Dieses Semester wurde nicht gefunden");
        return null;
    }


    // Subject
    public MySubject createSubject(int id, String subjectName, String semester) {
        MySubject subject = new MySubject(id, subjectName, semester);
        this.addSubjectToSemester(subject, getSemesterByName(semester));
        allSubjects.add(subject);
        return subject;
    }

    public MySubject editSubject(int id, String subjectName, ArrayList<Mark> marks) {
        getSubjectById(id).setMarks(marks);
        return getSubjectById(id);
    }

    public void deleteSubject(int id){
        allSubjects.remove(getSubjectById(id));
    }

    public MySubject getSubjectById(int id) {
        for (MySubject subject : allSubjects) {
            if(subject.getId() == id){
                return subject;
            }
        }
        System.out.println("Dieses Thema wurde nicht gefunden");
        return null;
    }

    public MySubject getSubjectByName(String name) {
        for (MySubject subject : allSubjects) {
            if(subject.getSubject().equals(name)){
                return subject;
            }
        }
        System.out.println("Dieses Thema wurde nicht gefunden");
        return null;
    }

    public void addSubjectToSemester(MySubject subject, Semester semester){
        semester.addSubject(subject);
    }


}
