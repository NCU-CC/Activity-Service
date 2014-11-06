package tw.edu.ncu.cc.activity.server.repository;

import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity;

import java.util.List;

public interface AnnounceRepository {
    public List<AnnounceEntity> getLatestCommonAnnounces( int limit );
    public List<AnnounceEntity> getLatestGroupAnnounces ( int limit );
}
