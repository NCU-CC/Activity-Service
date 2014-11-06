package tw.edu.ncu.cc.activity.server.repository.impl;

import org.springframework.stereotype.Repository;
import tw.edu.ncu.cc.activity.server.entity.ClubEntity;
import tw.edu.ncu.cc.activity.server.repository.ClubRepository;
import tw.edu.ncu.cc.activity.server.repository.impl.base.EntityManagerBean;

import java.util.List;

@Repository
public class ClubRepositoryImpl extends EntityManagerBean implements ClubRepository {

    @Override
    public List<ClubEntity> getAllClubs() {
        return getEntityManager()
                .createQuery( "SELECT club FROM ClubEntity club", ClubEntity.class )
                .getResultList();
    }

}
