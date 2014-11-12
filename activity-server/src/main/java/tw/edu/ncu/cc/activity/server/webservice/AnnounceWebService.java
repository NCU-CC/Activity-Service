package tw.edu.ncu.cc.activity.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ncu.cc.activity.data.Announce;
import tw.edu.ncu.cc.activity.server.service.AnnounceService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping( method = RequestMethod.GET )
public class AnnounceWebService {

    private AnnounceService announceService;

    @Autowired
    public void setAnnounceService( AnnounceService announceService ) {
        this.announceService = announceService;
    }

    @RequestMapping( value = "v1/announce/common/{size}" )
    public List<Announce> getCommonAnnounces( @PathVariable( "size" ) int size ) {
        return announceService.getLatestCommonAnnounces( new Date(), ( size > 0 && size <= 50 ? size : 25 ) );
    }

    @RequestMapping( value = "v1/announce/group/{size}" )
    public List<Announce> getGroupAnnounces( @PathVariable( "size" ) int size ) {
        return announceService.getLatestGroupAnnounces( new Date(), ( size > 0 && size <= 25 ? size : 12 ) );
    }

}
