//Builder design pattern
class Inverter{
    double powerRating;
    boolean battery;
    public void setPowerRating(double current, double operatingVoltage){
        this.powerRating=current*operatingVoltage;
    }
}

//Builder-class for solar inverter
class SolarInverter extends Inverter{

    private final boolean solarPanel;
    private final boolean gridOn;

    private SolarInverter(InverterBuilder obj){
        this.powerRating=obj.powerRating;
        this.battery= obj.battery;
        this.solarPanel= obj.solarPanel;
        this.gridOn= obj.gridOn;
    }
    public boolean getSolarPanel(){
        return this.solarPanel;
    }
    public boolean getGridOn(){
        return this.gridOn;
    }

    static class InverterBuilder{

        private boolean battery;
        private boolean solarPanel;
        private boolean gridOn;
        private double powerRating;

        public InverterBuilder(){
            //initialize
        }
        public InverterBuilder setPowerRating(double current,double operatingVoltage){
            this.powerRating=current*operatingVoltage;
            return this;
        }
        public InverterBuilder setBattery(){
            this.battery=true;
            return this;
        }
        public InverterBuilder setSolarPanel(){
            this.solarPanel=true;
            return this;
        }
        public InverterBuilder setGridOn(){
            this.gridOn=true;
            return this;
        }
        public SolarInverter build(){
            SolarInverter solarInverter=new SolarInverter(this);
            return solarInverter;
        }
    }
}

class Printer{
    public static void print(Inverter i) {
        System.out.print("Power-rating : " + i.powerRating + ", ");
        System.out.println("Battery : " + i.battery);
    }
    public static void print(SolarInverter i){
        System.out.print("Power-rating : " + i.powerRating + ", ");
        System.out.print("Battery : " + i.battery + ", ");
        System.out.print("Solar-Panel : "+i.getSolarPanel()+", ");
        System.out.print("Grid-on : "+i.getGridOn());
    }
}


public class IotInverterCompany {
    Printer printer=new Printer();
    public Inverter createZelio(double current,double voltage){
        Inverter inverter = new Inverter();
        inverter.battery=true;
        inverter.setPowerRating(current,voltage);
        return inverter;
    }
    public Inverter createICruze(double current,double voltage){
        Inverter inverter = new Inverter();
        inverter.battery=true;
        inverter.setPowerRating(current,voltage);
        return inverter;
    }
    public SolarInverter createGTI(double current,double voltage){
        return new SolarInverter.InverterBuilder().setSolarPanel().setGridOn().build();
    }
    public SolarInverter createPCU(double current,double voltage){
        return new SolarInverter.InverterBuilder().setSolarPanel().setBattery().setPowerRating(current,voltage).build();
    }
    public SolarInverter createRegilia(double current,double voltage){
        return new SolarInverter.InverterBuilder().setSolarPanel().setPowerRating(current,voltage).build();
    }

}