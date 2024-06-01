import java.util.ArrayList;
//singleton
public class ChatService {
    static ChatService chatService=null;
    private ChatService(){}

    public static ChatService getInstance(){
        if(chatService==null){
            chatService=new ChatService();
        }
        return chatService;
    }

    public void sendChat(Account sender,Account receiver , Media media){
        if(!receiver.whatsappContact.containsKey(sender.phoneNo)){
            receiver.whatsappContact.put(sender.phoneNo,sender);
        }
        media.owner=sender.name;
        if((sender.chatBox.isEmpty() && receiver.chatBox.isEmpty()) || (!sender.chatBox.containsKey(receiver) && !receiver.chatBox.containsKey(sender))){
            ArrayList<Media> mediaArr=new ArrayList<>();
            mediaArr.add(media);
            sender.chatBox.put(receiver,mediaArr);
            receiver.chatBox.put(sender,mediaArr);
        }
        else if(sender.chatBox.isEmpty() || !sender.chatBox.containsKey(receiver)){
            ArrayList<Media> mediaArr=new ArrayList<>();
            mediaArr.add(media);
            sender.chatBox.put(receiver,mediaArr);
            receiver.chatBox.get(sender).add(media);
        }
        else if(receiver.chatBox.isEmpty() || !receiver.chatBox.containsKey(sender) ){
            ArrayList<Media> mediaArr=new ArrayList<>();
            mediaArr.add(media);
            receiver.chatBox.put(sender,mediaArr);
            sender.chatBox.get(receiver).add(media);

        }
        else{
            //once only as the object of arraylist is same in both the chat-box. So adding in one of the arraylist is same
            sender.chatBox.get(receiver).add(media);
        }
    }
    public void seeChat(Account observer,Account selected){
        if(selected.chatBox.isEmpty()){
            System.out.println("Nothing to show here");
            return;
        }
        ArrayList<Media> chatMedia =selected.chatBox.get(observer);
        System.out.println("CHAT WITH "+selected.name);
        if(chatMedia.size()==0){
            System.out.println("No chats to show here");
            return;
        }
        for(Media media : chatMedia){
            System.out.println("Sent by-->"+media.owner+"   chat-->"+media.content  +  "     chat-form-->"+media.type);
        }
    }
}
