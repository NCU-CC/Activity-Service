package tw.edu.ncu.cc.activity.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import tw.edu.ncu.cc.activity.data.v1.Activity;
import tw.edu.ncu.cc.activity.server.entity.ActivityEntity;
import tw.edu.ncu.cc.activity.server.repository.ActivityRepository;
import tw.edu.ncu.cc.activity.server.service.ActivityService;

import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    private ActivityRepository activityRepository;
    private ConversionService conversionService;

    @Autowired
    public void setAnnounceRepository( ActivityRepository activityRepository ) {
        this.activityRepository = activityRepository;
    }

    @Autowired
    public void setConversionService( ConversionService conversionService ) {
        this.conversionService = conversionService;
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public List< Activity > getLatestActivities( Date startDate, int limit ) {
        return ( List< Activity > ) conversionService.convert(
                activityRepository.getLatestActivities( startDate, limit ),
                TypeDescriptor.collection( List.class, TypeDescriptor.valueOf( ActivityEntity.class ) ),
                TypeDescriptor.collection( List.class, TypeDescriptor.valueOf( Activity.class ) )
        );
    }

}
