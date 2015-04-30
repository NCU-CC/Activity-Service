package tw.edu.ncu.cc.activity.server.web.api.v3

import specification.IntegrationSpecification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static tw.edu.ncu.cc.oauth.resource.test.ApiAuthMockMvcRequestPostProcessors.apiToken


class ClubControllerV2Test extends IntegrationSpecification {

    def "it can provide all Clubs"() {
        when:
            def response = JSON(
                    server()
                    .perform(
                            get( "/v3/clubs" )
                            .with( apiToken() )
                            .accept( "application/json" )
                    )
                    .andExpect(
                            status().isOk()
                    )
                    .andReturn()
            );
        then:
            response.size() == 6
            response.contains( JSON(
                    '''
                    {
                        "name"    : "CLUB1",
                        "place"   : "place1",
                        "website" : "site1",
                        "description" : "1111"
                    }
                    '''
            ) )
    }

    def "it should return 400 when api token not provided"() {
        expect:
            server()
                .perform(
                    get( "/v3/clubs" )
                    .accept( "application/json" )
                )
                .andExpect(
                    status().isBadRequest()
                )
    }

}
