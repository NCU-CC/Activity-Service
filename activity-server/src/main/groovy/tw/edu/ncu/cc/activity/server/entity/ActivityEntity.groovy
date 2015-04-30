package tw.edu.ncu.cc.activity.server.entity

import tw.edu.ncu.cc.activity.server.entity.concern.ActivityKey

import javax.persistence.*
import java.sql.Date
import java.sql.Time

@Entity
@Table( name = "place_appointment" )
@IdClass( ActivityKey.class )
public class ActivityEntity {

    @Id
    @Column( name = "pa_date" )
    def Date date

    @Id
    @ManyToOne
    @JoinColumn( name = "place_id" )
    def PlaceEntity place

    @Column( name = "plan_id" )
    def Integer planId

    @Column( name = "club_id" )
    def String clubId

    @Column( name = "pa_description" )
    def String description

    @Column( name = "pa_start_time" )
    def Time startTime

    @Column( name = "pa_end_time" )
    def Time endTime

}
