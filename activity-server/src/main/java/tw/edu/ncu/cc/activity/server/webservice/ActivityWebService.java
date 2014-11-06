package tw.edu.ncu.cc.activity.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ncu.cc.activity.data.Activity;
import tw.edu.ncu.cc.activity.server.service.ActivityService;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping( method = RequestMethod.GET )
public class ActivityWebService {

    private ActivityService activityService;

    @Autowired
    public void setActivityService( ActivityService activityService ) {
        this.activityService = activityService;
    }

    @RequestMapping( value = "v1/activity/{size}" )
    public List<Activity> getActivities( @PathVariable( "size" ) int size ) {
        return activityService.getLatestActivities( new Date(), ( size > 0 && size <= 20 ? size : 10 ) );
    }

}
