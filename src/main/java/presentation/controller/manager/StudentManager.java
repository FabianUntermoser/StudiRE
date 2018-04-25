package presentation.controller.manager;

import business.domain.Student;

public class StudentManager {

    private static Student selectedStudent;

    public static Student getSelectedStudent() {
        return selectedStudent;
    }

    public static void setSelectedStudent(Student selectedStudent) {
        StudentManager.selectedStudent = selectedStudent;
    }
}
