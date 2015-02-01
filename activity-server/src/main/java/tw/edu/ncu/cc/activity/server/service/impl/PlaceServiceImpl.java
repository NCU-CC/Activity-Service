package tw.edu.ncu.cc.activity.server.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tw.edu.ncu.cc.activity.server.entity.PlaceEntity;
import tw.edu.ncu.cc.activity.server.service.PlaceService;

@Service
public class PlaceServiceImpl extends ApplicationService implements PlaceService {

    @Override
    @Cacheable( value = "production", key = "'place:' + #id" )
    public PlaceEntity getPlace( int id ) {
        return getEntityManager().find( PlaceEntity.class, id );
    }

}
