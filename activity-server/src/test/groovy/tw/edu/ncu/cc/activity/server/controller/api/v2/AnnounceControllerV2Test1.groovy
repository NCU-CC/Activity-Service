package tw.edu.ncu.cc.activity.server.controller.api.v2

import specification.IntegrationSpecification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


class AnnounceControllerV2Test1 extends IntegrationSpecification {

    def "it can provide latest undisabled COMMON Announces"() {
        when:
            def response = JSON( server()
                    .perform( get( "/v2/announce/common?size=10" ).accept( "application/json" ) )
                    .andExpect( status().isOk() )
                    .andReturn()
            );
        then:
            response.contains( JSON(
                    '''
                    {
                        "id" : 2016,
                        "title"   : "title3",
                        "content" : "content3",
                        "attachment" : "prefix/file3",
                        "time" : "2013-08-02 08:23"
                    }
                    '''
            ) )
            response.contains( JSON(
                    '''
                    {
                        "id" : 2015,
                        "title"   : "title2",
                        "content" : "content2",
                        "attachment" : "prefix/file2",
                        "time" : "2013-08-01 08:23"
                    }
                    '''
            ) )
    }

    def "it can provide newer COMMON Announces"() {
        when:
            def response = JSON( server()
                    .perform( get( "/v2/announce/common?size=10&newer_than=2015" ).accept( "application/json" ) )
                    .andExpect( status().isOk() )
                    .andReturn()
            );
        then:
            response.size() == 1
            response.contains( JSON(
                    '''
                    {
                        "id" : 2016,
                        "title"   : "title3",
                        "content" : "content3",
                        "attachment" : "prefix/file3",
                        "time" : "2013-08-02 08:23"
                    }
                    '''
            ) )
    }

    def "it can provide older COMMON Announces"() {
        when:
            def response = JSON( server()
                    .perform( get( "/v2/announce/common?size=10&older_than=2016" ).accept( "application/json" ) )
                    .andExpect( status().isOk() )
                    .andReturn()
            );
        then:
            response.size() == 1
            response.contains( JSON(
                    '''
                    {
                        "id" : 2015,
                        "title"   : "title2",
                        "content" : "content2",
                        "attachment" : "prefix/file2",
                        "time" : "2013-08-01 08:23"
                    }
                    '''
            ) )
    }

    def "it will response 400 when older_than and newer_than is presented in one request"() {
        expect:
            server()
                    .perform( get( "/v2/announce/common?size=10&older_than=2016&newer_than=2017" ).accept( "application/json" ) )
                    .andExpect( status().isBadRequest() )
    }

}
