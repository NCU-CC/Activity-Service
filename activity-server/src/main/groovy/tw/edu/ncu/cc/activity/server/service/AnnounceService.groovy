package tw.edu.ncu.cc.activity.server.service

import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity

public interface AnnounceService {
    public List< AnnounceEntity > findCommonByDateOlderThan( Date dateNow, int limit );
    public List< AnnounceEntity > findGroupByDateOlderThan ( Date dateNow, int limit );

    public List< AnnounceEntity > findCommonByNewerThanIdAndDeadTimeOlderThan( int id, Date dateNow, int limit );
    public List< AnnounceEntity > findGroupByNewerThanIdAndDeadTimeOlderThan ( int id, Date dateNow, int limit );

    public List< AnnounceEntity > findCommonByOlderThanIdAndDeadTimeOlderThan( int id, Date dateNow, int limit );
    public List< AnnounceEntity > findGroupByOlderThanIdAndDeadTimeOlderThan ( int id, Date dateNow, int limit );
}
