package tw.edu.ncu.cc.activity.server.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter< Date > {

    @Override
    public Date parse( String text, Locale locale ) throws ParseException {
        return null;
    }

    @Override
    public String print( Date object, Locale locale ) {
        return null;
    }

}
