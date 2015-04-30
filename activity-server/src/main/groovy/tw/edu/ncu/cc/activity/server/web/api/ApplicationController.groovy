package tw.edu.ncu.cc.activity.server.web.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.ConversionService
import org.springframework.core.convert.TypeDescriptor
import org.springframework.stereotype.Component

@Component
public class ApplicationController {

    @Autowired
    def ConversionService conversionService

    @SuppressWarnings( "unchecked" )
    protected  < S, T > T[] convert( Object source, Class< S > sourceType, Class< T > targetType ) {
        return ( T[] ) getConversionService().convert(
                source,
                TypeDescriptor.collection( List.class, TypeDescriptor.valueOf( sourceType ) ),
                TypeDescriptor.array( TypeDescriptor.valueOf( targetType ) )
        )
    }

}
