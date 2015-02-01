package tw.edu.ncu.cc.activity.server.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ncu.cc.activity.data.v1.Announce;
import tw.edu.ncu.cc.activity.server.controller.api.ApplicationController;
import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity;
import tw.edu.ncu.cc.activity.server.service.AnnounceService;

import java.util.Date;

@RestController
@RequestMapping( method = RequestMethod.GET )
public class AnnounceController extends ApplicationController {

    private AnnounceService announceService;

    @Autowired
    public void setAnnounceService( AnnounceService announceService ) {
        this.announceService = announceService;
    }

    @RequestMapping( value = "v1/announce/common/{size}" )
    public Announce[] getCommonAnnounces( @PathVariable( "size" ) int size ) {
        return convert(
                announceService.getLatestCommonAnnounces( new Date(), ( size > 0 && size <= 50 ? size : 25 ) ),
                AnnounceEntity.class,
                Announce.class
        );
    }

    @RequestMapping( value = "v1/announce/group/{size}" )
    public Announce[] getGroupAnnounces( @PathVariable( "size" ) int size ) {
        return convert(
                announceService.getLatestGroupAnnounces( new Date(), ( size > 0 && size <= 25 ? size : 12 ) ),
                AnnounceEntity.class,
                Announce.class
        );
    }

}
