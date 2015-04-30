package tw.edu.ncu.cc.activity.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification
import tw.edu.ncu.cc.activity.server.service.UnitService


class UnitServiceImplTest extends SpringSpecification {

    @Autowired
    UnitService unitService

    def "it can get unit by its id"() {
        expect:
            unitService.getUnitById( 1 ).name == "unit1"
    }

}
