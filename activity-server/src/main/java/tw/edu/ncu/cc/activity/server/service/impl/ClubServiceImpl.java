package tw.edu.ncu.cc.activity.server.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tw.edu.ncu.cc.activity.server.entity.ClubEntity;
import tw.edu.ncu.cc.activity.server.service.ClubService;

import java.util.List;

@Service
public class ClubServiceImpl extends ApplicationService implements ClubService {

    @Override
    @Cacheable( value = "production", key = "'club:' + #id" )
    public ClubEntity getClub( String id ) {
        return getEntityManager().find( ClubEntity.class, id );
    }

    @Override
    @Cacheable( value = "production", key = "'clubAll'" )
    public List< ClubEntity > getAllClubs() {
        return getEntityManager()
                .createQuery( "SELECT club FROM ClubEntity club", ClubEntity.class )
                .getResultList();
    }

}
