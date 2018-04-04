package business.service;

import business.model.Student;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class StudentService {

    public List<Student> getAllStudents() {
        return createTestStudents();
    }

    private List<Student> createTestStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Fabian", "Untermoser", 6460, "Street 1", "Tirol"));
        students.add(new Student("Daniel", "Ertl", 6460, "Street 2", "Tirol"));
        students.add(new Student("Oliver", "Guder", 6460, "Street 3", "Tirol"));
        return students;
    }

}
