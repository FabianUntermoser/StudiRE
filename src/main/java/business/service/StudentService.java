package business.service;

import business.model.Student;
import persistence.StudentRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Stateless
public class StudentService implements Serializable {

    @EJB
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

}
