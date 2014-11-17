package tw.edu.ncu.cc.activity.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import specification.SpringSpecification
import tw.edu.ncu.cc.activity.data.v1.Announce


class AnnounceServiceImplTest extends SpringSpecification {

    @Autowired
    private AnnounceServiceImpl announceService

    def "it can fetch latest undisabled COMMON Announces"() {
        when:
            def announces = announceService.getLatestCommonAnnounces(
                    simpleDate( "2013-08-07" ), 10
            );
        then:
            announces.size() == 2
            announces.contains( new Announce(
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
                    time: date( "2013-07-31 08:23:24" ),
                    title:   "title1",
                    content: "content1",
                    attachment: "prefix/file1"
            ) )
            announces.contains( new Announce(
                    time: date( "2013-08-03 08:23:24" ),
                    title:   "title4",
                    content: "content4",
                    attachment: null
            ) )
            announces.contains( new Announce(
                    time: date( "2013-08-06 08:23:24" ),
                    title:   "title7",
                    content: "content7",
                    attachment: "prefix/file7"
            ) )
    }

}
