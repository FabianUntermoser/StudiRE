package business.service;

import business.model.Student;
import persistence.StudentRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@SessionScoped
public class StudentService implements Serializable {

    public List<Student> getAllStudents() {
        System.out.println("Students requestd");
        return StudentRepository.getStudents();
    }

    public void addStudent(Student student) {
        StudentRepository.addStudent(student);
    }

    public void removeStudent(Student student) {
        StudentRepository.removeStudent(student);
    }

    @PostConstruct
    private void initializeRepository() {
        StudentRepository.addStudent(new Student("Fabian", "Untermoser", 6460, "Street 1", "Tirol"));
        StudentRepository.addStudent(new Student("Daniel", "Ertl", 6460, "Street 2", "Tirol"));
        StudentRepository.addStudent(new Student("Oliver", "Guder", 6460, "Street 3", "Tirol"));
    }
}
