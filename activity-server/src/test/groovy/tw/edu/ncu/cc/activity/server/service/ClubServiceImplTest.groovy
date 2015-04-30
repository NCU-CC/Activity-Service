package tw.edu.ncu.cc.activity.server.service

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification

class ClubServiceImplTest extends SpringSpecification {

    @Autowired
    private ClubServiceImpl clubService;

    def "it can fetch all ClubEntities"() {
        when:
            def clubs = clubService.findAll()
        then:
            clubs.size() == 6
    }

    def "it can fetch ClubEntities by id"() {
        expect:
            clubService.findById( "A001" ).getName() == "CLUB1"
    }

}
