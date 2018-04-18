package business.service;

import business.domain.Student;
import persistence.StudentRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudentService implements IStudentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        return StudentRepository.getStudents(entityManager);
    }

    @Override
    public void addStudent(Student student) {
        StudentRepository.addStudent(entityManager, student);
    }

    @Override
    public void removeStudent(Student student) {
        StudentRepository.removeStudent(entityManager, student);
    }


}
