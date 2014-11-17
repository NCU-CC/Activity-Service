package tw.edu.ncu.cc.activity.data.v1;

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

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        Activity activity = ( Activity ) o;

        if ( club != null ? !club.equals( activity.club ) : activity.club != null ) return false;
        if ( !content.equals( activity.content ) ) return false;
        if ( !end.equals( activity.end ) ) return false;
        if ( !name.equals( activity.name ) ) return false;
        if ( !place.equals( activity.place ) ) return false;
        if ( !start.equals( activity.start ) ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + ( club != null ? club.hashCode() : 0 );
        result = 31 * result + place.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }

}
