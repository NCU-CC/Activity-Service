package tw.edu.ncu.cc.activity.data;

public class Club {

    private String name;
    private String place;
    private String website;
    private String description;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace( String place ) {
        this.place = place;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite( String website ) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        Club club = ( Club ) o;

        if ( !description.equals( club.description ) ) return false;
        if ( !name.equals( club.name ) ) return false;
        if ( !place.equals( club.place ) ) return false;
        if ( !website.equals( club.website ) ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + place.hashCode();
        result = 31 * result + website.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

}
