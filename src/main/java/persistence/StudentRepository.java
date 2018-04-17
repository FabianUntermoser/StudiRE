package persistence;

import business.model.Student;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StudentRepository implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

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
