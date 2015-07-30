package tw.edu.ncu.cc.activity.server.service

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification

class PlanServiceImplTest extends SpringSpecification {

    @Autowired
    PlanService planService

    def "it can find plan by its id"() {
        expect:
            planService.findById( 1 ).content == "content1"
    }

}
