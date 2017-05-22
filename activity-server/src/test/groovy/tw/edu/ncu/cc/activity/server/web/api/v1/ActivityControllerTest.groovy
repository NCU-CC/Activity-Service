package tw.edu.ncu.cc.activity.server.web.api.v1

import specification.IntegrationSpecification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static tw.edu.ncu.cc.oauth.resource.test.ApiAuthMockMvcRequestPostProcessors.accessToken


class ActivityControllerTest extends IntegrationSpecification {

    def token = accessToken().user( "user-uid" ).scope( "user.info.basic.read" )

    def "it can provide all Activities"() {
        when:
            def response = JSON( server()
                    .perform(
                        get( "/v1/activities?size=10" )
                        .with( token )
                        .accept( "application/json" )
                    )
                    .andExpect(
                        status().isOk()
                    )
                    .andReturn()
            );
        then:
            response.size() == 3
            response.contains( JSON(
                    '''
                    {
                        "name"    : "description3",
                        "club"    : "admin",
                        "place"   : "place3",
                        "content" : null,
                        "start" : "2050-04-22 15:00",
                        "end"   : "2050-04-22 18:00"
                    }
                    '''
            ) )
            response.contains( JSON(
                    '''
                    {
                        "name"    : "description4",
                        "club"    : "unit2",
                        "place"   : "place4",
                        "content" : null,
                        "start" : "2050-04-22 15:00",
                        "end"   : "2050-04-22 18:00"
                    }
                    '''
            ) )
            response.contains( JSON(
                    '''
                    {
                        "name"    : "Activity5",
                        "club"    : "CLUB5",
                        "place"   : "place5",
                        "content" : "content5",
                        "start" : "2050-04-22 15:00",
                        "end"   : "2050-04-22 18:00"
                    }
                    '''
            ) )
    }

}
