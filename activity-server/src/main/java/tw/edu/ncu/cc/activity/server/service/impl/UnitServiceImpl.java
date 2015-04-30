package tw.edu.ncu.cc.activity.server.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tw.edu.ncu.cc.activity.server.entity.UnitEntity;
import tw.edu.ncu.cc.activity.server.service.UnitService;

@Service
public class UnitServiceImpl extends ApplicationService implements UnitService {

    @Override
    @Cacheable( value = "production", key = "'unit:' + #id" )
    public UnitEntity getUnitById( int id ) {
        return getEntityManager().find( UnitEntity.class, id );
    }

}
