package tw.edu.ncu.cc.activity.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ncu.cc.activity.server.service.AnnounceServiceV2;

import java.util.Date;


@RestController
@RequestMapping( method = RequestMethod.GET )
public class AnnounceWebServiceV2 {

    private AnnounceServiceV2 announceServiceV2;

    @Autowired
    public void setAnnounceServiceV2( AnnounceServiceV2 announceServiceV2 ) {
        this.announceServiceV2 = announceServiceV2;
    }

    @RequestMapping( value = "v2/announce/common" )
    public Object getCommonAnnouncesV2( @RequestParam( "size" ) Integer size,
                                        @RequestParam( value = "older_than", required = false ) Integer olderThanID,
                                        @RequestParam( value = "newer_than", required = false ) Integer newerThanID ) {
        int requestSize = ( size > 0 && size <= 40 ? size : 20 );
        if( olderThanID == null && newerThanID == null ) {
            return announceServiceV2.getLatestCommonAnnounces( new Date(), requestSize );
        } else if( olderThanID == null ) {
            return announceServiceV2.getCommonAnnouncesNewerThan( newerThanID, new Date(), requestSize );
        } else if( newerThanID == null ) {
            return announceServiceV2.getCommonAnnouncesOlderThan( olderThanID, new Date(), requestSize );
        } else {
            return new ResponseEntity<>( "older_than and newer_than cannot be presented in same time", HttpStatus.BAD_REQUEST );
        }
    }

    @RequestMapping( value = "v2/announce/group" )
    public Object getGroupAnnouncesV2( @RequestParam( "size" ) Integer size,
                                       @RequestParam( value = "older_than", required = false ) Integer olderThanID,
                                       @RequestParam( value = "newer_than", required = false ) Integer newerThanID ) {
        int requestSize = ( size > 0 && size <= 40 ? size : 20 );
        if( olderThanID == null && newerThanID == null ) {
            return announceServiceV2.getLatestGroupAnnounces( new Date(), requestSize );
        } else if( olderThanID == null ) {
            return announceServiceV2.getGroupAnnouncesNewerThan( newerThanID, new Date(), requestSize );
        } else if( newerThanID == null ) {
            return announceServiceV2.getGroupAnnouncesOlderThan( olderThanID, new Date(), requestSize );
        } else {
            return new ResponseEntity<>( "older_than and newer_than cannot be presented in same time", HttpStatus.BAD_REQUEST );
        }
    }

}
