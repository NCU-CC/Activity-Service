package tw.edu.ncu.cc.activity.server.service.impl;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ApplicationService {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager( EntityManager entityManager ) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
