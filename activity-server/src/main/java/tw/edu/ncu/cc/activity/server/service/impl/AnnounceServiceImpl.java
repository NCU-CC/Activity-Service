package tw.edu.ncu.cc.activity.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import tw.edu.ncu.cc.activity.data.v1.Announce;
import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity;
import tw.edu.ncu.cc.activity.server.repository.AnnounceRepository;
import tw.edu.ncu.cc.activity.server.service.AnnounceService;

import java.util.Date;
import java.util.List;

@Service
public class AnnounceServiceImpl implements AnnounceService {

    private AnnounceRepository announceRepository;
    private ConversionService conversionService;

    @Autowired
    public void setAnnounceRepository( AnnounceRepository announceRepository ) {
        this.announceRepository = announceRepository;
    }

    @Autowired
    public void setConversionService( ConversionService conversionService ) {
        this.conversionService = conversionService;
    }

    @Override
    public List<Announce> getLatestCommonAnnounces( Date dateNow, int limit ) {
        return getAnnounces( announceRepository.getLatestCommonAnnounces( dateNow, limit ) );
    }

    @Override
    public List<Announce> getLatestGroupAnnounces( Date dateNow, int limit ) {
        return getAnnounces( announceRepository.getLatestGroupAnnounces( dateNow, limit ) );
    }

    @SuppressWarnings( "unchecked" )
    private List<Announce> getAnnounces( List<AnnounceEntity> announceEntities ) {
        return ( List<Announce > ) conversionService.convert(
                announceEntities,
                TypeDescriptor.collection( List.class, TypeDescriptor.valueOf( AnnounceEntity.class ) ),
                TypeDescriptor.collection( List.class, TypeDescriptor.valueOf( Announce.class ) )
        );
    }

}
