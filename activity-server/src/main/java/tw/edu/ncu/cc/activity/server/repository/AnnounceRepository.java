package tw.edu.ncu.cc.activity.server.repository;

import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity;

import java.util.Date;
import java.util.List;

public interface AnnounceRepository {
    public List<AnnounceEntity> getLatestCommonAnnounces( Date dateNow, int limit );
    public List<AnnounceEntity> getLatestGroupAnnounces ( Date dateNow, int limit );
}
