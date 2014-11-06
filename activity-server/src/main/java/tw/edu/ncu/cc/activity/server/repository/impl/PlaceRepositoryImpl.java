package tw.edu.ncu.cc.activity.server.repository.impl;

import org.springframework.stereotype.Repository;
import tw.edu.ncu.cc.activity.server.entity.PlaceEntity;
import tw.edu.ncu.cc.activity.server.repository.PlaceRepository;
import tw.edu.ncu.cc.activity.server.repository.impl.base.EntityManagerBean;

@Repository
public class PlaceRepositoryImpl extends EntityManagerBean implements PlaceRepository {

    @Override
    public PlaceEntity getPlace( int id ) {
        return getEntityManager().find( PlaceEntity.class, id );
    }

}
