public class CityPaintSystem{

    City city=new City();
    DedicationManagement dedicationManagement=new DedicationManagement();
    UserManagement userManagement=new UserManagement();


    static CityPaintSystem system=null;
    private CityPaintSystem(String cityName){
        city.setCityName(cityName);
    }

    public static CityPaintSystem getInstance(String cityName){
        if(system==null){ system=new CityPaintSystem(cityName); }
        return system;
    }
    //City functions
    public void addWall(Admin admin,String wallId){
        city.addWall(wallId);
    }
    public void addBrick(Owner owner,String wallId,String brickId){
        city.addBrick(owner,wallId,brickId);
    }
    public void editBrick(Owner owner,String brickId,String edited){
        //owners can only edit their own brick
        if(City.ownedBrick.get(brickId).ownerId.compareTo(owner.id)==0) {
            city.editBrick(brickId, edited);
        }
    }
    public void editBrick(Admin admin,String brickId,String edited){
        city.editBrick(brickId,edited);
    }
    public void addComment(Owner owner,String brickId,String comment){
        city.addComment(comment,brickId);
    }
    public void paintBrick(Owner owner,String wallId,String brickId,String animated){
        city.animate(owner,animated,brickId,wallId);
    }

    //User-Management services
    public void addOwner(String ownerId,String name,String gender){
        userManagement.createOwner(name,gender,ownerId);
    }
    //dedication management
    public void dedicateBrick(Owner owner,String toDedicatePersonId,String brickId){
        dedicationManagement.dedicateBrick(owner,toDedicatePersonId,brickId);
    }
    public void getHottestGuy(){
        String guy=dedicationManagement.getHottestGuy();
        System.out.println("Hottest Guy -->"+guy);
    }
    public void getHottestGirl(){
        String girl=dedicationManagement.getHottestGirl();
        System.out.println("Hottest Girl -->"+girl);
    }
    public void getNoDedicatedPerson(){
        dedicationManagement.getNoDedicationPerson();
    }
    
  }