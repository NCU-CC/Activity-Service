package tw.edu.ncu.cc.activity.server.service.impl;

import org.springframework.stereotype.Repository;
import tw.edu.ncu.cc.activity.server.entity.PlaceEntity;
import tw.edu.ncu.cc.activity.server.service.PlaceService;

@Repository
public class PlaceServiceImpl extends ApplicationService implements PlaceService {

    @Override
    public PlaceEntity getPlace( int id ) {
        return getEntityManager().find( PlaceEntity.class, id );
    }

}
