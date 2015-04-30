package tw.edu.ncu.cc.activity.server.service

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import tw.edu.ncu.cc.activity.server.entity.PlanEntity

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Service
public class PlanServiceImpl implements PlanService {

    @PersistenceContext
    def EntityManager entityManager

    @Override
    @Cacheable( value = "production", key = "'plan:' + #id" )
    public PlanEntity findById( Integer id ) {
        getEntityManager().find( PlanEntity.class, id )
    }

}
