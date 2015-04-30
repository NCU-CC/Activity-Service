package tw.edu.ncu.cc.activity.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "plan_new" )
public class PlanEntity {

    private int id;
    private String sponsor;
    private String name;
    private String content;

    @Id
    @Column( name = "plan_id" )
    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    @Column( name = "club_id" )
    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor( String club ) {
        this.sponsor = club;
    }

    @Column( name = "plan_name" )
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Column( name = "plan_content" )
    public String getContent() {
        return content;
    }

    public void setContent( String content ) {
        this.content = content;
    }

}
