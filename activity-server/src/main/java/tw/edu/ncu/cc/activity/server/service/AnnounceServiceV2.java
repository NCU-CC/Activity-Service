package tw.edu.ncu.cc.activity.server.service;

import tw.edu.ncu.cc.activity.data.v2.Announce;

import java.util.Date;
import java.util.List;

public interface AnnounceServiceV2 {

    public List<Announce > getLatestCommonAnnounces( Date dateNow, int limit );
    public List<Announce> getLatestGroupAnnounces ( Date dateNow, int limit );

    public List<Announce > getCommonAnnouncesNewerThan( int id, Date dateNow, int limit );
    public List<Announce> getGroupAnnouncesNewerThan ( int id, Date dateNow, int limit );

    public List<Announce> getCommonAnnouncesOlderThan( int id, Date dateNow, int limit );
    public List<Announce> getGroupAnnouncesOlderThan ( int id, Date dateNow, int limit );

}
