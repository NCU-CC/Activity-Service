package tw.edu.ncu.cc.activity.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification

class AnnounceServiceImplTest extends SpringSpecification {

    @Autowired
    private AnnounceServiceImpl announceService;

    def "it can fetch latest undisabled COMMON AnnounceEntities"() {
        when:
            def commonAnnounces = announceService.getLatestCommonAnnounces( new Date(), 10 )
        then:
            commonAnnounces.size() == 2
    }

    def "it can fetch latest undisabled GROUP AnnounceEntities"() {
        when:
            def groupAnnounces = announceService.getLatestGroupAnnounces( new Date(), 10 )
        then:
            groupAnnounces.size() == 2
    }

    def "it can fetch COMMON announces newer than specified announce id"() {
        when:
            def newerAnnounces = announceService.getCommonAnnouncesNewerThan( 2015, new Date(), 10 );
        then:
            newerAnnounces.size() == 1
            newerAnnounces.get( 0 ).getId() == 2016
    }

    def "it can fetch GROUP announces newer than specified announce id"() {
        when:
            def newerAnnounces = announceService.getGroupAnnouncesNewerThan( 2014, simpleDate( "2013-08-07" ), 10 );
        then:
            newerAnnounces.size() == 2
            newerAnnounces.get( 0 ).getId() == 2020
    }

    def "it can fetch COMMON announces older than specified announce id"() {
        when:
            def newerAnnounces = announceService.getCommonAnnouncesOlderThan( 2016, new Date(), 10 );
        then:
            newerAnnounces.size() == 1
            newerAnnounces.get( 0 ).getId() == 2015
    }

    def "it can fetch GROUP announces older than specified announce id"() {
        when:
            def newerAnnounces = announceService.getGroupAnnouncesOlderThan( 2017, new Date(), 10 );
        then:
            newerAnnounces.size() == 1
            newerAnnounces.get( 0 ).getId() == 2014
    }

    def "it will return null when fetching newer/older data if id not exist"() {
        expect:
            announceService.getCommonAnnouncesNewerThan( 3000, new Date(), 1 ) == null
            announceService.getCommonAnnouncesOlderThan( 3000, new Date(), 1 ) == null
            announceService.getGroupAnnouncesNewerThan ( 3000, new Date(), 1 ) == null
            announceService.getGroupAnnouncesOlderThan ( 3000, new Date(), 1 ) == null
    }

}
