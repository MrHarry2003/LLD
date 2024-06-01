//applying singleton here
public class WhatsAppService {

    ChatService chatService=ChatService.getInstance();
    StatusService statusService;
    ContactServices contactServices;

    static WhatsAppService whatsAppService=null;
    private  WhatsAppService(){
        statusService=new StatusService();
        contactServices=new ContactServices();
    }
    public static  WhatsAppService getInstance(){
        if(whatsAppService==null){
            whatsAppService=new WhatsAppService();
        }
        return  whatsAppService;
    }
}
class ContactServices{
    public void addContact(Account owner,long phoneNo){
        //will check if given contact is a whatsapp account if so then we will add to the owner's contact
        if(!Account.allWhatsappAccounts.isEmpty()){
            if(Account.allWhatsappAccounts.containsKey(phoneNo)){
                owner.whatsappContact.put(phoneNo,Account.allWhatsappAccounts.get(phoneNo));
                System.out.println("Contact-added");
                return;
            }
        }
        System.out.println("User is not on whatsapp");
    }
    public void seeContact(Account owner){
        System.out.println("Your contact List :- ");
        if(owner.whatsappContact.isEmpty()){
            System.out.println("No contacts to show");
        }
        for(Account account:owner.whatsappContact.values()){
            System.out.println(account.name);
        }
    }
    public void searchContact(Account owner,String nameToBeSearched){
        if(owner.whatsappContact.isEmpty()){
            System.out.println("No contacts to show");
        }
        for(Account account:owner.whatsappContact.values()){
            if(nameToBeSearched.trim().equalsIgnoreCase(account.name)){
                System.out.println(account.name+" , Phone no --> "+account.phoneNo);
            }
        }
    }
}
