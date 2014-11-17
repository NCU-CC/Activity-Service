package tw.edu.ncu.cc.activity.data.v1;

import java.util.Date;

public class Announce {

    private String title;
    private String content;
    private Date   time;
    private String attachment;

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

        if ( attachment != null ? !attachment.equals( announce.attachment ) : announce.attachment != null )
            return false;
        if ( !content.equals( announce.content ) ) return false;
        if ( time != null ? !time.equals( announce.time ) : announce.time != null ) return false;
        if ( !title.equals( announce.title ) ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + ( time != null ? time.hashCode() : 0 );
        result = 31 * result + ( attachment != null ? attachment.hashCode() : 0 );
        return result;
    }

}
