package tw.edu.ncu.cc.activity.server.repository.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification

class ClubRepositoryImplTest extends SpringSpecification {

    @Autowired
    private ClubRepositoryImpl clubRepository;

    def "it can fetch all clubs"() {
        when:
            def clubs = clubRepository.getAllClubs()
        then:
            clubs.size() == 6
    }

}
