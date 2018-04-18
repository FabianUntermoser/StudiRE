package business.service;

import business.domain.Student;
import persistence.StudentRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudentService implements IStudentService {

    @EJB
    private StudentRepository studentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        studentRepository.setEntityManager(entityManager);
        return studentRepository.getStudents();
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.setEntityManager(entityManager);
        studentRepository.addStudent(student);
    }

    @Override
    public void removeStudent(Student student) {
        studentRepository.setEntityManager(entityManager);
        studentRepository.removeStudent(student);
    }


}
