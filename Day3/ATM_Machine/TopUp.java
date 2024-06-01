import java.util.*;

//this class is responsible for current currency holds
//Applied Singleton
public class TopUp {

    private TopUp(){}
    static TopUp topUp=null;
    public static TopUp getInstance(){
        if(topUp==null){
            topUp=new TopUp();
        }
        return topUp;
    }

    public void addAmount(){
        //will contain notes provided by user in atm
        Scanner sc=new Scanner(System.in);
        List<Pair> topUpNotes=new ArrayList<>();
        for(Note note:Note.notes.values()){
            //Entered by the user
            System.out.print("Enter no of notes (enter 0 if dont have) of "+note.value+" note : ");
            int n=sc.nextInt();
            if(n<1){
                continue;
            }
            //making its pair value and note
            Pair topUpPair=new Pair(note);
            topUpPair.noOfNotes=n;
            //adding to the requirements
            topUpNotes.add(topUpPair);
        }
        //finally adding it to system
        CurrentBalance.addAmount(topUpNotes);
    }

}
