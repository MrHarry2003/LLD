import java.util.HashMap;
import java.util.Map;

//Currency Note-System -> applied singleton as only one Note-system for one ATM :
public class Note{

    int value;
    //Integer key type store value of note to access them
    static Map<Integer,Note> notes=new HashMap();
    static Note noteSystem=null;

    private Note(){}

    public static Note getInstance(){
        if(noteSystem==null){
            noteSystem=new Note();
        }
        return noteSystem;
    }
    //adding new note if comes in future
    public void addNote(int value){
        Note note=new Note();
        note.value=value;
        notes.put(value,note);
    }
    //updating value of current note if such situation comes
    public void updateNoteValue(int value,int newValue){
        if(notes.containsKey(value)){
            notes.get(value).value=newValue;
        }
    }

}

//Pair here stores no of notes of every key object plus the object itself
class Pair{
    int noOfNotes;
    Note note;
    Pair(Note note){
        this.note=note;
        this.noOfNotes=1; //initialized as one first
    }
}