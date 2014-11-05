package tw.edu.ncu.cc.activity.server.repository.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import tw.edu.ncu.cc.activity.server.repository.ClubRepository

@ActiveProfiles( "dev" )
@ContextConfiguration( "classpath:applicationContext.xml" )
class ClubRepositoryImplTest extends Specification {

    @Autowired
    private ClubRepository clubRepository;

    def "it can fetch all clubs"() {
        when:
            def clubs = clubRepository.getAllClubs()
        then:
            clubs.size() == 6
    }

}
