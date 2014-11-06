package tw.edu.ncu.cc.activity.server.converter;

import org.springframework.core.convert.converter.Converter;
import tw.edu.ncu.cc.activity.data.Club;
import tw.edu.ncu.cc.activity.server.entity.ClubEntity;

public class ClubConverter implements Converter< ClubEntity, Club > {

    @Override
    public Club convert( ClubEntity source ) {
        Club club = new Club();
        club.setName( source.getName() );
        club.setPlace( source.getPlace() );
        club.setWebsite( source.getWebsite() );
        club.setDescription( source.getDescription() );
        return club;
    }

}
