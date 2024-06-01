import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Account {

    static Map<Long,Account> allWhatsappAccounts=new HashMap<>();
    long phoneNo;   //always unique for every account
    String name;
    Media status;
    String password="";
    Map<Long,Account> whatsappContact=new HashMap<>();
    Map<Account,ArrayList<Media>> chatBox=new HashMap<>();

    Account(long phoneNo,String name){
        this.phoneNo=phoneNo;
        this.name=name;
    }

    void setPassword(String password){
        this.password=password;
    }

}
