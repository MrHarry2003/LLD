import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Applied SingleTon as the whole system has only balance of amount
public class CurrentBalance{

    static int totalBalance;
    //this below map is used for accessing the current note management such as total no of notes of every type
    static Map<Integer,Pair> currentNotes= new HashMap<>();  // valueOfNote as Key here

    static CurrentBalance currentBalance=null;
    private CurrentBalance(){}

    public static CurrentBalance getInstance(){
        if(currentBalance==null){
            currentBalance=new CurrentBalance();
        }
        return currentBalance;
    }
    //add amounts by adding notes in current total no notes in atm
    public static void addAmount(List<Pair> amount){
        for(Pair pair : amount){
            //calculating amount generated by each no of notes of each value and adding to total balance of atm
            int amountGenerated = pair.noOfNotes*pair.note.value;
            totalBalance+=amountGenerated;
            //if notes of given type is not present then add it to the system
            if(!currentNotes.containsKey(pair.note.value)){
                currentNotes.put(pair.note.value,pair);
                continue;
            }
            //if notes are present then :
            Pair currentNotePair=currentNotes.get(pair.note.value);
            currentNotePair.noOfNotes+=pair.noOfNotes;

        }
    }
    //takes no of notes as input which is provides by the withdraw class itself
    public static void deductAmount(List<Pair> deductedAmount){
        int amount=0;
        //deducting no of notes from current notes
        for(Pair pair : deductedAmount){
            amount+=pair.note.value*pair.noOfNotes;
            currentNotes.get(pair.note.value).noOfNotes-=pair.noOfNotes;
            //if notes becomes zero then remove the corresponding object from the collection Of notes
            if(currentNotes.get(pair.note.value).noOfNotes==0){
                if(currentNotes.containsKey(pair.note.value)){
                    currentNotes.remove(currentNotes.get(pair.note.value));
                }
            }
        }
        totalBalance-=amount;
    }

}
