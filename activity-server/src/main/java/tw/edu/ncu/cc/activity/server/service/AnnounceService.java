package tw.edu.ncu.cc.activity.server.service;

import tw.edu.ncu.cc.activity.data.Announce;

import java.util.List;

public interface AnnounceService {

    public List<Announce> getLatestCommonAnnounces( int limit );
    public List<Announce> getLatestGroupAnnounces ( int limit );

}
