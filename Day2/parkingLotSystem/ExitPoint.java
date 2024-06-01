public class ExitPoint {

    String exitPointId;//every exit point has its id
    private ExitPoint(String id){
        this.exitPointId=id;
    }
    public PaymentMethod paymentMethod=new PaymentMethod();

    public void scanTicket(Ticket ticket){
        long endTime=System.currentTimeMillis();
        int duration=(int)(endTime-ticket.startTime)/1000;
        System.out.println(PaymentProcess.getInstance().calculateAmount(duration));
    }

    public static ExitPoint addExitPoint(String id){
        return new ExitPoint(id);
    }

}
//Payment process remains the same for all the system so singleton applied
class PaymentProcess{

    static double firstHourRate=0;
    static double secondHourRate=0;
    static double thirdHourRate=0;
    static double restHourRate=0;

    private PaymentProcess(){}

    static PaymentProcess paymentProcess=null;

    public static PaymentProcess getInstance(){
        if(paymentProcess==null){
            paymentProcess = new PaymentProcess();
        }
        return paymentProcess;
    }

    public static void setFirstHourRate(double firstHourRate) {
        PaymentProcess.firstHourRate = firstHourRate;
    }

    public static void setSecondHourRate(double secondHourRate) {
        PaymentProcess.secondHourRate = secondHourRate;
    }

    public static void setThirdHourRate(double thirdHourRate) {
        PaymentProcess.thirdHourRate = thirdHourRate;
    }

    public static void setRestHourRate(double restHourRate) {
        PaymentProcess.restHourRate = restHourRate;
    }

    public double calculateAmount(int duration){
        if(duration<=1){
            return firstHourRate;
        }
        else if(duration<=2){
            return firstHourRate+secondHourRate;
        }
        else if(duration<=3){
            return firstHourRate+secondHourRate+thirdHourRate;
        }
        else {
            return firstHourRate+secondHourRate+thirdHourRate+(duration-3)*restHourRate;
        }
    }

}

class PaymentMethod{
    public boolean cashPay(Ticket ticket){
        //updating it as available on panel
        ParkingFloor.allFreeSpot.put(ticket.parkingSpot.id, ticket.parkingSpot);
        return true;
    }
    public boolean creditPay(double amount,Ticket ticket,Customer customer){
        if(customer.creditBalance>amount){
            customer.creditBalance=customer.creditBalance-amount;
            ParkingFloor.allFreeSpot.put(ticket.parkingSpot.id, ticket.parkingSpot);
            return true;
        }else{
            return false;
        }
    }
}