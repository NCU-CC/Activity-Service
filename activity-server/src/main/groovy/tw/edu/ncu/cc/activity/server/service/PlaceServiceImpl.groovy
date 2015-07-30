package tw.edu.ncu.cc.activity.server.service

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import tw.edu.ncu.cc.activity.server.entity.PlaceEntity

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Service
public class PlaceServiceImpl implements PlaceService {

    @PersistenceContext
    def EntityManager entityManager

    @Override
    @Cacheable( value = "production", key = "'place:' + #id" )
    public PlaceEntity findById( int id ) {
        getEntityManager().find( PlaceEntity.class, id )
    }

}
