package by.ilyacoding.servicehotels.bean;

/**
 * Created by ilyacoding on 11/28/2017.
 */
public class Hotel extends Entity {

    private String name;
    private int placesCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlacesCount() {
        return placesCount;
    }

    public void setPlacesCount(int placesCount) {
        this.placesCount = placesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Hotel hotel = (Hotel) o;

        if (placesCount != hotel.placesCount) return false;
        return name != null ? name.equals(hotel.name) : hotel.name == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + placesCount;
        return result;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", placesCount=" + placesCount +
                '}';
    }
}
