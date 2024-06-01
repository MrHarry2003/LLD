import java.util.HashMap;
import java.util.Map;
public class UserManagement {
    static Map<String,Owner> ownerMap;
    UserManagement(){}
    //creating owners in system
    public void createOwner(String name, String gender, String id) {new Owner(id, gender, name);}
}

class User{
    String name;
    String gender;
    String id;
    User(String id,String gender){
        this.gender=gender;
        this.id=id;
    }
}

class Owner extends User{
    //no. of dedication of wall done by other owners for him
    int noOfDedications;
    //storing as id to owner because we can have same owner name but ids will be always diff
    static Map<String,Owner> allOwner=new HashMap<>();

    Owner(String id,String gender,String name){
        super(id,gender);
        this.name=name;
        //at the maintaining all owners list for data manipulation
        allOwner.put(id,this);
    }
}

class Admin extends User{
    static String password="admin123";
    static Admin admin=null;
    private Admin(String id,String gender){
        super(id,gender);
    }
    //only admins with correct pass can initialize this
    public static Admin getAdmin(String pass,String id,String gender){
        if(Admin.password.equalsIgnoreCase(pass)){
            admin=new  Admin(id,gender);
        }return admin;
    }
}