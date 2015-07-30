package tw.edu.ncu.cc.activity.server.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table( name = "club" )
public class ClubEntity {

    @Id
    @Column( name = "clubID" )
    def String id

    @Column( name = "club_name" )
    def String name

    @Column( name = "address" )
    def String place

    @Column( name = "web_site" )
    def String website

    @Column( name = "description" )
    def String description

}