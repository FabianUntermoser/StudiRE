package business.service;

import business.domain.Student;
import persistence.StudentRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless
public class StudentService implements Serializable {

    @EJB
    private StudentRepository studentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Student> getAllStudents() {
        studentRepository.setEntityManager(entityManager);
        return studentRepository.getStudents();
    }

    public void addStudent(Student student) {
        studentRepository.setEntityManager(entityManager);
        studentRepository.addStudent(student);
    }

    public void removeStudent(Student student) {
        studentRepository.setEntityManager(entityManager);
        studentRepository.removeStudent(student);
    }

}
