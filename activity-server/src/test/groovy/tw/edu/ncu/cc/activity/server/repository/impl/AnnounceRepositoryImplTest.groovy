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

    def "it can fetch COMMON announces newer than specified announce id"() {
        when:
            def newerAnnounces = announceRepository.getCommonAnnouncesNewerThan( 2015, new Date(), 10 );
        then:
            newerAnnounces.size() == 1
            newerAnnounces.get( 0 ).getId() == 2016
    }

    def "it can fetch GROUP announces newer than specified announce id"() {
        when:
            def newerAnnounces = announceRepository.getGroupAnnouncesNewerThan( 2014, simpleDate( "2013-08-07" ), 10 );
        then:
            newerAnnounces.size() == 2
            newerAnnounces.get( 0 ).getId() == 2020
    }

    def "it can fetch COMMON announces older than specified announce id"() {
        when:
            def newerAnnounces = announceRepository.getCommonAnnouncesOlderThan( 2016, new Date(), 10 );
        then:
            newerAnnounces.size() == 1
            newerAnnounces.get( 0 ).getId() == 2015
    }

    def "it can fetch GROUP announces older than specified announce id"() {
        when:
            def newerAnnounces = announceRepository.getGroupAnnouncesOlderThan( 2017, new Date(), 10 );
        then:
            newerAnnounces.size() == 1
            newerAnnounces.get( 0 ).getId() == 2014
    }

    def "it will return null when fetching newer/older data if id not exist"() {
        expect:
            announceRepository.getCommonAnnouncesNewerThan( 3000, new Date(), 1 ) == null
            announceRepository.getCommonAnnouncesOlderThan( 3000, new Date(), 1 ) == null
            announceRepository.getGroupAnnouncesNewerThan ( 3000, new Date(), 1 ) == null
            announceRepository.getGroupAnnouncesOlderThan ( 3000, new Date(), 1 ) == null
    }

}
