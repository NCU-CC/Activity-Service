package tw.edu.ncu.cc.activity.server.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import tw.edu.ncu.cc.activity.server.entity.ActivityEntity;
import tw.edu.ncu.cc.activity.server.service.ActivityService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class ActivityServiceImpl extends ApplicationService implements ActivityService {

    private SimpleDateFormat dateFormater = new SimpleDateFormat( "yyyy-MM-dd" );

    @Override
    @Cacheable( value = "production", key = "'activitiesLatest:' + #limit" )
    public List< ActivityEntity > getLatestActivities( Date startDate, int limit ) {
        return getEntityManager()
                .createQuery(
                        "SELECT activity FROM ActivityEntity activity " +
                        "WHERE activity.startDate >= :startDate " +
                        "ORDER BY activity.startDate ASC ", ActivityEntity.class )
                .setParameter( "startDate", dateFormater.format( startDate ) )
                .setMaxResults( limit )
                .getResultList();
    }

}
