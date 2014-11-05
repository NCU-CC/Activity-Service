package tw.edu.ncu.cc.activity.server.entity;

import javax.persistence.*;

@Entity
@Table( name = "active_place" )
public class PlaceEntity {

    private int id;
    private String name;

    @Id
    @Column( name = "place_id" )
    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    @Basic
    @Column( name = "place_name" )
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

}
