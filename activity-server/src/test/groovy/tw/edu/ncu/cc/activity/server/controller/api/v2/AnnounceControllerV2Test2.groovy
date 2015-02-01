package tw.edu.ncu.cc.activity.server.controller.api.v2

import specification.IntegrationSpecification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


class AnnounceControllerV2Test2 extends IntegrationSpecification {

    def "it can provide latest undisabled GROUP Announces"() {
        when:
            def response = JSON( server()
                    .perform( get( "/v2/announce/group?size=10" ).accept( "application/json" ) )
                    .andExpect( status().isOk() )
                    .andReturn()
            );
        then:
            response.contains( JSON(
                    '''
                    {
                        "id" : 2014,
                        "title"   : "title1",
                        "content" : "content1",
                        "attachment" : "prefix/file1",
                        "time" : "2013-07-31 08:23"
                    }
                    '''
            ) )
            response.contains( JSON(
                    '''
                    {
                        "id" : 2017,
                        "title"   : "title4",
                        "content" : "content4",
                        "attachment" : null,
                        "time" : "2013-08-03 08:23"
                    }
                    '''
            ) )
    }

    def "it can provide newer GROUP Announces"() {
        when:
            def response = JSON( server()
                    .perform( get( "/v2/announce/group?size=10&newer_than=2014" ).accept( "application/json" ) )
                    .andExpect( status().isOk() )
                    .andReturn()
            );
        then:
            response.size() == 1
            response.contains( JSON(
                    '''
                    {
                        "id" : 2017,
                        "title"   : "title4",
                        "content" : "content4",
                        "attachment" : null,
                        "time" : "2013-08-03 08:23"
                    }
                    '''
            ) )
    }

    def "it can provide older GROUP Announces"() {
        when:
            def response = JSON( server()
                    .perform( get( "/v2/announce/group?size=10&older_than=2017" ).accept( "application/json" ) )
                    .andExpect( status().isOk() )
                    .andReturn()
            );
        then:
            response.size() == 1
            response.contains( JSON(
                    '''
                    {
                        "id" : 2014,
                        "title"   : "title1",
                        "content" : "content1",
                        "attachment" : "prefix/file1",
                        "time" : "2013-07-31 08:23"
                    }
                    '''
            ) )
    }

    def "it will response 400 when older_than and newer_than is presented in one request"() {
        expect:
            server()
                    .perform( get( "/v2/announce/group?size=10&older_than=2016&newer_than=2017" ).accept( "application/json" ) )
                    .andExpect( status().isBadRequest() )
    }


}
