import java.util.HashMap;
import java.util.Map;

public class HotelManagement {

    static Map<String,Hotel> approvedHotel=new HashMap<>(); //only approved hotels by the admin are added in this
    static Map<String,Hotel> pendingApprovalHotel=new HashMap<>(); //it will contain all the hotels that are not approved

    //only hotel agent can add the hotel for approval and register that for the site
    public void addHotel(String hotelName,String hotelId,String location,int noOfRooms){
        pendingApprovalHotel.put(hotelId,new Hotel(hotelName,hotelId,location,noOfRooms));
    }
    //Admin related functions here
    public void approveHotel(String hotelId){
        //adding the hotel in approved list and removing it from the pending list
        HotelManagement.approvedHotel.put(hotelId,HotelManagement.pendingApprovalHotel.get(hotelId));
        HotelManagement.pendingApprovalHotel.remove(hotelId);
    }
    //for showing the list of hotels
    public void displayAllHotel(){
        for(Hotel hotel:approvedHotel.values()){
            System.out.println("Name of the hotel-->"+hotel.hotelName+" , location of hotel-->"+hotel.location+" , " +
                    "hotel-id of hotel-->"+hotel.hotelId+" , Rating : "+getRating(hotel));
        }
    }
    //for searching a particular hotel based on its name or location
    public void searchHotel(String criteria){
        //will search in approved hotel only
        for(Hotel hotel:HotelManagement.approvedHotel.values()){
            if(criteria.trim().equalsIgnoreCase(hotel.hotelName)){
                System.out.println("Name of the hotel-->"+hotel.hotelName+" , location of hotel-->"+hotel.location+" , " +
                        "hotel-id of hotel-->"+hotel.hotelId+" , Rating : "+getRating(hotel));
            }
            if(criteria.trim().equalsIgnoreCase(hotel.location)){
                System.out.println("Name of the hotel-->"+hotel.hotelName+" , location of hotel-->"+hotel.location+
                        " , hotel-id of hotel-->"+hotel.hotelId+" , Rating : "+getRating(hotel));
            }
        }
    }
    //booking a room of a particular hotel
    public void bookHotelRoom(String hotelId){
        //will search in approved hotel only
        Hotel hotel=HotelManagement.approvedHotel.get(hotelId);
        for(HotelRoom room:hotel.totalRooms){
            if(!room.isReserved){
                room.isReserved=true;
                System.out.println("Room reserved with room-id : "+room.id);
                break;
            }
        }
    }
    //for rating a particular hotel
    public void rateHotel(String hotelId,double rating){
        Hotel hotel=HotelManagement.approvedHotel.get(hotelId);
        hotel.rating+=rating;
        hotel.totalRatingDone++;
    }
    public String getRating(Hotel hotel){
        if(hotel.totalRatingDone==0){
            return "No ratings done";
        }
        double avgRating=hotel.rating/hotel.totalRatingDone;
        return String.valueOf(avgRating);
    }
    //if hotel agent want to modify the hotel details they can use the following functions:
    public void addHotelRoom(String hotelId,String roomId){
        Hotel hotel=HotelManagement.approvedHotel.get(hotelId);
        HotelRoom newRoom=new HotelRoom();
        newRoom.id=roomId;
        hotel.totalRooms.add(newRoom);
    }
    public void updateHotelRoomId(String hotelId,String oldRoomId,String newRoomId){
        Hotel hotel=HotelManagement.approvedHotel.get(hotelId);
        for(HotelRoom room:hotel.totalRooms){
            if(room.id.compareTo(oldRoomId)==0){
                room.id=newRoomId;
                return;
            }
        }
    }
    //delete Hotel and the corresponding agent
    public void deleteHotel(String hotelId){
        HotelManagement.approvedHotel.remove(hotelId);
    }
    //if hotel agent want to change the name of the hotel
    public void updateHotelName(String hotelId,String newName){
        HotelManagement.approvedHotel.get(hotelId).hotelName=newName;
    }

}
