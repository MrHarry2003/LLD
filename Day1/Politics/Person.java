import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//Super-class
class Person{
    private int age;
    private String name;
    Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }
}

class Driver extends Person{
    Driver(String name,int age){
        super(name,age);
    }
    String getDriverName(){
        return this.getName();
    }
}
class MP extends Person{

    MP(String name,int age,String constituency){
        super(name,age);
        this.setConstituency(constituency);
    }
    //we can add various other model in future by declaring the object as vehicle here in future
    Map<String,Vehicle> vehicle=new HashMap<>();//key as car_no.
    private int spendingBalance=0;
    private String constituency;

    public void addSpendingBalance(int spendings){
        this.spendingBalance+=spendings;
    }
    public int getSpendingBalance(){
        return this.spendingBalance;
    }
    public void setConstituency(String name){
        this.constituency=name;
    }
    public String getDriver(String carNo){return vehicle.get(carNo).driver.getName();};
    public String getConstituency(){
        return this.constituency;
    }
    public boolean exceedsSpendingLimit(){
        return (this.spendingBalance>=100000);
    }
}

class Minister extends MP{
    Minister(MP mp){
        super(mp.getName(), mp.getAge(),mp.getConstituency());
    }
    //For PM constructor
    Minister(Minister minister){
        super(minister.getName(),minister.getAge(),minister.getConstituency());
    }
    @Override
    public boolean exceedsSpendingLimit() {
        return this.getSpendingBalance()>=1000000;
    }
}
//Applying Singleton of design Pattern as there is only one PM
class PM extends Minister{
    static PM pm=null;
    private static HashSet<String> permission=new HashSet<>(); //Pm holds permission to arrest any MPS or Ministers
    public void addArrestPermission(String minister){
        permission.add(minister);
    }
    public boolean getPermission(String name){
        return permission.contains(name);
    }

    private PM(){
        super(pm);
    }
    private PM(Minister minister){
        super(minister);
    }
    public static synchronized void setInstance(Minister minister){
        if(pm==null){
            pm=new PM(minister);
        }
    }
    public static synchronized PM getInstance(){
        if(pm==null){
            System.out.print("Error --> Set the PM instance first");
        }
        return pm;
    }
}
