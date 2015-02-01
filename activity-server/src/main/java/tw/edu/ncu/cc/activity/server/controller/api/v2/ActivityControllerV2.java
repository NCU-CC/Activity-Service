package tw.edu.ncu.cc.activity.server.controller.api.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ncu.cc.activity.data.v1.Activity;
import tw.edu.ncu.cc.activity.server.controller.api.ApplicationController;
import tw.edu.ncu.cc.activity.server.entity.ActivityEntity;
import tw.edu.ncu.cc.activity.server.service.ActivityService;

import java.util.Date;


@RestController
@RequestMapping( method = RequestMethod.GET )
public class ActivityControllerV2 extends ApplicationController {

    private ActivityService activityService;

    @Autowired
    public void setActivityService( ActivityService activityService ) {
        this.activityService = activityService;
    }

    @RequestMapping( value = "v2/activity" )
    public Activity[] getLatestActivities( @RequestParam( "size" ) Integer size ) {
        return convert(
                activityService.getLatestActivities( new Date(), ( size > 0 && size <= 40 ? size : 20 ) ),
                ActivityEntity.class,
                Activity.class
        );
    }

}
