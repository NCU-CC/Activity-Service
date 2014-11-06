package tw.edu.ncu.cc.activity.server.repository.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification


class PlaceRepositoryImplTest extends SpringSpecification {

    @Autowired
    private PlaceRepositoryImpl placeRepository;

    def "it can fetch PlaceEntity by id"() {
        when:
            def place = placeRepository.getPlace( 1 )
        then:
            place.getName() == "place1"
    }

}
