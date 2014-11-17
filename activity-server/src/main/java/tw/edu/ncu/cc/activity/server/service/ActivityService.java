package tw.edu.ncu.cc.activity.server.service;

import tw.edu.ncu.cc.activity.data.v1.Activity;

import java.util.Date;
import java.util.List;

public interface ActivityService {
    public List< Activity > getLatestActivities( Date startDate, int limit );
}
