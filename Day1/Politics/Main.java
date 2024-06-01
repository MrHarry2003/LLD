public class Main {
    public static void main(String[] args) {

        Politics politics=new Politics();
        //Adding MPs
        politics.addMp("Bidhuri",50,"chattarpur");
        politics.addMp("Arvind",45,"Delhi-cant");
        politics.addMp("Modi",60,"vadodra");
        //creating Ministers and Pm
        politics.createMinister("Arvind");
        politics.createMinister("Modi");
        politics.setPM("Modi");
        //Adding vehicles
        politics.addVehicle("Modi","Gagan",40,"GJ100","aircraft");
        politics.addVehicle("Arvind","Sagar",40,"DL100","car");
        politics.addVehicle("Bidhuri","Dagar",40,"UP108","car");
        politics.addVehicle("Bidhuri","Dagar2",40,"UP190","aircraft");
        //Adding their balance
        politics.addSpendingBal("Arvind",1000001);
        politics.addSpendingBal("Bidhuri",10000);
        politics.addSpendingBal("Modi",10000999);
        //adding arrest permission of minister arvind
        politics.addArrestPermission("Arvind");
        //checking who can be arrested
        politics.canArrest("Arvind");
        politics.canArrest("Bidhuri");
        politics.canArrest("Modi");
        //getting their driver names
        String driverOfAircraftOfPM=politics.getDriver("GJ100","Modi");
        String constituencyOfMP=politics.getConstituency("Bidhuri");

        System.out.println("The aircraft driver of PM : "+driverOfAircraftOfPM);
        System.out.println("The constituency of MP bidhuri is : "+constituencyOfMP);

    }
}