package tw.edu.ncu.cc.activity.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification

class ActivityServiceImplTest extends SpringSpecification {

    @Autowired
    private ActivityServiceImpl activityService;

    def "it can fetch latest ActivityEntities start from specified date 1"() {
        when:
            def activities = activityService.getLatestActivities(
                    simpleDate( "2015-04-20" ), 10
            )
        then:
            activities.size() == 5
            activities.get( 0 ).description == "description1"
            activities.get( 1 ).description == "description2"
    }

    def "it can fetch latest ActivityEntities start from specified date 2"() {
        when:
            def activities = activityService.getLatestActivities(
                    simpleDate( "2025-04-20" ), 10
            )
        then:
            activities.size() == 3
            activities.get( 0 ).description == "description3"
            activities.get( 1 ).description == "description4"
    }

}
