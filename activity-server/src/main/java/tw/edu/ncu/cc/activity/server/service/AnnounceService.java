package tw.edu.ncu.cc.activity.server.service;

import tw.edu.ncu.cc.activity.data.v1.Announce;

import java.util.Date;
import java.util.List;

public interface AnnounceService {

    public List<Announce> getLatestCommonAnnounces( Date dateNow, int limit );
    public List<Announce> getLatestGroupAnnounces ( Date dateNow, int limit );

}
