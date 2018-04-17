package business.service;

import business.model.Student;
import persistence.StudentRepository;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Stateless
public class StudentService implements Serializable {

    @Inject
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.getStudents();
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void removeStudent(Student student) {
        studentRepository.removeStudent(student);
    }

    @PostConstruct
    private void initializeRepository() {
        studentRepository.addStudent(new Student("Fabian", "Untermoser", 6460, "Street 1", "Tirol"));
        studentRepository.addStudent(new Student("Daniel", "Ertl", 6460, "Street 2", "Tirol"));
        studentRepository.addStudent(new Student("Oliver", "Guder", 6460, "Street 3", "Tirol"));
    }
}
