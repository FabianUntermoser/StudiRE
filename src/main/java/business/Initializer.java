package business;

import business.factories.NextMatriculationNumberGenerator;
import business.model.Student;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Singleton
@Startup
public class Initializer {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        TypedQuery<Long> query = entityManager.createNamedQuery(Student.findLastMatriculationNumber, Long.class).setMaxResults(1);
        NextMatriculationNumberGenerator.initialize(query.getSingleResult());
    }


}
