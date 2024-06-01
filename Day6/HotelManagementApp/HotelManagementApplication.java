//singleton class as only one application system management services
public class HotelManagementApplication {

    HotelManagement hotelManagement=new HotelManagement();
    UserManagement userManagement=new UserManagement();

    static HotelManagementApplication hotelManagementApplication=null;
    private HotelManagementApplication(){}
    public static HotelManagementApplication getInstance(){
        if(hotelManagementApplication==null){
            hotelManagementApplication=new HotelManagementApplication();
        }
        return hotelManagementApplication;
    }

    //user-management related functions
    public void registerNormalUser(String name,String id){
        userManagement.registerPortal.registerNormalUser(name,id);
    }
    public void registerHotelAgent(String name,String agentId){
        userManagement.registerPortal.registerHotelAgent(name,agentId);
    }
    public void deleteNormalUser(Administer admin,String userId){
        userManagement.deleteNormalUser(userId);
    }
    public void deleteHotelAgent(Administer admin,String agentId){
        userManagement.deleteHotelAgent(agentId);
    }
    public void updateNormalUserName(NormalUser user,String newName){
        userManagement.updateUserName(user,newName);
    }
    public void updateNormalUserId(NormalUser user,String newId){
        userManagement.updateUserId(user,newId);
    }

    //Hotel-Management related functions
    public void approveHotel(Administer administer,String hotelId){
        hotelManagement.approveHotel(hotelId);
    }
    public void deleteHotel(Administer administer,String hotelId){
        hotelManagement.deleteHotel(hotelId);
    }
    public void addHotel(HotelAgent agent,String hotelName,String hotelId,String location,int noOfRooms){
        hotelManagement.addHotel(hotelName,hotelId,location,noOfRooms);
    }
    public void searchHotel(NormalUser user,String criteria){
        hotelManagement.searchHotel(criteria);
    }
    public void displayAllHotel(){
        hotelManagement.displayAllHotel();
    }
    public void bookHotelRoom(NormalUser user,String hotelId){
        hotelManagement.bookHotelRoom(hotelId);
    }
    public void rateHotel(NormalUser user,String hotelId,double rating){
        hotelManagement.rateHotel(hotelId,rating);
    }
    public void addHotelRoom(HotelAgent agent,String hotelId,String newRoomId){
        hotelManagement.addHotelRoom(hotelId,newRoomId);
    }
    public void updateHotelRoom(HotelAgent agent,String hotelId,String oldRoomId,String newRoomId){
        hotelManagement.updateHotelRoomId(hotelId,oldRoomId,newRoomId);
    }
    public void updateHotelName(HotelAgent agent,String hotelId,String newName){
        hotelManagement.updateHotelName(hotelId,newName);
    }

}
