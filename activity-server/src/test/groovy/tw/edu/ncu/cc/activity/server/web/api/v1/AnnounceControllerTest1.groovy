package tw.edu.ncu.cc.activity.server.web.api.v1

import specification.IntegrationSpecification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static tw.edu.ncu.cc.oauth.resource.test.ApiAuthMockMvcRequestPostProcessors.accessToken


class AnnounceControllerTest1 extends IntegrationSpecification {

    def token = accessToken().user( "user-uid" ).scope( "user.info.basic.read" )

    def "it can provide latest common announces"() {
        when:
            def response = JSON( server()
                    .perform(
                        get( "/v1/announces?type=common&size=10" )
                        .with( token )
                        .accept( "application/json" )
                    )
                    .andExpect(
                        status().isOk()
                    )
                    .andReturn()
            )
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

    def "it can provide newer common announces"() {
        when:
            def response = JSON( server()
                    .perform(
                        get( "/v1/announces?type=common&size=10&newer_than=2015" )
                        .with( token )
                        .accept( "application/json" )
                    )
                    .andExpect(
                        status().isOk()
                    )
                    .andReturn()
            )
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

    def "it can provide older common announces"() {
        when:
            def response = JSON( server()
                    .perform(
                        get( "/v1/announces?type=common&size=10&older_than=2016" )
                        .with( token )
                        .accept( "application/json" )
                    )
                    .andExpect(
                        status().isOk()
                    )
                    .andReturn()
            )
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

    def "it should provide older common announces when older_than and newer_than are presented at same time"() {
        when:
            def response = JSON( server()
                    .perform(
                        get( "/v1/announces?type=common&size=10&older_than=2016&newer_than=2017" )
                        .with( token )
                        .accept( "application/json" )
                    )
                    .andExpect(
                        status().isOk()
                    )
                    .andReturn()
            )
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

}
