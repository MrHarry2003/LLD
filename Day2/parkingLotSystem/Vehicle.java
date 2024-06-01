public class Vehicle {
    String type;
}
class Car extends Vehicle{
    Car(){
        this.type="compact";
    }
}
class Truck extends Vehicle{
    Truck(){
        this.type="Large";
    }
}
class Bike extends Vehicle{
    Bike(){
        this.type="motorcycle";
    }
}
class ElectricCar extends  Vehicle{
    ElectricCar(){
        this.type="electric";
    }
}
class LargeVehicle extends Vehicle{
    LargeVehicle(){
        this.type="large";
    }
}
class VehicleFactory{
    public static Vehicle getVehicle(String name){
        if(name.trim().equalsIgnoreCase("car")){
            return new Car();
        }
        else if(name.trim().equalsIgnoreCase("truck")){
            return new Truck();
        }
        else if(name.trim().equalsIgnoreCase("electriccar")){
            return new ElectricCar();
        }
        else if(name.trim().equalsIgnoreCase("bike")){
            return new Bike();
        }else{
            return new LargeVehicle();
        }
    }
}