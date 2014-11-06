package tw.edu.ncu.cc.activity.server.repository.impl;

import org.springframework.stereotype.Repository;
import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity;
import tw.edu.ncu.cc.activity.server.repository.AnnounceRepository;
import tw.edu.ncu.cc.activity.server.repository.impl.base.EntityManagerBean;

import java.util.List;

@Repository
public class AnnounceRepositoryImpl extends EntityManagerBean implements AnnounceRepository {

    @Override
    public List< AnnounceEntity > getLatestCommonAnnounces( int limit ) {
        return getEntityManager()
                .createQuery(
                        "SELECT announce FROM AnnounceEntity announce " +
                        "WHERE announce.type = '一般' AND announce.disabled = false " +
                        "ORDER BY announce.time DESC", AnnounceEntity.class )
                .setMaxResults( limit )
                .getResultList();
    }

    @Override
    public List< AnnounceEntity > getLatestGroupAnnounces( int limit ) {
        return getEntityManager()
                .createQuery(
                        "SELECT announce FROM AnnounceEntity announce " +
                        "WHERE announce.type = '組務' AND announce.disabled = false " +
                        "ORDER BY announce.time DESC", AnnounceEntity.class )
                .setMaxResults( limit )
                .getResultList();
    }

}
