package tw.edu.ncu.cc.activity.server.repository.impl;

import org.springframework.stereotype.Repository;
import tw.edu.ncu.cc.activity.server.entity.ActivityEntity;
import tw.edu.ncu.cc.activity.server.repository.ActivityRepository;
import tw.edu.ncu.cc.activity.server.repository.impl.base.EntityManagerBean;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Repository
public class ActivityRepositoryImpl extends EntityManagerBean implements ActivityRepository {

    @Override
    public List< ActivityEntity > getLatestActivities( Date startDate, int limit ) {
        return getEntityManager()
                .createQuery(
                        "SELECT activity FROM ActivityEntity activity " +
                        "WHERE activity.startDate >= :startDate " +
                        "ORDER BY activity.startDate ASC ", ActivityEntity.class )
                .setParameter( "startDate", startDate, TemporalType.DATE )
                .setMaxResults( limit )
                .getResultList();
    }

}
