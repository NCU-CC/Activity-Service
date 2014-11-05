package tw.edu.ncu.cc.activity.server.repository.impl;

import org.springframework.stereotype.Repository;
import tw.edu.ncu.cc.activity.server.entity.ClubEntity;
import tw.edu.ncu.cc.activity.server.repository.ClubRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClubRepositoryImpl implements ClubRepository {


    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager( EntityManager entityManager ) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ClubEntity> getAllClubs() {
        return entityManager
                .createQuery( "SELECT club FROM ClubEntity club", ClubEntity.class )
                .getResultList();
    }

}
