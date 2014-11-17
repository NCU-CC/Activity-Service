package tw.edu.ncu.cc.activity.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification
import tw.edu.ncu.cc.activity.data.v1.Activity


class ActivityServiceImplTest extends SpringSpecification {

    @Autowired
    private ActivityServiceImpl activityService

    def "it can fetch latest Activities start from specified date"() {
        when:
            def activities = activityService.getLatestActivities( new Date(), 10 )
        then:
            activities.size() == 3
            activities.contains( new Activity(
                    name:    "Activity4",
                    club:    "CLUB4",
                    place:   "place4",
                    content: "content4",
                    start: date( "2050-09-13 09:00:00" ),
                    end:   date( "2050-09-14 23:00:00" )
            ) )
            activities.contains( new Activity(
                    name:    "Activity5",
                    club:    "CLUB5",
                    place:   "place6",
                    content: "content5",
                    start: date( "2050-09-14 00:00:00" ),
                    end:   date( "2050-09-15 00:00:00" )
            ) )
            activities.contains( new Activity(
                    name:    "Activity6",
                    club:    null,
                    place:   "place6",
                    content: "content6",
                    start: date( "2050-09-15 00:00:00" ),
                    end:   date( "2050-09-16 00:00:00" )
            ) )
    }

}
