package tw.edu.ncu.cc.activity.server.web.api.v1

import specification.IntegrationSpecification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static tw.edu.ncu.cc.oauth.resource.test.ApiAuthMockMvcRequestPostProcessors.accessToken


class AnnounceControllerTest2 extends IntegrationSpecification {

    def token = accessToken().user( "user-uid" ).scope( "user.info.basic.read" )

    def "it can provide latest group announces"() {
        when:
            def response = JSON(
                    server()
                    .perform(
                            get( "/v1/announces?type=group&size=10" )
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

    def "it can provide newer group announces"() {
        when:
            def response = JSON(
                    server()
                    .perform(
                            get( "/v1/announces?type=group&size=10&newer_than=2014" )
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
                        "id" : 2017,
                        "title"   : "title4",
                        "content" : "content4",
                        "attachment" : null,
                        "time" : "2013-08-03 08:23"
                    }
                    '''
            ) )
    }

    def "it can provide older group announces"() {
        when:
            def response = JSON(
                    server()
                    .perform(
                            get( "/v1/announces?type=group&size=10&older_than=2017" )
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
                        "id" : 2014,
                        "title"   : "title1",
                        "content" : "content1",
                        "attachment" : "prefix/file1",
                        "time" : "2013-07-31 08:23"
                    }
                    '''
            ) )
    }

    def "it should provide older group announces when older_than and newer_than are presented at same time"() {
        when:
            def response = JSON(
                    server()
                    .perform(
                            get( "/v1/announces?type=group&size=10&older_than=2016&newer_than=2017" )
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
                        "id" : 2014,
                        "title"   : "title1",
                        "content" : "content1",
                        "attachment" : "prefix/file1",
                        "time" : "2013-07-31 08:23"
                    }
                    '''
            ) )
    }


}
