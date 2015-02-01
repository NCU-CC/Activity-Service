package tw.edu.ncu.cc.activity.server.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationController {

    private ConversionService conversionService;

    public ConversionService getConversionService() {
        return conversionService;
    }

    @Autowired
    public void setConversionService( ConversionService conversionService ) {
        this.conversionService = conversionService;
    }

    @SuppressWarnings( "unchecked" )
    protected  < S, T > T[] convert( Object source, Class< S > sourceType, Class< T > targetType ) {
        return ( T[] ) getConversionService().convert(
                source,
                TypeDescriptor.collection( List.class, TypeDescriptor.valueOf( sourceType ) ),
                TypeDescriptor.array( TypeDescriptor.valueOf( targetType ) )
        );
    }

}
