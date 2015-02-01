package tw.edu.ncu.cc.activity.server.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ncu.cc.activity.data.v1.Activity;
import tw.edu.ncu.cc.activity.server.controller.api.ApplicationController;
import tw.edu.ncu.cc.activity.server.entity.ActivityEntity;
import tw.edu.ncu.cc.activity.server.service.ActivityService;

import java.util.Date;


@RestController
@RequestMapping( method = RequestMethod.GET )
public class ActivityController extends ApplicationController {

    private ActivityService activityService ;

    @Autowired
    public void setActivityService( ActivityService activityService ) {
        this.activityService = activityService;
    }

    @RequestMapping( value = "v1/activity/{size}" )
    public Activity[] getActivities( @PathVariable( "size" ) int size ) {
        return convert(
                activityService.getLatestActivities( new Date(), ( size > 0 && size <= 20 ? size : 10 ) ),
                ActivityEntity.class,
                Activity.class
        );
    }

}
