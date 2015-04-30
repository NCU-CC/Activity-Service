package tw.edu.ncu.cc.activity.server.controller.api.v1

import specification.IntegrationSpecification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


class ActivityControllerTest extends IntegrationSpecification {

    def "it can provide all Activities"() {
        when:
            def response = JSON( server()
                    .perform( get( "/v1/activity/10" ).accept( "application/json" ) )
                    .andExpect( status().isOk() )
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
