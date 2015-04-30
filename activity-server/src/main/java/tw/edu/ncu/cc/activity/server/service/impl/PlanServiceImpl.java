package tw.edu.ncu.cc.activity.server.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tw.edu.ncu.cc.activity.server.entity.PlanEntity;
import tw.edu.ncu.cc.activity.server.service.PlanService;

@Service
public class PlanServiceImpl extends ApplicationService implements PlanService {

    @Override
    @Cacheable( value = "production", key = "'plan:' + #id" )
    public PlanEntity findPlanById( Integer id ) {
        return getEntityManager().find( PlanEntity.class, id );
    }

}
