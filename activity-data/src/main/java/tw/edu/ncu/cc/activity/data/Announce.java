package tw.edu.ncu.cc.activity.data;

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
}
