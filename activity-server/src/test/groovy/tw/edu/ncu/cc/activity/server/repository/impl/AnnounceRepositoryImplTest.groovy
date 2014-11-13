package tw.edu.ncu.cc.activity.server.repository.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification

class AnnounceRepositoryImplTest extends SpringSpecification {

    @Autowired
    private AnnounceRepositoryImpl announceRepository;

    def "it can fetch latest undisabled COMMON AnnounceEntities"() {
        when:
            def commonAnnounces = announceRepository.getLatestCommonAnnounces( new Date(), 10 )
        then:
            commonAnnounces.size() == 2
    }

    def "it can fetch latest undisabled GROUP AnnounceEntities"() {
        when:
            def groupAnnounces = announceRepository.getLatestGroupAnnounces( new Date(), 10 )
        then:
            groupAnnounces.size() == 2
    }

}
