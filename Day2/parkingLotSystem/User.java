import java.util.HashMap;
import java.util.Map;


public class User {

    static Map<String,Attendant> attendantMap=new HashMap<>(); //id as string
    static Map<String,Customer> customerMap=new HashMap<>();  //id as string
    static Map<String,Admin> adminMap=new HashMap<>();        //id as string

    User(){}

    public void addAttendant(String attendantId){
        if(!attendantMap.isEmpty()){
            if(attendantMap.containsKey(attendantId)){
                System.out.println("User already exists");
            }
        }
        attendantMap.put(attendantId,new Attendant(attendantId));
    }
    public void removeAttendant(String id){
        if(attendantMap.containsKey(id)){
            attendantMap.remove(id);
        }
    }
    public void getAttendant(String customerId){
        for(Attendant attendant:User.attendantMap.values()){
            attendant.clientId=customerId;
            System.out.println("Your attendant-id is : "+attendant.attendantId);
        }
    }
    public Admin addAdmin(String pass,String id){
        if(pass.equalsIgnoreCase(Admin.specialAccess)){
            Admin admin = new Admin(id);
            adminMap.put(id,admin);
            return admin;
        }else{
            System.out.println("Wrong password!");
            return null;
        }
    }
    public void removeAdmin(Admin admin){
        if(adminMap.containsKey(admin.id)){
            adminMap.remove(admin.id);
        }
    }
    public Customer createCustomer(String id){
        Customer customer= new Customer();
        customerMap.put(id,customer);
        return customer;
    }

}
class Person{
    String name;
    String id;
}
class Admin extends Person{
    static final String specialAccess="admin";
    Admin(String id){
        this.id=id;
    }
}
class Customer extends Person{
    double creditBalance;
    Vehicle vehicle;
    boolean isHandicapped;
    public void setVehicle(String name){
        vehicle=VehicleFactory.getVehicle(name);
    }
    public void setHandicapped(boolean val){isHandicapped=val;}
    public void setName(String name){
        this.name=name;
    }
    public void setCustomerId(String id){
        this.id=id;
    }
    public void setCreditBalance(double amount){
        creditBalance=amount;
    }
}
//Attendant has a customer and has a payment system as user can pay to him
//the only difference is that admin can create and delete this(allot or de-allot)
class Attendant {
    String attendantId;
    String clientId="";
    PaymentMethod paymentMethod;
    Attendant(String attendantId){
        this.attendantId=attendantId;
    }
}