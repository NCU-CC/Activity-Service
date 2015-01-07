package tw.edu.ncu.cc.activity.server.controller

import specification.IntegrationSpecification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


class ActivityControllerV2Test extends IntegrationSpecification {

    def "it can provide all Activities"() {
        when:
            def response = JSON( server()
                    .perform( get( "/v2/activity?size=10" ).accept( "application/json" ) )
                    .andExpect( status().isOk() )
                    .andReturn()
            );
        then:
            response.size() == 3
            response.contains( JSON(
                    '''
                    {
                        "name"    : "Activity4",
                        "club"    : "CLUB4",
                        "place"   : "place4",
                        "content" : "content4",
                        "start" : "2050-09-13 09:00",
                        "end"   : "2050-09-14 23:00"
                    }
                    '''
            ) )
            response.contains( JSON(
                    '''
                    {
                        "name"    : "Activity5",
                        "club"    : "CLUB5",
                        "place"   : "place6",
                        "content" : "content5",
                        "start" : "2050-09-14 00:00",
                        "end"   : "2050-09-15 00:00"
                    }
                    '''
            ) )
            response.contains( JSON(
                    '''
                    {
                        "name"    : "Activity6",
                        "club"    : null,
                        "place"   : "place6",
                        "content" : "content6",
                        "start" : "2050-09-15 00:00",
                        "end"   : "2050-09-16 00:00"
                    }
                    '''
            ) )
    }

}
