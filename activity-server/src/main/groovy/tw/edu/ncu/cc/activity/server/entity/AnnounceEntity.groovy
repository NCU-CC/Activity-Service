package tw.edu.ncu.cc.activity.server.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table( name = "news" )
public class AnnounceEntity {

    @Id
    @Column( name = "NewsID" )
    def Integer id

    @Column( name = "major" )
    def Boolean major

    @Column( name = "disable" )
    def Boolean isDisabled

    @Column( name = "NewsType" )
    def String type

    @Column( name = "Title" )
    def String title

    @Column( name = "Content" )
    def String content

    @Column( name = "Time" )
    def Date time

    @Column( name = "DeadTime" )
    def Date deadTime

    @Column( name = "upfile" )
    def String attachment

}
