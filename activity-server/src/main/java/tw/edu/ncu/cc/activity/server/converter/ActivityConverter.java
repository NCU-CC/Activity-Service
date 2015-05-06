package tw.edu.ncu.cc.activity.server.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tw.edu.ncu.cc.activity.data.v1.Activity;
import tw.edu.ncu.cc.activity.server.entity.ActivityEntity;
import tw.edu.ncu.cc.activity.server.entity.ClubEntity;
import tw.edu.ncu.cc.activity.server.entity.PlanEntity;
import tw.edu.ncu.cc.activity.server.entity.UnitEntity;
import tw.edu.ncu.cc.activity.server.service.ClubService;
import tw.edu.ncu.cc.activity.server.service.PlanService;
import tw.edu.ncu.cc.activity.server.service.UnitService;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ActivityConverter implements Converter< ActivityEntity, Activity > {

    private ClubService clubService;
    private UnitService unitService;
    private PlanService planService;

    @Autowired
    public void setClubService( ClubService clubService ) {
        this.clubService = clubService;
    }

    @Autowired
    public void setPlanService( PlanService planService ) {
        this.planService = planService;
    }

    @Autowired
    public void setUnitService( UnitService unitService ) {
        this.unitService = unitService;
    }

    @Override
    public Activity convert( ActivityEntity source ) {

        Activity activity = new Activity();
        if( source.getPlanId() != null && source.getPlanId() >= 0 ) {
            PlanEntity plan = planService.findPlanById( source.getPlanId() );
            activity.setName( plan.getName() );
            activity.setContent( plan.getContent() );
            buildClubFromPlan( plan, activity );
        } else {
            activity.setName( source.getDescription() );
            buildClubFromActivity( source, activity );
        }

        buildPlace( source, activity );
        buildTime ( source, activity );

        return activity;
    }

    private void buildClubFromPlan( PlanEntity plan, Activity activity ) {
        String sponsor = plan.getSponsor();
        if( sponsor.length() >= 4 ) {
            ClubEntity club = clubService.getClub( sponsor );
            activity.setClub( club.getName() );
        } else {
            UnitEntity unit = unitService.getUnitById( Integer.parseInt( sponsor ) );
            activity.setClub( unit.getName() );
        }
    }

    private void buildClubFromActivity( ActivityEntity source, Activity activity ) {
        if( source.getClubId().equals( "admin" ) ) {
            activity.setClub( "admin" );
        } else if( source.getClubId().length() >= 4 ) {
            ClubEntity club = clubService.getClub( source.getClubId() );
            activity.setClub( club.getName() );
        } else {
            UnitEntity unit = unitService.getUnitById( Integer.parseInt( source.getClubId() ) );
            activity.setClub( unit.getName() );
        }
    }

    private void buildPlace( ActivityEntity source, Activity activity ) {
        activity.setPlace( source.getPlace().getName() );
    }

    private void buildTime( ActivityEntity source, Activity activity ) {
        if( source.getStartTime() == null ) {
            activity.setStart( dateTime( source.getDate(), Time.valueOf( "00:00:00" ) ) );
        } else {
            activity.setStart( dateTime( source.getDate(), source.getStartTime() ) );
        }
        if( source.getEndTime() == null ) {
            activity.setEnd( dateTime( source.getDate(), Time.valueOf( "23:59:59" ) ) );
        } else {
            activity.setEnd( dateTime( source.getDate(), source.getEndTime() ) );
        }
    }

    private Date dateTime( Date date, Time time ) {
        try {
            return new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" )
                    .parse( date + " " + time );
        } catch ( ParseException e ) {
            throw new RuntimeException( "cannot parse date", e );
        }
    }

}
