package tw.edu.ncu.cc.activity.server.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table( name = "place" )
public class PlaceEntity {

    @Id
    @Column( name = "place_id" )
    def Integer id

    @Column( name = "place_name" )
    def String name

}
