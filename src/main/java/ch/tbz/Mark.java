package ch.tbz;

import lombok.Getter;
import lombok.Setter;

public class Mark {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private float value;
    @Getter
    @Setter
    private int userId;
    @Getter
    @Setter
    private String subject;
    @Getter
    @Setter
    private String semester;
    @Getter
    @Setter
    private String germanName = "Noten";

    public Mark(int id, float value, int userId, String subject, String semester) {
        this.id = id;
        this.value = value;
        this.userId = userId;
        this.subject = subject;
        this.semester = semester;
    }


}
