package co.edu.uptc.model;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{
    public int compare(Student a, Student b) {
        return a.getCode() - b.getCode();
    }
}
