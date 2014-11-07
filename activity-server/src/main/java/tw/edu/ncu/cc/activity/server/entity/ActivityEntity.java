package tw.edu.ncu.cc.activity.server.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "plan" )
public class ActivityEntity {

    private int id;
    private String name;
    private String club;
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

    @Basic
    @Column( name = "club_id" )
    public String getClub() {
        return club;
    }

    public void setClub( String club ) {
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
    @Column( name = "plan_content", columnDefinition = "clob" )
    public String getContent() {
        return content;
    }

    public void setContent( String content ) {
        this.content = content;
    }

    @Basic
    @Column( name = "plan_time1", columnDefinition = "clob" )
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate( Date startDate ) {
        this.startDate = startDate;
    }

    @Basic
    @Column( name = "plan_time2", columnDefinition = "clob" )
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate( Date endDate ) {
        this.endDate = endDate;
    }

    @Basic
    @Column( name = "active_time2", columnDefinition = "clob" )
    public String getStartTimes() {
        return startTimes;
    }

    public void setStartTimes( String startTimes ) {
        this.startTimes = startTimes;
    }

    @Basic
    @Column( name = "active_time3", columnDefinition = "clob" )
    public String getEndTimes() {
        return endTimes;
    }

    public void setEndTimes( String endTimes ) {
        this.endTimes = endTimes;
    }

}
