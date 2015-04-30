package tw.edu.ncu.cc.activity.server.entity;

import tw.edu.ncu.cc.activity.server.entity.concern.ActivityKey;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table( name = "place_appointment" )
@IdClass( ActivityKey.class )
public class ActivityEntity {

    private Date date;
    private PlaceEntity place;
    private Integer planId;
    private String clubId;
    private String description;
    private Time startTime;
    private Time endTime;

    @Id
    @Column( name = "pa_date" )
    public Date getDate() {
        return date;
    }

    public void setDate( Date date ) {
        this.date = date;
    }

    @Id
    @ManyToOne
    @JoinColumn( name = "place_id" )
    public PlaceEntity getPlace() {
        return place;
    }

    public void setPlace( PlaceEntity place ) {
        this.place = place;
    }

    @Column( name = "pa_description" )
    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    @Column( name = "club_id" )
    public String getClubId() {
        return clubId;
    }

    public void setClubId( String clubId ) {
        this.clubId = clubId;
    }

    @Column( name = "plan_id" )
    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId( Integer planId ) {
        this.planId = planId;
    }

    @Column( name = "pa_start_time" )
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime( Time startTime ) {
        this.startTime = startTime;
    }

    @Column( name = "pa_end_time" )
    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime( Time endTime ) {
        this.endTime = endTime;
    }

}
