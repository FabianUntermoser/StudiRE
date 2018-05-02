package business.service;

import business.domain.NextMatriculationNumberGenerator;
import business.domain.Student;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Singleton
public class MatriculationNumberService {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        setLastMatriculationNumber();
    }

    private void setLastMatriculationNumber() {
        TypedQuery<Long> query = entityManager.createNamedQuery(Student.findLastMatriculationNumber, Long.class).setMaxResults(1);
        if (!query.getResultList().isEmpty()) {
            NextMatriculationNumberGenerator.initialize(query.getSingleResult());
        }
    }

    public long generateNextNumber() {
        return NextMatriculationNumberGenerator.generateNextNumber();
    }

}
