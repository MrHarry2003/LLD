
import java.util.HashMap;

public class ParkingFloor {

    String parkingFloorId;
    HashMap<String,ParkingSpot> parkingSpotMap; // storing id : spot values
    InfoPanel infoPanel=new InfoPanel();     //each floor has its own panel
    static HashMap<String,ParkingSpot> allFreeSpot=new HashMap<>();
    HashMap<String,ElectricParkingSpot> electricParkingSpotMap=new HashMap<>();
    //did this so that only admin can access this
    private ParkingFloor(String id){
        this.parkingFloorId=id;
        parkingSpotMap=new HashMap<>();
    }
    public void addElectricSpot(String id){
        electricParkingSpotMap.put(id,new ElectricParkingSpot(id));
    }
    public void rechargeElectricCar(String electricSpotId){
        electricParkingSpotMap.get(electricSpotId).electricPanel.chargeBattery();
    }
    public void getSpot(Customer customer){
        for(ParkingSpot parkingSpot : ParkingFloor.allFreeSpot.values()){
            if(customer.isHandicapped && parkingSpot.type.equalsIgnoreCase("handicapped")){
                System.out.println("Parking spot found -->"+parkingSpot.id);
            }
        }
        for(ParkingSpot parkingSpot : ParkingFloor.allFreeSpot.values()){
            if(customer.vehicle.type.equalsIgnoreCase(parkingSpot.type)){
                System.out.println("Parking spot found -->"+parkingSpot.id);
            }
        }
    }

    public static ParkingFloor addParkingFloor(String id){
        return new ParkingFloor(id);
    }

    public void addParkingSpot(String id,String type){
        ParkingSpot parkingSpot=ParkingSpotFactory.getParkingSpot(type,id);
        allFreeSpot.put(id,parkingSpot);
        parkingSpotMap.put(id,parkingSpot);
    }
    public void removeParkingSpot(String id){
        if(parkingSpotMap.containsKey(id)){
            allFreeSpot.remove(id);
            parkingSpotMap.remove(id);
        }
    }

    public void showFreeSpace(){ infoPanel.showFreeSpot();}

}
class ParkingSpot{
    String id;
    String type;
}
class HandicappedParkingSpot extends ParkingSpot{
    HandicappedParkingSpot(String id){
        this.id=id;
        this.type="handicapped";
    }
}
class CompactParkingSpot extends ParkingSpot{
    CompactParkingSpot(String id){
        this.id=id;
        this.type="compact";
    }
}
class LargeParkingSpot extends ParkingSpot{
    LargeParkingSpot(String id){
        this.id=id;
        this.type="large";
    }
}
class MotorcycleParkingSpot extends ParkingSpot{
    MotorcycleParkingSpot(String id){
        this.id=id;
        this.type="motorcycle";
    }
}
class ElectricParkingSpot extends ParkingSpot{
    //each electric spot has its own electric panel
    ElectricPanel electricPanel=new ElectricPanel();
    ElectricParkingSpot(String id){
        this.id=id;
        this.type="electric";
    }
}
class ElectricPanel{
    public void chargeBattery(){
            System.out.println("Battery charge successful!");
    }
}
//Factory for Parking spot
class ParkingSpotFactory{
    public static ParkingSpot getParkingSpot(String type,String id){
        if(type.trim().equalsIgnoreCase("compact")){
            return new CompactParkingSpot(id);
        }
        if(type.trim().equalsIgnoreCase("handicapped")){
            return new HandicappedParkingSpot(id);
        }
        if(type.trim().equalsIgnoreCase("large")){
            return new LargeParkingSpot(id);
        }
        if(type.trim().equalsIgnoreCase("motorcycle")){
            return new MotorcycleParkingSpot(id);
        }
        else{
            return null;
        }
    }
}
//Panel responsible for showing messages sent from system to it
class InfoPanel{
    public void showFreeSpot(){
        if(ParkingFloor.allFreeSpot.size()==0){
            System.out.println("All spots are full.");
            return;
        }
        for(ParkingSpot parkingSpot:ParkingFloor.allFreeSpot.values()){
            System.out.println("Parking spot of type "+parkingSpot.type+" of id "+parkingSpot.id+" is free.");
        }
    }
}
