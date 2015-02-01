package tw.edu.ncu.cc.activity.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification

class PlaceServiceImplTest extends SpringSpecification {

    @Autowired
    private PlaceServiceImpl placeService;

    def "it can fetch PlaceEntity by id"() {
        when:
            def place = placeService.getPlace( 1 )
        then:
            place.getName() == "place1"
    }

}
