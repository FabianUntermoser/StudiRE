package business.service;

import business.domain.Student;
import persistence.StudentRepository;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RolesAllowed("Teacher")
@Stateless
public class StudentService implements IStudentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private MatriculationNumberService matriculationNumberService;

    @Inject
    private EmailValidationService emailValidationService;

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
        Student oldStudent = StudentRepository.getStudentById(entityManager, student.getMatriculationNumber());
        checkEmailValidation(oldStudent, student);
        StudentRepository.updateStudent(entityManager, student);
    }

    private void checkEmailValidation(Student oldStudent, Student newStudent) {
        String oldEmail = oldStudent.getEmail();
        String newEmail = newStudent.getEmail();
        if (oldEmail != null && newEmail != null &&
                !oldEmail.equals(newEmail)) {
            emailValidationService.validateEmail(newEmail);
        }
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return StudentRepository.findStudentsByName(entityManager, name);
    }

    private void initializeStudentMatriculationNumber(Student student) {
        if (student.getMatriculationNumber() == 0L) {
            long matriculationNumber = matriculationNumberService.generateNextNumber();
            student.setMatriculationNumber(matriculationNumber);
        }
    }

}
