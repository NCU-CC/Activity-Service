package tw.edu.ncu.cc.activity.server.controller.api.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ncu.cc.activity.data.v2.Announce;
import tw.edu.ncu.cc.activity.server.controller.api.ApplicationController;
import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity;
import tw.edu.ncu.cc.activity.server.service.AnnounceService;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping( method = RequestMethod.GET )
public class AnnounceControllerV2 extends ApplicationController {

    private AnnounceService announceService;

    @Autowired
    public void setAnnounceService( AnnounceService announceService ) {
        this.announceService = announceService;
    }

    @RequestMapping( value = "v2/announce/common" )
    public Object getCommonAnnounces( @RequestParam( "size" ) Integer size,
                                      @RequestParam( value = "older_than", required = false ) Integer olderThanID,
                                      @RequestParam( value = "newer_than", required = false ) Integer newerThanID ) {
        int requestSize = ( size > 0 && size <= 40 ? size : 20 );
        if( olderThanID == null && newerThanID == null ) {
            return convert( announceService.getLatestCommonAnnounces( new Date(), requestSize ) );
        } else if( olderThanID == null ) {
            return convert( announceService.getCommonAnnouncesNewerThan( newerThanID, new Date(), requestSize ) );
        } else if( newerThanID == null ) {
            return convert( announceService.getCommonAnnouncesOlderThan( olderThanID, new Date(), requestSize ) );
        } else {
            return new ResponseEntity<>( "older_than and newer_than cannot be presented in same time", HttpStatus.BAD_REQUEST );
        }
    }

    @RequestMapping( value = "v2/announce/group" )
    public Object getGroupAnnounces( @RequestParam( "size" ) Integer size,
                                     @RequestParam( value = "older_than", required = false ) Integer olderThanID,
                                     @RequestParam( value = "newer_than", required = false ) Integer newerThanID ) {
        int requestSize = ( size > 0 && size <= 40 ? size : 20 );
        if( olderThanID == null && newerThanID == null ) {
            return convert( announceService.getLatestGroupAnnounces( new Date(), requestSize ) );
        } else if( olderThanID == null ) {
            return convert( announceService.getGroupAnnouncesNewerThan( newerThanID, new Date(), requestSize ) );
        } else if( newerThanID == null ) {
            return convert( announceService.getGroupAnnouncesOlderThan( olderThanID, new Date(), requestSize ) );
        } else {
            return new ResponseEntity<>( "older_than and newer_than cannot be presented in same time", HttpStatus.BAD_REQUEST );
        }
    }

    private Announce[] convert( List< AnnounceEntity > announces ) {
        return convert( announces, AnnounceEntity.class, Announce.class );
    }

}
