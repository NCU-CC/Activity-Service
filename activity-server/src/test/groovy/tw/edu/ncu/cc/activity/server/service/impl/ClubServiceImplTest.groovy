package tw.edu.ncu.cc.activity.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification

class ClubServiceImplTest extends SpringSpecification {

    @Autowired
    private ClubServiceImpl clubService;

    def "it can fetch all ClubEntities"() {
        when:
            def clubs = clubService.getAllClubs()
        then:
            clubs.size() == 6
    }

    def "it can fetch ClubEntities by id"() {
        expect:
            clubService.getClub( "A001" ).getName() == "CLUB1"
    }

}
