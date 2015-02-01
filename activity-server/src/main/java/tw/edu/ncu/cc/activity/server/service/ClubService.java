package tw.edu.ncu.cc.activity.server.service;

import tw.edu.ncu.cc.activity.server.entity.ClubEntity;

import java.util.List;

public interface ClubService {

    public List< ClubEntity > getAllClubs();
    public ClubEntity getClub( String id );

}
