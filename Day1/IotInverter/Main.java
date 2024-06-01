public class Main {
    public static void main(String[] args) {

        IotInverterCompany iotInverterCompany=new IotInverterCompany();
        //Creating different solar inverters :
        SolarInverter regilia=iotInverterCompany.createRegilia(2,5);
        SolarInverter pcu=iotInverterCompany.createPCU(3,5);
        SolarInverter gti=iotInverterCompany.createGTI(3,9);
        //creating normal inverters
        Inverter zelio=iotInverterCompany.createZelio(1,5);
        Inverter icruze=iotInverterCompany.createICruze(4,5);
        //Printing their components :
        System.out.println("PCU Inverter :- ");
        iotInverterCompany.printer.print(pcu);
        System.out.println();

        System.out.println("GTI Inverter :- ");
        iotInverterCompany.printer.print(gti);
        System.out.println();

        System.out.println("Regilia Inverter :- ");
        iotInverterCompany.printer.print(regilia);
        System.out.println();

        System.out.println("Zelio Inverter :- ");
        iotInverterCompany.printer.print(zelio);

        System.out.println("iCruze Inverter :- ");
        iotInverterCompany.printer.print(icruze);

    }
}