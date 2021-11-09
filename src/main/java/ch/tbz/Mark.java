package ch.tbz;

public class Mark {
    private int id;
    private float value;
    private int userId;
    private String subject;
    private String semester;
    private String germanName = "Noten";

    public Mark(int id, float value, int userId, String subject, String semester) {
        this.id = id;
        this.value = value;
        this.userId = userId;
        this.subject = subject;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
