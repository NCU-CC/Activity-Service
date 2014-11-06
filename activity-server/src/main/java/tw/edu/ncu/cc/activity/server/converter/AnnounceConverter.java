package tw.edu.ncu.cc.activity.server.converter;

import org.springframework.core.convert.converter.Converter;
import tw.edu.ncu.cc.activity.data.Announce;
import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity;

public class AnnounceConverter implements Converter< AnnounceEntity, Announce > {

    @Override
    public Announce convert( AnnounceEntity source ) {
        Announce announce = new Announce();
        announce.setTime( source.getTime() );
        announce.setTitle( source.getTitle() );
        announce.setContent( source.getContent() );
        announce.setAttachment( source.getAttachment() );
        return announce;
    }

}
