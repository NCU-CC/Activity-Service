package tw.edu.ncu.cc.activity.server.webservice

import specification.IntegrationSpecification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


class ActivityWebServiceTest extends IntegrationSpecification {

    def "it can provide all Activities"() {
        when:
            def response = JSON( server()
                    .perform( get( "/v1/activity/10" ).accept( "application/json" ) )
                    .andExpect( status().isOk() )
                    .andReturn()
            );
        then:
            response.size() == 2
            response.contains( JSON(
                    '''
                    {
                        "name"    : "Activity5",
                        "club"    : "CLUB5",
                        "place"   : "place5",
                        "content" : "content5",
                        "start" : "2050-09-14 09:00",
                        "end"   : "2050-09-15 23:00"
                    }
                    '''
            ) )
    }

}
