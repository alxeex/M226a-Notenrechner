package ch.tbz;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Formatieren: Ctr + alt + l
 */
public class Menu {
    private User user = null;
    private final Scanner scan = new Scanner(System.in);
    private final AuthService auth = new AuthService();
    EditorService editorService = new EditorService();
    PreviewService previewService = new PreviewService();
    private int markId = 0;
    private int subjectId = 0;

    /**
     * Hardcode of the data: inital
     * Delete me when Programm finished
     */
    private void initialData() {
        Semester first = editorService.createSemester("1");
        Semester second = editorService.createSemester("2");

        MySubject math1 = editorService.createSubject(10, "Mathe", "1");
        MySubject german1 = editorService.createSubject(11, "Deutsch", "1");
        MySubject english1 = editorService.createSubject(12, "Englisch", "1");
        MySubject physics1 = editorService.createSubject(13, "Physik", "1");
        MySubject math2 = editorService.createSubject(14, "Mathe", "2");
        MySubject german2 = editorService.createSubject(15, "Deutsch", "2");
        MySubject english2 = editorService.createSubject(16, "Englisch", "2");

        previewService.createMark(6, 2.3f, 2, german1, first.getSemester());
        previewService.createMark(7, 5.2f, 2, english1, first.getSemester());
        previewService.createMark(9, 6.0f, 2, math1, second.getSemester());
        previewService.createMark(9, 5.25f, 2, math1, second.getSemester());
        previewService.createMark(9, 4.6f, 2, math1, second.getSemester());
        previewService.createMark(9, 3.2f, 2, math1, second.getSemester());
        previewService.createMark(9, 6.0f, 2, math1, second.getSemester());
        previewService.createMark(10, 4.5f, 2, math1, second.getSemester());
        previewService.createMark(10, 1f, 3, math1, second.getSemester());
        previewService.createMark(10, 2f, 3, math1, second.getSemester());

        previewService.createMark(6, 5.3f, 2, german2, first.getSemester());
        previewService.createMark(7, 2.2f, 2, english2, first.getSemester());
        previewService.createMark(6, 4.3f, 2, german2, first.getSemester());
        previewService.createMark(7, 3.2f, 2, english2, first.getSemester());
        previewService.createMark(6, 5.1f, 2, german2, first.getSemester());
        previewService.createMark(7, 4.0f, 2, english2, first.getSemester());
        previewService.createMark(9, 6.0f, 2, math2, second.getSemester());

    }


    public void Run() {
        initialData();
        while (true) {
            if (user != null) {
                if (user.isLoggedIn()) {
                    showWhenLoggedIn(user.isAdmin());
                }
            }
            showWhenLoggedout();
        }
    }

    //Admin Menu
    private void showWhenLoggedIn(boolean isAdmin) {
        try {
            do {
                System.out.println();
                System.out.println("*****************************");
                System.out.println("Bitte wählen sie:");
                System.out.println("x: exit");
                if (isAdmin) {
                    //When User is Admin (Teacher) show Admin-Menu
                    printAdminMenu();
                } else {
                    //When User is not Admin(Student) show User-Menu
                    printUserMenu();
                }
                //Logout
                String input = scan.next();
                if (input.equals("x")) {
                    System.out.println("Wir wünschen einen schönen Tag!");
                    auth.Logout(user.getId());
                }

                //Admin Switch Case
                if (isAdmin) {
                    switch (input) {
                        case "cse":
                                System.out.println("create Semester");
                                createSemester();
                            break;
                        case "csu":
                            if(!arrayIsEmpty(editorService.getAllSemesters(), "Semester")){
                                System.out.println("create Subject");
                                createSubject();
                            }
                            break;
                        case "cm":
                            if (!arrayIsEmpty(editorService.getAllSubjects(), "Themen") && !arrayIsEmpty(editorService.getAllSemesters(), "Semester")) {
                                System.out.println("Create Mark");
                                createMark();
                            }
                            break;
                        case "gse":
                            getSemesters();
                            break;
                        case "gsu":
                            this.printSubjects();
                            break;
                        case "gm":
                            this.getMarks();
                            break;
                        case "dse":
                            deleteSemester();
                            break;
                        case "dsu":
                            deleteSubject();
                            break;
                        case "dm":
                            deleteMark();
                            break;
                        case "x":
                            break;
                        default:
                            System.out.println("Eingabe nicht korrekt!");
                    }
                } else {
                    // For User(Student)
                    if (input.equals("r")) {
                        if (!arrayIsEmpty(previewService.getMarks(user.getId()), "Noten")) {
                            System.out.println("deine Noten");
                            printMarkProSemesterWithAvg();
                        }
                    } else {
                        System.out.println("Eingabe nicht korrekt!");
                    }
                }
            } while (user.isLoggedIn());
        } catch (Exception e) {
            System.out.println("Ein Fehler ist aufgetreten" + e);
        }
    }

    //UserMenu (print options)
    private void printUserMenu() {
        System.out.println("r: Noten anschauen");
    }

    //AdminMenu (print options)
    private void printAdminMenu() {
        System.out.println("cse: createSemester");
        System.out.println("csu: createSubject");
        System.out.println("cm: createMarks");
        System.out.println("gse: getSemesters");
        System.out.println("gsu: getSubjects");
        System.out.println("gm: getMarks");
        System.out.println("dse: deleteSemester");
        System.out.println("dsu: deleteSubject");
        System.out.println("dm: deleteMarks");
    }


    //Logout
    private void exit() {
        System.out.println("Wir wünschen ihnen einen schönen Tag!");
        if (user != null)
            auth.Logout(user.getId());
        System.exit(0);
    }

    //Menu when User logged out
    private void showWhenLoggedout() {
        do {
            GetTime myapi = new GetTime();
            myapi.getFromAPI();
            myapi.showAPIInfo();
            System.out.println("Bitte wählen sie:");
            System.out.println("e: Einloggen");
            System.out.println("x: Beenden");
            var input = scan.next();
            if (input.equals("x")) {
                exit();
            } else if (input.equals("e")) {
                System.out.print("Geben sie den Benutzernamen ein: ");
                var un = scan.next();
                System.out.print("Geben sie ihr Passwort ein: ");
                var pw = scan.next();
                user = auth.Login(un, pw);
            } else {
                System.out.println("Eingabe nicht korrekt!");
            }
        } while (user == null);
    }

    //Choose Semester
    private String chooseSemester() {
        for (Semester semester : editorService.getAllSemesters()) {
            System.out.println(semester.getSemester());
        }
        System.out.println("Wähle ein Semester z.B 1");
        return scan.next();
    }

    //Choose Subject
    private int chooseSubject(String semesterName) {
        for (MySubject subject : editorService.getAllSubjects()) {
            if (semesterName.equals(subject.getSemester())){
                System.out.println(subject.getId() + " : " + subject.getSubject());
            }
        }
        System.out.println("Wähle eine Thema");
        return Integer.parseInt(scan.next());
    }

    //Choose User
    private int chooseUser() {
        for (User user : auth.getUsers()) {
            if (!user.isAdmin()) {
                System.out.println(user.getId() + " : " + user.getName());
            }
        }
        System.out.println("Wähle einen User");
        return Integer.parseInt(scan.next());
    }

    //Choose Mark
    private int chooseMark(ArrayList<Mark> marks) {
        printMarks(marks);
        System.out.println("Wähle eine Note");
        return Integer.parseInt(scan.next());
    }

    //Print all Subjects
    private void printSubjects() {
        for(Semester semester: editorService.getAllSemesters()){
            System.out.println("Semester:" + semester.getSemester());
            for (MySubject subject : semester.getMySubjects()) {
                System.out.println("------");
                System.out.println("id: " + subject.getId());
                System.out.println("Fach: " + subject.getSubject());
                //printMarks(subject.getMarks());
            }
        }
    }

    //Print all marks
    private void printMarks(ArrayList<Mark> marks) {
        for (Mark mark : marks) {
            System.out.println(mark.getId() + " : " + mark.getValue() + " from " + auth.getUserById(mark.getUserId()).getName());
        }
    }

    //Menu create new semester
    private void createSemester() {
        System.out.println("Wie heisst dein Semester? z.B. Herbst-2022");
        String semesterName = scan.next();
        Semester semester = editorService.createSemester(semesterName);
        System.out.println("Semester: " + semester.getSemester() + " erstellt");
    }

    //Menu create Subject
    private void createSubject() {
        System.out.println("Wie heisst dein Thema? z.B. M226");
        String subjectName = scan.next();
        this.subjectId += 1;
        MySubject subject = editorService.createSubject(subjectId, subjectName, chooseSemester());
        System.out.println("Semester: " + subject.getSubject() + " erstellt");
    }

    //Menu create Mark
    private void createMark() {
        this.markId += 1;
        System.out.println("Für wen ist die Note? z.B. Julian");
        int userId = this.chooseUser();
        String semesterName = this.chooseSemester();
        int subjectId = this.chooseSubject(semesterName);
        MySubject subject = editorService.getSubjectById(subjectId);
        float value;
        do {
            System.out.println("Was ist die Note? z.B. 4.5");
            value = Float.parseFloat(scan.next());
        } while (value < 1 || value > 6);

        Mark mark = previewService.createMark(this.markId, value, userId, subject, semesterName);
        System.out.println("Note erstellt:");
        System.out.println("User: " + auth.getUserById(userId).getName());
        System.out.println("Note: " + mark.getValue());
        System.out.println("Thema: " + mark.getSubject());
    }

    //Menu get Semester
    private void getSemesters() {
        for (Semester semester : editorService.getAllSemesters()) {
            System.out.println("----------");
            System.out.println("semester: " + semester.getSemester());
            for (MySubject mySubject : semester.getMySubjects()) {
                System.out.println("Fach: " + mySubject.getSubject());
            }
        }
    }

    //Output Marks
    private void getMarks() {
        for (Mark mark : previewService.getAllMarks()) {
            System.out.println(mark.getSemester() + " : " + auth.getUserById(mark.getUserId()).getName() + " : " + mark.getSubject() + " : " + mark.getValue());
        }
    }

    //Delete Subject
    private void deleteSubject() {
        String semesterName = this.chooseSemester();
        int subjectId = this.chooseSubject(semesterName);
        editorService.deleteSubject(subjectId);
        System.out.println("Thema " + subjectId + " wurde gelöscht");
    }

    //Delete Semester
    private void deleteSemester() {
        String semesterName = this.chooseSemester();
        editorService.deleteSemester(semesterName);
        System.out.println("Semester " + semesterName + " wurde gelöscht");
    }

    //Delete Mark
    private void deleteMark() {
        int markId = this.chooseMark(previewService.getAllMarks());
        previewService.deleteMark(markId);
        System.out.println("Die Note mit der id " + markId + " wurde gelöscht");
    }

    private boolean arrayIsEmpty(ArrayList array, String name) {
        if (array.isEmpty()) {
            System.out.println("Sie haben noch keine " + name);
            return true;
        }
        return false;
    }

    //Print Mark Pro Semester with Average
    private void printMarkProSemesterWithAvg() {
        for (Semester semester: editorService.getAllSemesters()){
            System.out.println("***************************************");
            System.out.println("SEMSTER: " + semester.getSemester());
            for (MySubject subject: semester.getMySubjects()) {
                System.out.println("Thema: " + subject.getSubject());
                float summOfMarks = 0f;
                int countMarks = 0;
                // Alle Noten ausgeben und Durchschnitt Berechnen
                for (Mark mark: subject.getMarks()) {
                    if (previewService.getMarks(user.getId()).contains(mark)) {
                        countMarks++;
                        System.out.println("Note " + countMarks + ": " + mark.getValue());
                        summOfMarks += mark.getValue();
                    }
                }
                if (countMarks > 0){
                    System.out.println("Durchschnitt: " + summOfMarks / countMarks + "\n");
                } else {
                    System.out.println("Keine Noten Vorhanden");
                }
            }
        }
    }
}
