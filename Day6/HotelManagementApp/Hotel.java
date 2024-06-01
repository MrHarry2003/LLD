import java.util.ArrayList;
import java.util.List;

public class Hotel {
    String hotelId;
    String hotelName;
    String location;
    double rating; //for rating purpose
    double totalRatingDone; //for calculating the average rating
    int noOfRoom;
    List<HotelRoom> totalRooms;
    Hotel(String hotelName,String id,String location,int noOfRoom){
        this.hotelId=id;
        this.hotelName=hotelName;
        this.location=location;
        this.noOfRoom=noOfRoom;
        totalRooms=new ArrayList<>();
        //initializing the default rooms of the hotel room
        for(int i=0;i<noOfRoom;i++){
            HotelRoom room=new HotelRoom();
            room.id=String.valueOf(i);
            totalRooms.add(room);
        }
    }
}
class HotelRoom{
    String id;
    boolean isReserved; //showing if the room status is booked or not
}

