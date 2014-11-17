package tw.edu.ncu.cc.activity.data.v2;

import java.util.Date;

public class Announce {

    private int id;
    private String title;
    private String content;
    private Date time;
    private String attachment;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent( String content ) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime( Date time ) {
        this.time = time;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment( String attachment ) {
        this.attachment = attachment;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        Announce announce = ( Announce ) o;

        if ( id != announce.id ) return false;
        if ( attachment != null ? !attachment.equals( announce.attachment ) : announce.attachment != null )
            return false;
        if ( !content.equals( announce.content ) ) return false;
        if ( !time.equals( announce.time ) ) return false;
        if ( !title.equals( announce.title ) ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + ( attachment != null ? attachment.hashCode() : 0 );
        return result;
    }

}
