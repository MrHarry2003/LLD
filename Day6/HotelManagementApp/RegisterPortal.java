import java.util.HashMap;
import java.util.Map;

public class RegisterPortal {
    //for records --> storing all the registrations in maps
    static Map<String,NormalUser> allNormalUser=new HashMap<>();
    static Map<String,HotelAgent> allHotelAgent=new HashMap<>();

    public void registerNormalUser(String name,String id){
        NormalUser user=new NormalUser();
        user.id=id;
        user.name=name;
        allNormalUser.put(id,user);
    }
    public void registerHotelAgent(String name,String agentId){
        HotelAgent agent=new HotelAgent();
        agent.name=name;
        agent.agentId=agentId;
        allHotelAgent.put(agentId,agent);
    }

}
