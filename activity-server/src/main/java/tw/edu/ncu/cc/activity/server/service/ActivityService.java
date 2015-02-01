package tw.edu.ncu.cc.activity.server.service;

import tw.edu.ncu.cc.activity.server.entity.ActivityEntity;

import java.util.Date;
import java.util.List;

public interface ActivityService {
    public List< ActivityEntity > getLatestActivities( Date startDate, int limit );
}
