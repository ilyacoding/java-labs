package by.ilyacoding.servicehotels.bean;

/**
 * Created by ilyacoding on 11/28/2017.
 */
public class Request extends Entity {
    private int userId;
    private String hotelName;
    private int placesCount;
    private int hotelId;

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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

        Request request = (Request) o;

        if (userId != request.userId) return false;
        if (placesCount != request.placesCount) return false;
        if (hotelId != request.hotelId) return false;
        return hotelName != null ? hotelName.equals(request.hotelName) : request.hotelName == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + userId;
        result = 31 * result + (hotelName != null ? hotelName.hashCode() : 0);
        result = 31 * result + placesCount;
        result = 31 * result + hotelId;
        return result;
    }

    @Override
    public String toString() {
        return "Request{" +
                "userId=" + userId +
                ", hotelName='" + hotelName + '\'' +
                ", placesCount=" + placesCount +
                ", hotelId=" + hotelId +
                '}';
    }
}
