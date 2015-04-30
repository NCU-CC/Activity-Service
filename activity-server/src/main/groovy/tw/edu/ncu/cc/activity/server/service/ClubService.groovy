package tw.edu.ncu.cc.activity.server.service

import tw.edu.ncu.cc.activity.server.entity.ClubEntity

public interface ClubService {

    public List< ClubEntity > findAll();
    public ClubEntity findById( String id );

}
