import java.util.Scanner;

//Applying singleton as only one system
public class SystemATM {

    TopUp topUp;
    WithDraw withDraw;
    Scanner sc;
    //Default constructor
    SystemATM(){
        sc=new Scanner(System.in);
        topUp=TopUp.getInstance();
        withDraw=WithDraw.getInstance();
        //Adding default notes :-
        //only system can change the note values,add new notes or remove the old one and even update them using note class
        Note.getInstance().addNote(2000);
        Note.getInstance().addNote(1000);
        Note.getInstance().addNote(500);
        Note.getInstance().addNote(100);
        Note.getInstance().addNote(50);
        Note.getInstance().addNote(10);
    }

    static SystemATM systemATM=null;
    public static SystemATM getInstance(){
        if(systemATM==null){
            systemATM=new SystemATM();
        }
        return systemATM;
    }

    public void addAmount(){
        topUp.addAmount();
    }

    public void setWithDraw(){
        System.out.print("Enter the amount needed : ");
        int amount=sc.nextInt();
        withDraw.withDrawMoney(amount);
    }

}