import java.util.Scanner;
//applying singleton as only one whatsapp account for one mobile
public class WhatsApp {
    //whatsapp service includes --> chat service ,contactservices,status service and some functions like delete and change password
    WhatsAppService whatsAppService=WhatsAppService.getInstance();
    RegisterationPortal registerationPortal;

    static WhatsApp whatsApp=null;
    Scanner sc=new Scanner(System.in);

    private WhatsApp(){
        registerationPortal=new RegisterationPortal();
    }
    public static WhatsApp getInstance(){
        if(whatsApp==null){
            whatsApp=new WhatsApp();
        }
        return whatsApp;
    }
    //whatsappServices defined functions
    public void seeContacts(Account owner){
        whatsAppService.contactServices.seeContact(owner);
    }
    public void searchContact(Account owner,String nameToBeSearched){
        whatsAppService.contactServices.searchContact(owner,nameToBeSearched);
    }
    public void sendChat(Account owner,Account receiver,Media chat){
        whatsAppService.chatService.sendChat(owner,receiver,chat);
    }
    public void seeChat(Account account,Account observed){
        whatsAppService.chatService.seeChat(observed,observed);
    }
    public void postStatus(Account owner,Media status){
        whatsAppService.statusService.addStatus(owner,status);
    }
    public void seeStatus(Account owner,Account selected){
        whatsAppService.statusService.seeStatus(owner,selected);
    }
    public void removeStatus(Account owner){
        whatsAppService.statusService.removeStatus(owner);
    }
    public void addContact(Account owner,long phoneNo){
        whatsAppService.contactServices.addContact(owner,phoneNo);
    }

   //Registration Services
    public void registerAccount(long phoneNo,String name,String pass){
        registerationPortal.registerAccount(name,phoneNo,pass);
    }

}
