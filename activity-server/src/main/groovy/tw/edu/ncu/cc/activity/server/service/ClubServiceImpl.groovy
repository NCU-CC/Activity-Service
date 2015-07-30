package tw.edu.ncu.cc.activity.server.service

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import tw.edu.ncu.cc.activity.server.entity.ClubEntity

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Service
public class ClubServiceImpl implements ClubService {

    @PersistenceContext
    def EntityManager entityManager

    @Override
    @Cacheable( value = "production", key = "'club:' + #id" )
    public ClubEntity findById( String id ) {
        getEntityManager().find( ClubEntity.class, id )
    }

    @Override
    @Cacheable( value = "production", key = "'clubAll'" )
    public List< ClubEntity > findAll() {
        getEntityManager()
                .createQuery( "SELECT club FROM ClubEntity club", ClubEntity.class )
                .getResultList()
    }

}
