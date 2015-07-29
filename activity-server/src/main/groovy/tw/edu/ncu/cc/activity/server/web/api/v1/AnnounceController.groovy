package tw.edu.ncu.cc.activity.server.web.api.v1

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tw.edu.ncu.cc.activity.data.v2.Announce
import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity
import tw.edu.ncu.cc.activity.server.service.AnnounceService
import tw.edu.ncu.cc.activity.server.web.api.ApplicationController

@RestController
@RequestMapping( value = "v1/announces", method = RequestMethod.GET )
public class AnnounceController extends ApplicationController {

    @Autowired
    def AnnounceService announceService

    @RequestMapping
    public Object index( @RequestParam( "type" ) String type,
                         @RequestParam( value = "size", defaultValue = "20" ) Integer size,
                         @RequestParam( value = "older_than", required = false ) Integer olderThanID,
                         @RequestParam( value = "newer_than", required = false ) Integer newerThanID ) {

        switch ( type ) {
            case "common":
                decideCommonAnnounces( size, olderThanID, newerThanID )
                break
            case "group":
                decideGroupAnnounces ( size, olderThanID, newerThanID )
                break
            default:
                new ResponseEntity<>( "type can only be common or group", HttpStatus.BAD_REQUEST );
        }
    }

    def decideCommonAnnounces( Integer size, Integer olderThanId, Integer newerThanId ) {
        int requestSize = ( size > 0 && size <= 40 ? size : 20 );
        if( olderThanId == null && newerThanId == null ) {
            convert( announceService.findCommonByDateOlderThan( new Date(), requestSize ) );
        } else if( olderThanId == null ) {
            convert( announceService.findCommonByNewerThanIdAndDeadTimeOlderThan( newerThanId, new Date(), requestSize ) );
        } else {
            convert( announceService.findCommonByOlderThanIdAndDeadTimeOlderThan( olderThanId, new Date(), requestSize ) );
        }
    }

    def decideGroupAnnounces( Integer size, Integer olderThanId, Integer newerThanId ) {
        int requestSize = ( size > 0 && size <= 40 ? size : 20 );
        if( olderThanId == null && newerThanId == null ) {
            convert( announceService.findGroupByDateOlderThan( new Date(), requestSize ) );
        } else if( olderThanId == null ) {
            convert( announceService.findGroupByNewerThanIdAndDeadTimeOlderThan( newerThanId, new Date(), requestSize ) );
        } else {
            convert( announceService.findGroupByOlderThanIdAndDeadTimeOlderThan( olderThanId, new Date(), requestSize ) );
        }
    }

    private Announce[] convert( List< AnnounceEntity > announces ) {
        convert( announces, AnnounceEntity.class, Announce.class );
    }

}
