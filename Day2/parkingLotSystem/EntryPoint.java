import java.util.HashMap;
import java.util.Map;

public class EntryPoint {
    String id;//every entry point has its id

    private EntryPoint(String id){
        this.id=id;
    }

    public static EntryPoint addEntryPoint(String id){
        return new EntryPoint(id);
    }

    //will call this only after checking the spot is available in the system or not
    public Ticket getTicket(Customer customer,ParkingSpot parkingSpot){
        ParkingFloor.allFreeSpot.remove(parkingSpot.id,parkingSpot); //updating it as reserved on panels
        Ticket ticket= new Ticket(customer,parkingSpot);
        Ticket.allTickets.put(ticket.ownerId,ticket);
        return ticket;
    }

}

class Ticket{
    static Map<String,Ticket> allTickets=new HashMap<>();
    long startTime;
    String type;
    ParkingSpot parkingSpot;
    String ownerId; //id of customer
    Ticket(Customer customer,ParkingSpot parkingSpot){
        this.parkingSpot=parkingSpot;
        startTime=System.currentTimeMillis();
        if(customer.isHandicapped){
            this.type="handicapped";
        }else{
            this.type=customer.vehicle.type;
        }
        this.ownerId=customer.id;
    }
}