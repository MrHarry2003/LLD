import java.util.HashMap;
import java.util.Map;


public class ParkingLotSystem {
    //Storing as object_id : object pairs
    //A parking system has multiple parking floors and Entry-Exit points
    Map<String,ParkingFloor> parkingFloorMap; //ParkingFloor
    Map<String,EntryPoint> entryPointMap;     //EntryPoint
    Map<String,ExitPoint> exitPointMap;       //ExitPoint
    static Map<String,Customer> allCustomers=new HashMap<>();  //for keeping track of all the customers and login purpose
    User user;                                //user-management purpose

    private ParkingLotSystem(){
        parkingFloorMap=new HashMap<>();
        entryPointMap=new HashMap<>();
        exitPointMap=new HashMap<>();
        user=new User();
    }

    static ParkingLotSystem parkingLotSystem=null;
    public static ParkingLotSystem getInstance(){
        if(parkingLotSystem==null){
            parkingLotSystem=new ParkingLotSystem();
        }
        return parkingLotSystem;
    }

    public void addParkingFloor(Admin admin,String id){parkingFloorMap.put(id,ParkingFloor.addParkingFloor(id));}
    public void removeParkingFloor(Admin admin,String id){parkingFloorMap.remove(id);}

    public void addEntryPoint(Admin admin,String id){
        entryPointMap.put(id,EntryPoint.addEntryPoint(id));
    }
    public void removeEntryPoint(Admin admin,String id){entryPointMap.remove(id);}

    public void addExitPoint(Admin admin,String id){
        exitPointMap.put(id,ExitPoint.addExitPoint(id));
    }
    public void removeExitPoint(Admin admin,String id){exitPointMap.remove(id);}

    //function of entry point :
    public Ticket getTicket(EntryPoint entryPoint,Customer customer,ParkingSpot parkingSpot){
        return entryPoint.getTicket(customer,parkingSpot);
    }

    //Parking floor function
    public void getSpot(ParkingFloor parkingfloor,Customer customer){
        parkingfloor.getSpot(customer);
    }
    public void addParkingSpot(Admin admin,ParkingFloor parkingfloor,String id,String type){
        parkingfloor.addParkingSpot(id,type);
    }
    public void removeParkingSpot(Admin admin,ParkingFloor parkingfloor,String id){
        parkingfloor.removeParkingSpot(id);
    }
    public void showPanelMessage(ParkingFloor parkingFloor){
        parkingFloor.showFreeSpace();
    }
    public void rechargeElectricCar(Customer customer,ParkingFloor parkingFloor,String electricSpotId){
        parkingFloor.rechargeElectricCar(electricSpotId);
    }
    public void addElectricCarSpot(Admin admin,ParkingFloor parkingFloor,String id){
        parkingFloor.addElectricSpot(id);
    }
    //all exit point functions
    public void scanTicket(Customer customer,String exitPointId,Ticket ticket){
        exitPointMap.get(exitPointId).scanTicket(ticket);
    }

    //if return true then payment is successful else not
    public boolean cashPayTicket(Customer customer,String exitPointId,Ticket ticket){
        return exitPointMap.get(exitPointId).paymentMethod.cashPay(ticket);
    }
    public boolean creditPayTicket(Customer customer,String exitPointId,Ticket ticket,Double amountPaid){
        return exitPointMap.get(exitPointId).paymentMethod.creditPay(amountPaid,ticket,customer);
    }

    //user functions
    public void addAttendant(Admin admin,String attendantId){
        user.addAttendant(attendantId);
    }
    public void removeAttendant(Admin admin,String attendantId){
        user.removeAttendant(attendantId);
    }
    public void getAttendant(Customer customer){
        user.getAttendant(customer.id);
    }
    public void addAdmin(Admin admin,String adminId,String pass){
        user.addAdmin(pass,adminId);
    }
    public void removeAdmin(Admin admin){
        user.removeAdmin(admin);
    }
    public void createCustomer(String id,String name,Vehicle vehicle,double creditBal,boolean isHandicapped){
        Customer customer=user.createCustomer(id);
        customer.setCustomerId(id);
        customer.setName(name);
        customer.setVehicle(vehicle.type);
        customer.setHandicapped(isHandicapped);
        customer.setCreditBalance(creditBal);
        System.out.println("your customer-id is : "+customer.id);
        allCustomers.put(id,customer); //for keeping track of all the customers and login purpose
    }

}

