package tw.edu.ncu.cc.activity.server.service

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import tw.edu.ncu.cc.activity.server.entity.UnitEntity

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Service
public class UnitServiceImpl implements UnitService {

    @PersistenceContext
    def EntityManager entityManager

    @Override
    @Cacheable( value = "production", key = "'unit:' + #id" )
    public UnitEntity findById( int id ) {
        getEntityManager().find( UnitEntity.class, id )
    }

}
