public class StatusService {
    public void addStatus(Account account,Media media){
        account.status=media;
    }
    public void removeStatus(Account account){
        account.status=null;
    }
    public void seeStatus(Account owner,Account selected){
        if(selected.status==null){
            System.out.println("No status here");
        }
        System.out.println("STATUS OF "+selected.name);
        System.out.println(selected.status.content+" , type of content -->"+selected.status.type);
    }
}
