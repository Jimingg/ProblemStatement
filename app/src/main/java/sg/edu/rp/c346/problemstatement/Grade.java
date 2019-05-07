package sg.edu.rp.c346.problemstatement;

import java.io.Serializable;

public class Grade implements Serializable {
    private String week;
    private String grade;

    public String getWeek() {
        return week;
    }

    public String getGrade() {
        return grade;
    }

    public Grade(String week, String grade) {
        this.week = week;
        this.grade = grade;
    }
}
