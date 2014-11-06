package tw.edu.ncu.cc.activity.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification


class ActivityServiceImplTest extends SpringSpecification {

    @Autowired
    private ActivityServiceImpl activityService

    def "it can fetch latest Activities start from specified date"() {
        when:
            def activities = activityService.getLatestActivities( new Date(), 10 )
        then:
            activities.size() == 2
            activities.get( 0 ).getStart().format( "yyyy-MM-dd HH:mm" ) == "2050-09-13 09:00"
    }

}
