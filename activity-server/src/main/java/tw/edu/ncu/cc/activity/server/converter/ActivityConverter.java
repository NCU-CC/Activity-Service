package tw.edu.ncu.cc.activity.server.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import tw.edu.ncu.cc.activity.data.v1.Activity;
import tw.edu.ncu.cc.activity.server.entity.ActivityEntity;
import tw.edu.ncu.cc.activity.server.entity.ClubEntity;
import tw.edu.ncu.cc.activity.server.repository.ClubRepository;
import tw.edu.ncu.cc.activity.server.repository.PlaceRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ActivityConverter implements Converter< ActivityEntity, Activity > {

    private PlaceRepository placeRepository;
    private ClubRepository clubRepository;

    @Autowired
    public void setPlaceRepository( PlaceRepository placeRepository ) {
        this.placeRepository = placeRepository;
    }

    @Autowired
    public void setClubRepository( ClubRepository clubRepository ) {
        this.clubRepository = clubRepository;
    }

    @Override
    public Activity convert( ActivityEntity source ) {

        Activity activity = new Activity();
        activity.setName( source.getName() );
        activity.setContent( source.getContent() );

        buildClub ( source, activity );
        buildPlace( source, activity );
        buildTime ( source, activity );

        return activity;
    }

    private void buildClub( ActivityEntity source, Activity activity ) {
        ClubEntity club = clubRepository.getClub( source.getClub() );
        if ( club == null ) {
            activity.setClub( null );
        } else {
            activity.setClub( club.getName() );
        }
    }

    private void buildPlace( ActivityEntity source, Activity activity ) {
        int placeID = Integer.parseInt( source.getInSchoolPlace() );
        if ( placeID == -1 ) {
            activity.setPlace( source.getOutSchoolPlace() );
        } else {
            activity.setPlace(
                    placeRepository
                            .getPlace( placeID )
                            .getName()
            );
        }
    }

    private void buildTime( ActivityEntity source, Activity activity ) {
        if( StringUtils.isEmpty( source.getStartTimes() ) ) {
            activity.setStart( source.getStartDate() );
        } else {
            activity.setStart( new Date( time( source.getStartTimes() ) ) );
        }

        if( StringUtils.isEmpty( source.getEndTimes() ) ) {
            activity.setEnd( source.getEndDate() );
        } else {
            activity.setEnd( new Date( time( source.getEndTimes() ) ) );
        }
    }

    private long time( String time ) {
        try {
            String dateString = time.substring( 0, time.indexOf( '&' ) );
            return new SimpleDateFormat( "yyyy-MM-dd HH:mm" )
                    .parse( dateString )
                    .getTime();
        } catch ( ParseException e ) {
            throw new RuntimeException( "cannot parse date", e );
        }
    }

}
