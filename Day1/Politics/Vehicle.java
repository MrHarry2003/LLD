//Super-class
class Vehicle{
    private String type;
    Driver driver;
    Vehicle(String driverName,int driverAge){
        driver=new Driver(driverName,driverAge);
    }

    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return this.type;
    }
}

class Car extends Vehicle{
    Car(String driverName,int age){
        super(driverName,age);
        super.setType("car");
    }
}
class Aircraft extends Vehicle{
    Aircraft(String driverName,int age){
        super(driverName,age);
        super.setType("aircraft");
    }
}
//Factory Pattern for assigning vehicles to politicians
class VehicleFactory{
    public static Vehicle getVehicle(String type,String driverName,int driverAge){
        if(type.trim().equalsIgnoreCase("car")){
            return new Car(driverName,driverAge);
        }
        //only pm can have other vehicles other than car
        else if(type.trim().equalsIgnoreCase("aircraft")){
            return new Aircraft(driverName,driverAge);
        }
        else{
            return null;
        }
    }
}