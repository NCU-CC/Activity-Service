package tw.edu.ncu.cc.activity.server.service;

import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity;

import java.util.Date;
import java.util.List;

public interface AnnounceService {
    public List< AnnounceEntity > getLatestCommonAnnounces( Date dateNow, int limit );
    public List< AnnounceEntity > getLatestGroupAnnounces ( Date dateNow, int limit );

    public List< AnnounceEntity > getCommonAnnouncesNewerThan( int id, Date dateNow, int limit );
    public List< AnnounceEntity > getGroupAnnouncesNewerThan ( int id, Date dateNow, int limit );

    public List< AnnounceEntity > getCommonAnnouncesOlderThan( int id, Date dateNow, int limit );
    public List< AnnounceEntity > getGroupAnnouncesOlderThan ( int id, Date dateNow, int limit );
}
