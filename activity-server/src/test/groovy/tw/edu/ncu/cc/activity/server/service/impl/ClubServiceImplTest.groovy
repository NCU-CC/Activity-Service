package tw.edu.ncu.cc.activity.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification
import tw.edu.ncu.cc.activity.data.Club


class ClubServiceImplTest extends SpringSpecification {

    @Autowired
    private ClubServiceImpl clubService

    def "it can fetch all Clubs"() {
        when:
            def clubs = clubService.getAllClubs();
        then:
            clubs.size() == 6
            clubs.contains( new Club(
                    name: "CLUB1",
                    place: "place1",
                    description: "1111",
                    website: "site1"
            ) )
    }

}
