package tw.edu.ncu.cc.activity.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ncu.cc.activity.data.Announce;
import tw.edu.ncu.cc.activity.server.service.AnnounceService;

import java.util.Date;
import java.util.LinkedList;
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
//        return announceService.getLatestCommonAnnounces( ( size > 0 && size <= 50 ? size : 25 ) );
        List<Announce> announces = new LinkedList<>();

        Announce announce = new Announce();
        announce.setTitle( "一般公告01" );
        announce.setContent( "野" );
        announce.setTime( new Date() );
        announces.add( announce );

        announce = new Announce();
        announce.setTitle( "一般公告02" );
        announce.setContent( "格" );
        announce.setTime( new Date() );
        announces.add( announce );

        announce = new Announce();
        announce.setTitle( "一般公告03" );
        announce.setContent( "炸" );
        announce.setTime( new Date() );
        announces.add( announce );

        announce = new Announce();
        announce.setTitle( "一般公告04" );
        announce.setContent( "斷!" );
        announce.setTime( new Date() );
        announce.setAttachment( "http://www.cc.ncu.edu.tw/" );
        announces.add( announce );

        return announces;
    }

    @RequestMapping( value = "v1/announce/group/{size}" )
    public List<Announce> getGroupAnnounces( @PathVariable( "size" ) int size ) {
//        return announceService.getLatestGroupAnnounces( ( size > 0 && size <= 25 ? size : 12 ) );
        List<Announce> announces = new LinkedList<>();

        Announce announce = new Announce();
        announce.setTitle( "組務公告01" );
        announce.setContent( "該洗洗睡囉!" );
        announce.setTime( new Date() );
        announces.add( announce );

        announce = new Announce();
        announce.setTitle( "組務公告02" );
        announce.setContent( "該起床尿尿囉!" );
        announce.setTime( new Date() );
        announces.add( announce );

        announce = new Announce();
        announce.setTitle( "組務公告03" );
        announce.setContent( "你還是乾脆起床吧" );
        announce.setTime( new Date() );
        announces.add( announce );

        return announces;
    }

}
