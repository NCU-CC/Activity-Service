package tw.edu.ncu.cc.activity.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import tw.edu.ncu.cc.activity.data.Club;
import tw.edu.ncu.cc.activity.server.entity.ClubEntity;
import tw.edu.ncu.cc.activity.server.repository.ClubRepository;
import tw.edu.ncu.cc.activity.server.service.ClubService;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository    clubRepository;
    private ConversionService conversionService;

    @Autowired
    public void setClubRepository( ClubRepository clubRepository ) {
        this.clubRepository = clubRepository;
    }

    @Autowired
    public void setConversionService( ConversionService conversionService ) {
        this.conversionService = conversionService;
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public List<Club> getAllClubs() {
        return ( List<Club> ) conversionService.convert(
                clubRepository.getAllClubs(),
                TypeDescriptor.collection( List.class, TypeDescriptor.valueOf( ClubEntity.class ) ),
                TypeDescriptor.collection( List.class, TypeDescriptor.valueOf( Club.class ) )
        );
    }



}
