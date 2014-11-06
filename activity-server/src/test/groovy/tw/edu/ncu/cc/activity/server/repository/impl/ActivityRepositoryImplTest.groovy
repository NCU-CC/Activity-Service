package tw.edu.ncu.cc.activity.server.repository.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification

import java.text.SimpleDateFormat


class ActivityRepositoryImplTest extends SpringSpecification {

    @Autowired
    private ActivityRepositoryImpl activityRepository;

    def "it can fetch latest ActivityEntities start from specified date 1"() {
        when:
            def activities = activityRepository.getLatestActivities(
                    new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2013-09-10" ), 10
            )
        then:
            activities.size() == 5
            activities.get( 0 ).getId() == 322
            activities.get( 1 ).getId() == 323
    }

    def "it can fetch latest ActivityEntities start from specified date 2"() {
        when:
            def activities = activityRepository.getLatestActivities(
                    new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2013-09-13" ), 10
            )
        then:
            activities.size() == 2
            activities.get( 0 ).getId() == 325
            activities.get( 1 ).getId() == 326
    }

}
