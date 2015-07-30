package tw.edu.ncu.cc.activity.server.service

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification

class PlaceServiceImplTest extends SpringSpecification {

    @Autowired
    private PlaceServiceImpl placeService;

    def "it can fetch PlaceEntity by id"() {
        when:
            def place = placeService.findById( 1 )
        then:
            place.getName() == "place1"
    }

}
