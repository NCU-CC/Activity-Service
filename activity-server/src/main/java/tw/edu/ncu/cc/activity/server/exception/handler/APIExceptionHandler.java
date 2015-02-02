package tw.edu.ncu.cc.activity.server.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {

    private Logger logger = LoggerFactory.getLogger( this.getClass() );

    @ExceptionHandler( Exception.class )
    public ResponseEntity exceptionHandler( Exception e ) {
        logger.error( "INTERNAL SERVER", e );
        return new ResponseEntity<>(
                e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
