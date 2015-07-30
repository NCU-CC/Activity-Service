package tw.edu.ncu.cc.activity.server.service

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.TemporalType
import java.text.ParseException
import java.text.SimpleDateFormat

@Service
public class AnnounceServiceImpl implements AnnounceService {

    @PersistenceContext
    def EntityManager entityManager

    private static Date zeroDate = dateZero()

    private static Date dateZero() {
        try {
            return new SimpleDateFormat( "yyyy-MM-dd" ).parse( "0001-01-01" )
        } catch ( ParseException e ) {
            throw new RuntimeException( "cannot convert date zero", e )
        }
    }

    @Override
    @Cacheable( value = "production", key = "'announcesCommonLatest:' + #limit" )
    public List< AnnounceEntity > findCommonByDateOlderThan( Date dateNow, int limit ) {
        getLatestAnnounce( "一般", dateNow, limit )
    }

    @Override
    @Cacheable( value = "production", key = "'announcesGroupLatest:' + #limit" )
    public List< AnnounceEntity > findGroupByDateOlderThan( Date dateNow, int limit ) {
        getLatestAnnounce( "組務", dateNow, limit )
    }

    @Override
    @Cacheable( value = "production", key = "'announcesCommonNewer:' + #limit + '/' + #id" )
    public List< AnnounceEntity > findCommonByNewerThanIdAndDeadTimeOlderThan( int id, Date dateNow, int limit ) {
        getAnnounceNewerThan( "一般", id, dateNow, limit )
    }

    @Override
    @Cacheable( value = "production", key = "'announcesGroupNewer:' + #limit + '/' + #id" )
    public List< AnnounceEntity > findGroupByNewerThanIdAndDeadTimeOlderThan( int id, Date dateNow, int limit ) {
        getAnnounceNewerThan( "組務", id, dateNow, limit )
    }

    @Override
    @Cacheable( value = "production", key = "'announcesCommonOlder:' + #limit + '/' + #id" )
    public List< AnnounceEntity > findCommonByOlderThanIdAndDeadTimeOlderThan( int id, Date dateNow, int limit ) {
        getAnnounceOlderThan( "一般", id, dateNow, limit )
    }

    @Override
    @Cacheable( value = "production", key = "'announcesGroupOlder:' + #limit + '/' + #id" )
    public List< AnnounceEntity > findGroupByOlderThanIdAndDeadTimeOlderThan( int id, Date dateNow, int limit ) {
        getAnnounceOlderThan( "組務", id, dateNow, limit )
    }

    private List< AnnounceEntity > getLatestAnnounce( String type, Date dateNow, int limit ) {
        getEntityManager()
                .createQuery(
                        "SELECT announce FROM AnnounceEntity announce " +
                        "WHERE announce.type = :announceType " +
                        "AND announce.isDisabled = false " +
                        "AND ( " +
                        "announce.deadTime IS NULL OR " +
                        "announce.deadTime < :dateZero OR" +
                        ":dateNow <= announce.deadTime )" +
                        "ORDER BY announce.time DESC", AnnounceEntity.class )
                .setParameter( "announceType", type )
                .setParameter( "dateZero", zeroDate, TemporalType.DATE )
                .setParameter( "dateNow", dateNow, TemporalType.DATE )
                .setMaxResults( limit )
                .getResultList()
    }

    private List< AnnounceEntity > getAnnounceNewerThan( String type, int id, Date dateNow, int limit ) {
        AnnounceEntity announce = getEntityManager().find( AnnounceEntity.class, id )
        if ( announce == null ) {
            return null
        } else {
            return getEntityManager()
                    .createQuery(
                            "SELECT announce FROM AnnounceEntity announce " +
                            "WHERE announce.type = :announceType " +
                            "AND announce.isDisabled = false " +
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
                    .setParameter( "dateNow", dateNow, TemporalType.DATE )
                    .setParameter( "time", announce.getTime(), TemporalType.DATE )
                    .setParameter( "id", announce.getId() )
                    .setMaxResults( limit )
                    .getResultList()
        }
    }

    private List< AnnounceEntity > getAnnounceOlderThan( String type, int id, Date dateNow, int limit ) {
        AnnounceEntity announce = getEntityManager().find( AnnounceEntity.class, id )
        if ( announce == null ) {
            return null
        } else {
            return getEntityManager()
                    .createQuery(
                            "SELECT announce FROM AnnounceEntity announce " +
                            "WHERE announce.type = :announceType " +
                            "AND announce.isDisabled = false " +
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
                    .setParameter( "dateNow", dateNow, TemporalType.DATE )
                    .setParameter( "time", announce.getTime(), TemporalType.DATE )
                    .setParameter( "id", announce.getId() )
                    .setMaxResults( limit )
                    .getResultList()
        }
    }

}
