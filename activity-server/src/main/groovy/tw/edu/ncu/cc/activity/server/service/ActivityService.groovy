package tw.edu.ncu.cc.activity.server.service

import tw.edu.ncu.cc.activity.server.entity.ActivityEntity

public interface ActivityService {
    public List< ActivityEntity > findByStartDateOlderThan( Date startDate, int limit );
}
