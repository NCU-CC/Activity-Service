package tw.edu.ncu.cc.activity.server.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "plan" )
public class ActivityEntity {

    private int id;
    private String name;
    private ClubEntity club;
    private String inSchoolPlace;
    private String outSchoolPlace;
    private String content;
    private Date startDate;
    private Date endDate;
    private String startTimes;
    private String endTimes;

    @Id
    @Column( name = "plan_id" )
    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    @Basic
    @Column( name = "plan_name" )
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn( name = "club_id" )
    public ClubEntity getClub() {
        return club;
    }

    public void setClub( ClubEntity club ) {
        this.club = club;
    }

    @Basic
    @Column( name = "plan_place" )
    public String getInSchoolPlace() {
        return inSchoolPlace;
    }

    public void setInSchoolPlace( String inSchoolPlace ) {
        this.inSchoolPlace = inSchoolPlace;
    }

    @Basic
    @Column( name = "detail_place" )
    public String getOutSchoolPlace() {
        return outSchoolPlace;
    }

    public void setOutSchoolPlace( String outSchoolPlace ) {
        this.outSchoolPlace = outSchoolPlace;
    }

    @Basic
    @Column( name = "plan_content" )
    public String getContent() {
        return content;
    }

    public void setContent( String content ) {
        this.content = content;
    }

    @Basic
    @Column( name = "plan_time1" )
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate( Date startDate ) {
        this.startDate = startDate;
    }

    @Basic
    @Column( name = "plan_time2" )
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate( Date endDate ) {
        this.endDate = endDate;
    }

    @Basic
    @Column( name = "active_time2" )
    public String getStartTimes() {
        return startTimes;
    }

    public void setStartTimes( String startTimes ) {
        this.startTimes = startTimes;
    }

    @Basic
    @Column( name = "active_time3" )
    public String getEndTimes() {
        return endTimes;
    }

    public void setEndTimes( String endTimes ) {
        this.endTimes = endTimes;
    }

}
