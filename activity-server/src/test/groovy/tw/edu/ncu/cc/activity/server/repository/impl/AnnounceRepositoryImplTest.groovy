package tw.edu.ncu.cc.activity.server.repository.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification

class AnnounceRepositoryImplTest extends SpringSpecification {

    @Autowired
    private AnnounceRepositoryImpl announceRepository;

    def "it can fetch latest undisabled COMMON AnnounceEntities"() {
        when:
            def commonAnnounces = announceRepository.getLatestCommonAnnounces( 10 )
        then:
            commonAnnounces.size() == 2
            commonAnnounces.get( 0 ).getId() == 2016
            commonAnnounces.get( 1 ).getId() == 2015
    }

    def "it can fetch latest undisabled GROUP AnnounceEntities"() {
        when:
            def commonAnnounces = announceRepository.getLatestGroupAnnounces( 10 )
        then:
            commonAnnounces.size() == 2
            commonAnnounces.get( 0 ).getId() == 2017
            commonAnnounces.get( 1 ).getId() == 2014
    }


}
