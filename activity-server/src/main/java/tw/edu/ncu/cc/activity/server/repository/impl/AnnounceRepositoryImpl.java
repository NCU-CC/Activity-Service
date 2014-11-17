package tw.edu.ncu.cc.activity.server.repository.impl;

import org.springframework.stereotype.Repository;
import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity;
import tw.edu.ncu.cc.activity.server.repository.AnnounceRepository;
import tw.edu.ncu.cc.activity.server.repository.impl.base.EntityManagerBean;

import javax.persistence.TemporalType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class AnnounceRepositoryImpl extends EntityManagerBean implements AnnounceRepository {

    private static Date zeroDate = dateZero();

    private static Date dateZero() {
        try {
            return new SimpleDateFormat( "yyyy-MM-dd" ).parse( "0001-01-01" );
        } catch ( ParseException e ) {
            throw new RuntimeException( "cannot convert date zero", e );
        }
    }

    @Override
    public List< AnnounceEntity > getLatestCommonAnnounces( Date dateNow, int limit ) {
        return getLatestAnnounce( "一般", dateNow, limit );
    }

    @Override
    public List< AnnounceEntity > getLatestGroupAnnounces( Date dateNow, int limit ) {
        return getLatestAnnounce( "組務", dateNow, limit );
    }

    @Override
    public List< AnnounceEntity > getCommonAnnouncesNewerThan( int id, Date dateNow, int limit ) {
        return getAnnounceNewerThan( "一般", id, dateNow, limit );
    }

    @Override
    public List< AnnounceEntity > getGroupAnnouncesNewerThan( int id, Date dateNow, int limit ) {
        return getAnnounceNewerThan( "組務", id, dateNow, limit );
    }

    @Override
    public List< AnnounceEntity > getCommonAnnouncesOlderThan( int id, Date dateNow, int limit ) {
        return getAnnounceOlderThan( "一般", id, dateNow, limit );
    }

    @Override
    public List< AnnounceEntity > getGroupAnnouncesOlderThan( int id, Date dateNow, int limit ) {
        return getAnnounceOlderThan( "組務", id, dateNow, limit );
    }

    private List<AnnounceEntity> getLatestAnnounce( String type, Date dateNow, int limit ) {
        return getEntityManager()
                .createQuery(
                        "SELECT announce FROM AnnounceEntity announce " +
                                "WHERE announce.type = :announceType " +
                                "AND announce.disabled = false " +
                                "AND ( " +
                                    "announce.deadTime IS NULL OR " +
                                    "announce.deadTime < :dateZero OR" +
                                    ":dateNow <= announce.deadTime )" +
                                "ORDER BY announce.time DESC", AnnounceEntity.class )
                .setParameter( "announceType", type )
                .setParameter( "dateZero", zeroDate, TemporalType.DATE )
                .setParameter( "dateNow",  dateNow,  TemporalType.DATE )
                .setMaxResults( limit )
                .getResultList();
    }

    private List<AnnounceEntity> getAnnounceNewerThan( String type, int id, Date dateNow, int limit ) {
        AnnounceEntity announce = getEntityManager().find( AnnounceEntity.class, id );
        if( announce == null ) {
            return null;
        } else {
            return getEntityManager()
                    .createQuery(
                            "SELECT announce FROM AnnounceEntity announce " +
                                    "WHERE announce.type = :announceType " +
                                    "AND announce.disabled = false " +
                                    "AND ( " +
                                        "announce.deadTime IS NULL OR " +
                                        "announce.deadTime < :dateZero OR " +
                                        ":dateNow <= announce.deadTime )" +
                                    "AND ( " +
                                        "announce.time > :time OR " +
                                        "( announce.time = :time AND announce.id > :id ) ) " +
                                    "AND announce.id <> :id " +
                                    "ORDER BY announce.time DESC , announce.id DESC ", AnnounceEntity.class )
                    .setParameter( "announceType", type )
                    .setParameter( "dateZero", zeroDate, TemporalType.DATE )
                    .setParameter( "dateNow",  dateNow,  TemporalType.DATE )
                    .setParameter( "time", announce.getTime(), TemporalType.DATE )
                    .setParameter( "id", announce.getId() )
                    .setMaxResults( limit )
                    .getResultList();
        }
    }

    private List<AnnounceEntity> getAnnounceOlderThan( String type, int id, Date dateNow, int limit ) {
        AnnounceEntity announce = getEntityManager().find( AnnounceEntity.class, id );
        if( announce == null ) {
            return null;
        } else {
            return getEntityManager()
                    .createQuery(
                            "SELECT announce FROM AnnounceEntity announce " +
                                    "WHERE announce.type = :announceType " +
                                    "AND announce.disabled = false " +
                                    "AND ( " +
                                        "announce.deadTime IS NULL OR " +
                                        "announce.deadTime < :dateZero OR " +
                                        ":dateNow <= announce.deadTime )" +
                                    "AND ( " +
                                        "announce.time < :time OR " +
                                        "( announce.time = :time AND announce.id < :id ) ) " +
                                    "ORDER BY announce.time DESC , announce.id DESC ", AnnounceEntity.class )
                    .setParameter( "announceType", type )
                    .setParameter( "dateZero", zeroDate, TemporalType.DATE )
                    .setParameter( "dateNow",  dateNow,  TemporalType.DATE )
                    .setParameter( "time", announce.getTime(), TemporalType.DATE )
                    .setParameter( "id", announce.getId() )
                    .setMaxResults( limit )
                    .getResultList();
        }
    }

}
