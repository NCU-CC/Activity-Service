package tw.edu.ncu.cc.activity.server.repository.impl;

import org.springframework.stereotype.Repository;
import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity;
import tw.edu.ncu.cc.activity.server.repository.AnnounceRepository;
import tw.edu.ncu.cc.activity.server.repository.impl.base.EntityManagerBean;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Repository
public class AnnounceRepositoryImpl extends EntityManagerBean implements AnnounceRepository {

    @Override
    public List< AnnounceEntity > getLatestCommonAnnounces( Date dateNow, int limit ) {
        return getEntityManager()
                .createQuery(
                        "SELECT announce FROM AnnounceEntity announce " +
                        "WHERE announce.type = '一般' AND announce.disabled = false " +
                        "AND ( announce.deadTime IS NULL OR :dateNow <= announce.deadTime )"+
                        "ORDER BY announce.time DESC", AnnounceEntity.class )
                .setParameter( "dateNow", dateNow, TemporalType.DATE )
                .setMaxResults( limit )
                .getResultList();
    }

    @Override
    public List< AnnounceEntity > getLatestGroupAnnounces( Date dateNow, int limit ) {
        return getEntityManager()
                .createQuery(
                        "SELECT announce FROM AnnounceEntity announce " +
                                "WHERE announce.type = '組務' AND announce.disabled = false " +
                                "AND ( announce.deadTime IS NULL OR :dateNow <= announce.deadTime )" +
                                "ORDER BY announce.time DESC", AnnounceEntity.class )
                .setParameter( "dateNow", dateNow, TemporalType.DATE )
                .setMaxResults( limit )
                .getResultList();
    }

}
