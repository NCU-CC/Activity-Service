package tw.edu.ncu.cc.activity.server.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tw.edu.ncu.cc.activity.server.entity.ActivityEntity;
import tw.edu.ncu.cc.activity.server.service.ActivityService;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceImpl extends ApplicationService implements ActivityService {

    @Override
    @Cacheable( value = "production", key = "'activitiesLatest:' + #limit" )
    public List< ActivityEntity > getLatestActivities( Date startDate, int limit ) {
        return getEntityManager()
                .createQuery(
                        "SELECT activity FROM ActivityEntity activity " +
                        "WHERE activity.date >= :startDate " +
                        "ORDER BY activity.date ASC ", ActivityEntity.class )
                .setParameter( "startDate", new java.sql.Date( startDate.getTime() ), TemporalType.DATE )
                .setMaxResults( limit )
                .getResultList();
    }

}
