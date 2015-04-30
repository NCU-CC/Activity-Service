package tw.edu.ncu.cc.activity.server.service

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification

class UnitServiceImplTest extends SpringSpecification {

    @Autowired
    UnitService unitService

    def "it can get unit by its id"() {
        expect:
            unitService.findById( 1 ).name == "unit1"
    }

}
