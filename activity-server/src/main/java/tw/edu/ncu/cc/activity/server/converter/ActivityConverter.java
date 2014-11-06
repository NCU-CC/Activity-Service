package tw.edu.ncu.cc.activity.server.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import tw.edu.ncu.cc.activity.data.Activity;
import tw.edu.ncu.cc.activity.server.entity.ActivityEntity;
import tw.edu.ncu.cc.activity.server.repository.PlaceRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ActivityConverter implements Converter< ActivityEntity, Activity > {

    private PlaceRepository placeRepository;

    @Autowired
    public void setPlaceRepository( PlaceRepository placeRepository ) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Activity convert( ActivityEntity source ) {
        Activity activity = new Activity();
        activity.setName( source.getName() );
        activity.setClub( source.getClub().getName() );
        if ( StringUtils.isEmpty( source.getInSchoolPlace() ) ) {
            activity.setPlace( source.getOutSchoolPlace() );
        } else {
            activity.setPlace(
                    placeRepository
                            .getPlace( Integer.parseInt( source.getInSchoolPlace() ) )
                            .getName()
            );
        }
        activity.setContent( source.getContent() );
        activity.setStart( new Date( time( source.getStartTimes() ) ) );
        activity.setEnd  ( new Date( time( source.getEndTimes() ) ) );
        return activity;
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
