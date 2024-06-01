import java.util.HashMap;
import java.util.Map;
public class Politics{
    //can be many mps and ministers but only PM
    Map<String,MP> allMps=new HashMap<>();
    Map<String,Minister> allMinisters=new HashMap<>();
    //adding an mp
    public void addMp(String name,int age,String constituency){
        if(!allMps.containsKey(name)){
            allMps.put(name,new MP(name,age,constituency));
        }
    }
    //can only be created if he is mp
    public void createMinister(String name){
        if (!allMps.containsKey(name)) {
            System.out.println("No such MP exists so he can not be minister");
        }
        allMinisters.put(name,new Minister(allMps.get(name)));
    }
    //can only be created if he is minister
    public void setPM(String name){
        if(!allMinisters.containsKey(name)){
            System.out.println("No such minister exist so he can not be PM");
        }
        PM.setInstance(allMinisters.get(name));
    }
    //adding ministers's arrest permisson to pm
    public void addArrestPermission(String name){
        PM.getInstance().addArrestPermission(name);
    }
    //for adding balance
    public void addSpendingBal(String name,int amount){
        if(PM.getInstance().getName().compareTo(name)==0){
            PM.getInstance().addSpendingBalance(amount);
        }
        else if(allMinisters.containsKey(name)){
            allMinisters.get(name).addSpendingBalance(amount);
        }
        else if(allMps.containsKey(name)){
            allMps.get(name).addSpendingBalance(amount);
        }
    }
    //for arresting condition check
    public void canArrest(String name){
        if(PM.getInstance().getName().compareTo(name)==0){
            Commissioner.canArrest(PM.getInstance());
        }
        else if(allMinisters.containsKey(name)){
            Commissioner.canArrest(allMinisters.get(name));
        }
        else if (allMps.containsKey(name)) {
            Commissioner.canArrest(allMps.get(name));
        }
    }
    //getting the constituency name
    public String getConstituency(String name){
        if(PM.getInstance().getName().compareTo(name)==0){
            return PM.getInstance().getConstituency();
        }
        else if(allMinisters.containsKey(name)){
            return allMinisters.get(name).getConstituency();
        }
        else if(allMps.containsKey(name)){
            return allMps.get(name).getConstituency();
        }
        else{
            return "no such politician";
        }
    }
    //adding vehicle if asked buy any MP, Minister or PM
    public void addVehicle(String ownerName,String driverName,int driverAge,String vehicleNo ,String vehicleType){
        if(PM.getInstance().getName().compareTo(ownerName)==0){
            PM.getInstance().vehicle.put(vehicleNo,VehicleFactory.getVehicle(vehicleType,driverName,driverAge));
        }
        else if (vehicleType.compareTo("car")!=0) {
            System.out.println(ownerName+" cannot add any other vehicle other than car as he is not the PM");
        }
        else if(allMinisters.containsKey(ownerName)){
            allMinisters.get(ownerName).vehicle.put(vehicleNo,VehicleFactory.getVehicle(vehicleType,driverName,driverAge));
        }
        else if(allMps.containsKey(ownerName)){
            allMps.get(ownerName).vehicle.put(vehicleNo,VehicleFactory.getVehicle(vehicleType,driverName,driverAge));
        }
    }
    //grtting driver names of any owner
    public String getDriver(String vehicleNo,String ownerName){
        if(PM.getInstance().getName().compareTo(ownerName)==0){
            return PM.getInstance().vehicle.get(vehicleNo).driver.getName();
        }
        else if(allMinisters.containsKey(ownerName)){
            return allMinisters.get(ownerName).vehicle.get(vehicleNo).driver.getName();
        }
        else if(allMps.containsKey(ownerName)){
            return allMps.get(ownerName).vehicle.get(vehicleNo).driver.getName();
        }
        return "No such owner found";
    }

}