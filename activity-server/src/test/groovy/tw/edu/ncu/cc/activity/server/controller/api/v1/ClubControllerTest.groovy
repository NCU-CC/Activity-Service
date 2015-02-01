package tw.edu.ncu.cc.activity.server.controller.api.v1

import specification.IntegrationSpecification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


class ClubControllerTest extends IntegrationSpecification {

    def "it can provide all Clubs"() {
        when:
            def response = JSON( server()
                    .perform( get( "/v1/club" ).accept( "application/json" ) )
                    .andExpect( status().isOk() )
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

}
