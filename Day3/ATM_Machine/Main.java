import java.util.Scanner;

public class Main {

    static Scanner sc=new Scanner(System.in);
    static SystemATM atm=SystemATM.getInstance();
    public static void main(String[] args){

        System.out.println("Enter 'T' for Top-up or Enter 'W' for Withdrawing the money or press any key for exit :");
        String option=sc.next();

        if(option.trim().equalsIgnoreCase("t")){
            System.out.println("Welcome to the Top-Up portal :- ");
            System.out.println("Enter the amount in form of notes : ");
            atm.addAmount();
            System.out.println();
        }
        else if (option.trim().equalsIgnoreCase("w")) {
            System.out.println("Welcome to the Withdrawal portal :-: ");
            atm.setWithDraw();
        }else{
            System.out.println("Thank you for using the ATM !!!");
            return;
        }
        //Internal loop
        Main.main(args);

    }
}