package tw.edu.ncu.cc.activity.server.repository.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification

class ClubRepositoryImplTest extends SpringSpecification {

    @Autowired
    private ClubRepositoryImpl clubRepository;

    def "it can fetch all ClubEntities"() {
        when:
            def clubs = clubRepository.getAllClubs()
        then:
            clubs.size() == 6
    }

    def "it can fetch ClubEntities by id"() {
        expect:
            clubRepository.getClub( "A001" ).getName() == "CLUB1"
    }

}
