package tw.edu.ncu.cc.activity.server.service

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification

class AnnounceServiceImplTest extends SpringSpecification {

    @Autowired
    private AnnounceServiceImpl announceService;

    def "it can fetch latest undisabled common announces"() {
        when:
            def commonAnnounces = announceService.findCommonByDateOlderThan( new Date(), 10 )
        then:
            commonAnnounces.size() == 2
    }

    def "it can fetch latest undisabled group announces"() {
        when:
            def groupAnnounces = announceService.findGroupByDateOlderThan( new Date(), 10 )
        then:
            groupAnnounces.size() == 2
    }

    def "it can fetch common announces newer than specified announce id"() {
        when:
            def newerAnnounces = announceService.findCommonByNewerThanIdAndDeadTimeOlderThan( 2015, new Date(), 10 );
        then:
            newerAnnounces.size() == 1
            newerAnnounces.get( 0 ).getId() == 2016
    }

    def "it can fetch group announces newer than specified announce id"() {
        when:
            def newerAnnounces = announceService.findGroupByNewerThanIdAndDeadTimeOlderThan( 2014, simpleDate( "2013-08-07" ), 10 );
        then:
            newerAnnounces.size() == 2
            newerAnnounces.get( 0 ).getId() == 2020
    }

    def "it can fetch common announces older than specified announce id"() {
        when:
            def newerAnnounces = announceService.findCommonByOlderThanIdAndDeadTimeOlderThan( 2016, new Date(), 10 );
        then:
            newerAnnounces.size() == 1
            newerAnnounces.get( 0 ).getId() == 2015
    }

    def "it can fetch group announces older than specified announce id"() {
        when:
            def newerAnnounces = announceService.findGroupByOlderThanIdAndDeadTimeOlderThan( 2017, new Date(), 10 );
        then:
            newerAnnounces.size() == 1
            newerAnnounces.get( 0 ).getId() == 2014
    }

    def "it should return null when fetching newer/older data if id not exist"() {
        expect:
            announceService.findCommonByNewerThanIdAndDeadTimeOlderThan( 3000, new Date(), 1 ) == null
            announceService.findCommonByOlderThanIdAndDeadTimeOlderThan( 3000, new Date(), 1 ) == null
            announceService.findGroupByNewerThanIdAndDeadTimeOlderThan ( 3000, new Date(), 1 ) == null
            announceService.findGroupByOlderThanIdAndDeadTimeOlderThan ( 3000, new Date(), 1 ) == null
    }

}
