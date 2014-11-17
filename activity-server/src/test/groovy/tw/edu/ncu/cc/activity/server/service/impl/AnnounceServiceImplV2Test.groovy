package tw.edu.ncu.cc.activity.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification
import tw.edu.ncu.cc.activity.data.v2.Announce


class AnnounceServiceImplV2Test extends SpringSpecification {

    @Autowired
    private AnnounceServiceImplV2 announceService

    def "it can fetch latest undisabled COMMON Announces"() {
        when:
            def announces = announceService.getLatestCommonAnnounces(
                    simpleDate( "2013-08-07" ), 10
            );
        then:
            announces.size() == 2
            announces.contains( new Announce(
                    id: 2015,
                    time: date( "2013-08-01 08:23:24" ),
                    title:   "title2",
                    content: "content2",
                    attachment: "prefix/file2"
            ) )
    }

    def "it can fetch latest undisabled GROUP Announces"() {
        when:
            def announces = announceService.getLatestGroupAnnounces(
                    simpleDate( "2013-08-07" ), 10
            );
        then:
            announces.size() == 3
            announces.contains( new Announce(
                    id: 2014,
                    time: date( "2013-07-31 08:23:24" ),
                    title:   "title1",
                    content: "content1",
                    attachment: "prefix/file1"
            ) )
            announces.contains( new Announce(
                    id: 2017,
                    time: date( "2013-08-03 08:23:24" ),
                    title:   "title4",
                    content: "content4",
                    attachment: null
            ) )
            announces.contains( new Announce(
                    id: 2020,
                    time: date( "2013-08-06 08:23:24" ),
                    title:   "title7",
                    content: "content7",
                    attachment: "prefix/file7"
            ) )
    }

    def "it can fetch newer COMMON Announces"() {
        when:
            def announces = announceService.getCommonAnnouncesNewerThan(
                    2015, simpleDate( "2013-08-07" ), 10
            );
        then:
            announces.size() == 1
            announces.contains( new Announce(
                    id: 2016,
                    time: date( "2013-08-02 08:23:24" ),
                    title:   "title3",
                    content: "content3",
                    attachment: "prefix/file3"
            ) )
    }

    def "it can fetch newer GROUP Announces"() {
        when:
            def announces = announceService.getGroupAnnouncesNewerThan(
                    2017, simpleDate( "2013-08-07" ), 10
            );
        then:
            announces.size() == 1
            announces.contains( new Announce(
                    id: 2020,
                    time: date( "2013-08-06 08:23:24" ),
                    title:   "title7",
                    content: "content7",
                    attachment: "prefix/file7"
            ) )
    }

    def "it can fetch older COMMON Announces"() {
        when:
            def announces = announceService.getCommonAnnouncesOlderThan(
                    2016, simpleDate( "2013-08-07" ), 10
            );
        then:
            announces.size() == 1
            announces.contains( new Announce(
                    id: 2015,
                    time: date( "2013-08-01 08:23:24" ),
                    title:   "title2",
                    content: "content2",
                    attachment: "prefix/file2"
            ) )
    }

    def "it can fetch older GROUP Announces"() {
        when:
            def announces = announceService.getGroupAnnouncesOlderThan(
                    2017, simpleDate( "2013-08-07" ), 10
            );
        then:
            announces.size() == 1
            announces.contains( new Announce(
                    id: 2014,
                    time: date( "2013-07-31 08:23:24" ),
                    title:   "title1",
                    content: "content1",
                    attachment: "prefix/file1"
            ) )
    }

}
