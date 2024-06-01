public class User {
    String name;
}
class NormalUser extends User{
    String id; //unique as username
}
class HotelAgent extends User{
    String agentId;
}
//only one administer so applied singleton
class Administer extends User{
    static String password="admin123";
    static Administer admin=null;
    private Administer(){}
    public static Administer getAdmin(){
        if(admin==null){
            admin=new Administer();
        }
        return admin;
    }
}
