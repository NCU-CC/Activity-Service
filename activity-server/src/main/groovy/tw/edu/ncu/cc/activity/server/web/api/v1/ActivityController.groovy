package tw.edu.ncu.cc.activity.server.web.api.v1

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tw.edu.ncu.cc.activity.data.v1.Activity
import tw.edu.ncu.cc.activity.server.entity.ActivityEntity
import tw.edu.ncu.cc.activity.server.service.ActivityService
import tw.edu.ncu.cc.activity.server.web.api.ApplicationController

@RestController
@RequestMapping( value = "v1/activities", method = RequestMethod.GET )
public class ActivityController extends ApplicationController {

    @Autowired
    def ActivityService activityService

    @RequestMapping
    public Activity[] index( @RequestParam( value = "size", defaultValue = "20" ) Integer size ) {
        convert(
                activityService.findByStartDateOlderThan( new Date(), ( size > 0 && size <= 40 ? size : 20 ) ),
                ActivityEntity.class,
                Activity.class
        )
    }

}
