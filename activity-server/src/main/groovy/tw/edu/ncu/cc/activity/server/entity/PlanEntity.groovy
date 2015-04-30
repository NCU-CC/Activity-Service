package tw.edu.ncu.cc.activity.server.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table( name = "plan_new" )
public class PlanEntity {

    @Id
    @Column( name = "plan_id" )
    def Integer id

    @Column( name = "club_id" )
    def String sponsor

    @Column( name = "plan_name" )
    def String name

    @Column( name = "plan_content" )
    def String content

}
