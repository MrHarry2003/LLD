public class UserManagement {

    RegisterPortal registerPortal=new RegisterPortal();
    //delete normal user
    public void deleteNormalUser(String normalUserId){
        RegisterPortal.allNormalUser.remove(normalUserId);
    }
    //delete Hotel Agent
    public void deleteHotelAgent(String agentId){
        RegisterPortal.allHotelAgent.remove(agentId);
    }
    //if user want to update own detail they can use below functions
    public void updateUserId(NormalUser user,String newId){
        user.id=newId;
    }
    public void updateUserName(NormalUser user,String newName){
        user.name=newName;
    }

}
