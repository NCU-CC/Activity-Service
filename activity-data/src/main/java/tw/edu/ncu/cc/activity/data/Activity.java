package tw.edu.ncu.cc.activity.data;

import java.util.Date;

public class Activity {

    private String name;
    private String club;
    private String place;
    private String content;
    private Date start;
    private Date end;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getClub() {
        return club;
    }

    public void setClub( String club ) {
        this.club = club;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace( String place ) {
        this.place = place;
    }

    public String getContent() {
        return content;
    }

    public void setContent( String content ) {
        this.content = content;
    }

    public Date getStart() {
        return start;
    }

    public void setStart( Date start ) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd( Date end ) {
        this.end = end;
    }
}
