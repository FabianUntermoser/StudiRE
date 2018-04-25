package business.service;

import business.MatriculationNumberService;
import business.domain.NextMatriculationNumberGenerator;
import business.domain.Student;
import persistence.StudentRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudentService implements IStudentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private MatriculationNumberService matriculationNumberService;

    @Override
    public List<Student> getAllStudents() {
        return StudentRepository.getStudents(entityManager);
    }

    @Override
    public void addStudent(Student student) {
        initializeStudentMatriculationNumber(student);
        StudentRepository.addStudent(entityManager, student);
    }

    @Override
    public void removeStudent(Student student) {
        StudentRepository.removeStudent(entityManager, student);
    }

    @Override
    public void updateStudent(Student student) {
        initializeStudentMatriculationNumber(student);
        StudentRepository.updateStudent(entityManager, student);
    }

    private void initializeStudentMatriculationNumber(Student student) {
        if (student.getMatriculationNumber() == 0L) {
            long matriculationNumber = matriculationNumberService.generateNextNumber();
            student.setMatriculationNumber(matriculationNumber);
        }
    }

}
