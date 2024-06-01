//Applied singleton
public class UserManagement {

    RegisterPortal registerPortal;
    UserServices userServices=new UserServices();

    static UserManagement userManagement=null;
    private UserManagement(){
        registerPortal=new RegisterPortal();
    }
    public static UserManagement getInstance(){
        if(userManagement==null){
            userManagement=new UserManagement();
        }
        return userManagement;
    }

}
