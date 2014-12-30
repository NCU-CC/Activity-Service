package tw.edu.ncu.cc.activity.server.repository.impl;

import org.springframework.stereotype.Repository;
import tw.edu.ncu.cc.activity.server.entity.ActivityEntity;
import tw.edu.ncu.cc.activity.server.repository.ActivityRepository;
import tw.edu.ncu.cc.activity.server.repository.impl.base.EntityManagerBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class ActivityRepositoryImpl extends EntityManagerBean implements ActivityRepository {

    private SimpleDateFormat dateFormater = new SimpleDateFormat( "yyyy-MM-dd" );

    @Override
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
