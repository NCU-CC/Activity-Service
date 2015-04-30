package tw.edu.ncu.cc.activity.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification
import tw.edu.ncu.cc.activity.server.service.PlanService


class PlanServiceImplTest extends SpringSpecification {

    @Autowired
    PlanService planService

    def "it can find plan by its id"() {
        expect:
            planService.findPlanById( 1 ).content == "content1"
    }

}
