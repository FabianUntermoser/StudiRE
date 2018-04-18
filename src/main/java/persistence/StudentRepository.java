package persistence;

import business.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class StudentRepository implements Serializable {

    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Student> getStudents() {
        TypedQuery<Student> query = entityManager.createNamedQuery(Student.findAll, Student.class);
        return query.getResultList();
    }

    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    public void removeStudent(Student student) {
        entityManager.remove(student);
    }

}
