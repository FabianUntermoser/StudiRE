package persistence;

import business.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentRepository {

    public static List<Student> getStudents(EntityManager entityManager) {
        TypedQuery<Student> query = entityManager.createNamedQuery(Student.findAll, Student.class);
        return query.getResultList();
    }

    public static void addStudent(EntityManager entityManager, Student student) {
        entityManager.persist(student);
    }

    public static void removeStudent(EntityManager entityManager, Student student) {
        entityManager.remove(entityManager.contains(student) ? student : entityManager.merge(student));
    }

    public static void updateStudent(EntityManager entityManager, Student student) {
        entityManager.merge(student);
    }
}
