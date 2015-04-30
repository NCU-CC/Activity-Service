package tw.edu.ncu.cc.activity.server.entity


import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table( name = "admin_unit" )
public class UnitEntity {

    @Id
    @Column( name = "office_id" )
    def Integer id

    @Column( name = "office_name" )
    def String name

}
