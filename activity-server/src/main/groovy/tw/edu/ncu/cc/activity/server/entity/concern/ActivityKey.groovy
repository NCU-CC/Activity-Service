package tw.edu.ncu.cc.activity.server.entity.concern

import tw.edu.ncu.cc.activity.server.entity.PlaceEntity

import java.sql.Date

public class ActivityKey implements Serializable {

    def Date date
    def PlaceEntity place

    public ActivityKey() { }

    public ActivityKey( Date date, PlaceEntity place ) {
        this.date = date
        this.place = place
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true
        if ( o == null || getClass() != o.getClass() ) return false

        ActivityKey that = ( ActivityKey ) o

        if ( !date.equals( that.date ) ) return false
        return place.equals( that.place )

    }

    @Override
    public int hashCode() {
        int result = date.hashCode()
        result = 31 * result + place.hashCode()
        return result
    }

}
