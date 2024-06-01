import java.util.HashMap;
import java.util.Map;

public class RegisterPortal {

    static Map<String,Member> allMember=new HashMap<>(); //barcode as key
    static Map<String,Librarian> allLibranian=new HashMap<>(); //barcode as key

    public void addMember(String name,String id,String barCode){
        if(!allMember.isEmpty()){
            if(allMember.containsKey(barCode)){
                System.out.println("User already exist");
            }
        }
        allMember.put(barCode,new Member(name,id,barCode));
    }
    public void addLibrarian(String name,String id,String barCode,String password){
        if(Librarian.password.compareTo(password)!=0){
            System.out.println("Wrong password ! you cannot be librarian!");
            return;
        }
        if(!allLibranian.isEmpty()){
            if (allLibranian.containsKey(barCode)){
                System.out.println("User already exists");
            }
        }
        allLibranian.put(barCode,new Librarian(name,id,barCode));
        allMember.put(barCode,new Member(name,id,barCode));//as the librarian is also the user
    }

}
