package tw.edu.ncu.cc.activity.server.entity;


import javax.persistence.*;

@Entity
@Table( name = "club" )
public class ClubEntity {

    private String id;
    private String name;
    private String place;
    private String website;
    private String description;

    @Id
    @Column( name = "clubID" )
    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    @Basic
    @Column( name = "club_name" )
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Basic
    @Column( name = "address" )
    public String getPlace() {
        return place;
    }

    public void setPlace( String place ) {
        this.place = place;
    }

    @Basic
    @Column( name = "web_site" )
    public String getWebsite() {
        return website;
    }

    public void setWebsite( String website ) {
        this.website = website;
    }

    @Basic
    @Column( name = "description" )
    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

}