package tw.edu.ncu.cc.activity.server.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "admin_unit" )
public class UnitEntity {

    private int id;
    private String name;

    @Id
    @Column( name = "office_id" )
    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    @Column( name = "office_name" )
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

}
