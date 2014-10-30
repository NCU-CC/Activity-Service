package tw.edu.ncu.cc.activity.server.webservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ncu.cc.activity.data.Activity;
import tw.edu.ncu.cc.activity.data.Announce;
import tw.edu.ncu.cc.activity.data.Club;

import java.util.Date;

@RestController
@RequestMapping( value = "v1", method = RequestMethod.GET )
public class FakeWebService {

    @RequestMapping( value = "announce/group/{size}" )
    public Announce[] getGroupAnnounces( @PathVariable( "size" ) int size ) {
        Announce[] announces = new Announce[3];

        Announce announce = new Announce();
        announce.setTitle( "組務公告01" );
        announce.setContent( "該洗洗睡囉!" );
        announce.setTime( new Date() );
        announces[0] = announce;

        announce = new Announce();
        announce.setTitle( "組務公告02" );
        announce.setContent( "該起床尿尿囉!" );
        announce.setTime( new Date() );
        announces[1] = announce;

        announce = new Announce();
        announce.setTitle( "組務公告03" );
        announce.setContent( "你還是乾脆起床吧" );
        announce.setTime( new Date() );
        announces[2] = announce;

        return announces;
    }

    @RequestMapping( value = "announce/common/{size}" )
    public Announce[] getCommonAnnounces( @PathVariable( "size" ) int size ) {
        Announce[] announces = new Announce[4];

        Announce announce = new Announce();
        announce.setTitle( "一般公告01" );
        announce.setContent( "野" );
        announce.setTime( new Date() );
        announces[0] = announce;

        announce = new Announce();
        announce.setTitle( "一般公告02" );
        announce.setContent( "格" );
        announce.setTime( new Date() );
        announces[1] = announce;

        announce = new Announce();
        announce.setTitle( "一般公告03" );
        announce.setContent( "炸" );
        announce.setTime( new Date() );
        announces[2] = announce;

        announce = new Announce();
        announce.setTitle( "一般公告04" );
        announce.setContent( "斷!" );
        announce.setTime( new Date() );
        announce.setAttachment( "http://www.cc.ncu.edu.tw/" );
        announces[3] = announce;

        return announces;
    }

    @RequestMapping( value = "activity/{size}" )
    public Activity[] getActivities( @PathVariable( "size" ) int size ) {
        Activity[] activities = new Activity[3];

        Activity activity = new Activity();
        activity.setName( "戰隊積分" );
        activity.setClub( "英雄聯盟" );
        activity.setPlace( "召喚峽谷" );
        activity.setContent( "輸了就刪戰隊" );
        activity.setStart( new Date() );
        activity.setEnd( new Date( System.currentTimeMillis() + 5000 ) );
        activities[0] = activity;

        activity = new Activity();
        activity.setName( "糾團吃宵" );
        activity.setClub( "十三舍全體宿民" );
        activity.setPlace( "宵夜街" );
        activity.setContent( "一路吃到掛" );
        activity.setStart( new Date() );
        activity.setEnd( new Date( System.currentTimeMillis() + 10000 ) );
        activities[1] = activity;

        activity = new Activity();
        activity.setName( "試吃維力大乾麵-地獄辣椒風味" );
        activity.setClub( "自己" );
        activity.setPlace( "宿舍房間" );
        activity.setContent( "誰騙我說不會辣的???" );
        activity.setStart( new Date() );
        activity.setEnd( new Date( System.currentTimeMillis() + 15000 ) );
        activities[2] = activity;

        return activities;
    }

    @RequestMapping( value = "club" )
    public Club[] getClubs() {
        Club[] clubs = new Club[2];

        Club club = new Club();
        club.setName( "回家社" );
        club.setPlace( "家裡" );
        club.setDescription( "回家真好" );
        clubs[0] = club;

        club = new Club();
        club.setName( "躲貓貓社" );
        club.setPlace( "全校" );
        club.setWebsite( "http://www.cc.ncu.edu.tw/" );
        club.setDescription( "說好的社長呢?" );
        clubs[1] = club;

        return clubs;
    }



}
