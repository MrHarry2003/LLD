import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Applied Singleton
public class WithDraw {

    static WithDraw withDraw=null;
    private WithDraw(){};

    public static WithDraw getInstance(){
        if(withDraw==null){
            withDraw=new WithDraw();
        }
        return withDraw;
    }
    //Finds all the available options for implementation of it on screen for the option selection by user
    //Applying greedy algorithm
    public void withDrawMoney(int amount){

        if(CurrentBalance.totalBalance < amount){
            System.out.println("Insufficient balance!");
            return ;
        }
        List<Pair> currentNotes=new ArrayList<Pair>(); //getting current notes
        for(Pair pair : CurrentBalance.currentNotes.values()){
            currentNotes.add(pair);
        }
        //sorting it in descending order for greedy approach of withdrawal money
        Collections.sort(currentNotes,(a, b)->b.note.value-a.note.value);
        //Applying greedy algorithm for withdrawal now and if amount becomes zero then will the list of notes stored
        //else return null with error message
        List<Pair> deductedNote=new ArrayList<Pair>();//will add the deducted notes here

        //traversing from highest value to lowest and deducting from amount
        //if amount==0 then value can be given by atm
        for(int i=0;i<currentNotes.size();i++){

            if(amount<currentNotes.get(i).note.value){
                continue;
            }

            int n=amount/currentNotes.get(i).note.value;
            amount=amount%currentNotes.get(i).note.value;
            Pair deducted=new Pair(currentNotes.get(i).note);
            deducted.noOfNotes=n;
            deductedNote.add(deducted);

            if(amount==0){
                //value of amount can be paid by atm
                System.out.println("Notes withdrawn :-");
                //deducting those notes from system
                CurrentBalance.deductAmount(deductedNote);
                //printing notes withdrawn from user
                printDeductedNote(deductedNote);
                return ;
            }

        }
        //amount did'nt became 0 that mean insufficient of required notes
        System.out.println("Error in withdrawing money -> not suitable notes in system.");
        return ;
    }

    private void printDeductedNote(List<Pair> deductedNote){
        for (Pair pair:deductedNote){
            System.out.println("Note : "+pair.note.value+" --> number of notes : "+pair.noOfNotes);
        }
    }
}