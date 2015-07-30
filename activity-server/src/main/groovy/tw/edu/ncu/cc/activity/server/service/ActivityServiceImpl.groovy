package tw.edu.ncu.cc.activity.server.service

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import tw.edu.ncu.cc.activity.server.entity.ActivityEntity

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.TemporalType

@Service
public class ActivityServiceImpl implements ActivityService {

    @PersistenceContext
    def EntityManager entityManager

    @Override
    @Cacheable( value = "production", key = "'activitiesLatest:' + #limit" )
    public List< ActivityEntity > findByStartDateOlderThan( Date startDate, int limit ) {
        getEntityManager()
                .createQuery(
                        "SELECT activity FROM ActivityEntity activity " +
                        "WHERE activity.date >= :startDate " +
                        "ORDER BY activity.date ASC ", ActivityEntity.class )
                .setParameter( "startDate", new java.sql.Date( startDate.getTime() ), TemporalType.DATE )
                .setMaxResults( limit )
                .getResultList()
    }

}
