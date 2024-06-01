import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class City {
    static Map<String,Brick> ownedBrick=new HashMap<>();  //storing all bricks that is owned in all cities
    Map<String,Wall> wallMap;
    Stack<Wall> wallStack;//stack for checking previous wall made no. of bricks
    String name; //name of the city

    City(){
        wallMap=new HashMap<>();
        wallStack=new Stack<>();
    }

    public void setCityName(String name){
        this.name=name;
    }
    public void addWall(String wallId){
        if(wallStack.isEmpty() || wallStack.peek().noOfBrick==90){
            Wall wall=new Wall(wallId);
            wallMap.put(wallId,wall);
            wallStack.push(wall);
        }
        else{
            System.out.println("Wall cannot be added as previous wall does not contain 90 bricks");
        }
    }
    public Wall getWall(String wallId){return wallMap.get(wallId);}
    //Only users can add bricks so defined inside it
    public void addBrick(Owner owner,String wallId,String brickId){
        Wall wall=getWall(wallId);
        if(wall.noOfBrick>=90){
            System.out.println("More walls cannot be added.");
            return;
        }
        wall.noOfBrick++;
        ownedBrick.put(brickId,new Brick(owner.id, brickId));
    }
    //only admin can edit brick
    public void editBrick(String brickId,String edited){
        Brick brick=getBrick(brickId);
        brick.animated+=edited;
    }
    // all can comment on provided brick by this
    public void addComment(String comment,String brickId){
        City.ownedBrick.get(brickId).addComment(comment);
    }
    public Brick getBrick(String brickId){
        return ownedBrick.get(brickId);
    }
    //For painting the brick
    public void animate(Owner owner,String paint,String brickId,String wallId){
        Wall wall=getWall(wallId);
        Brick brick=getBrick(brickId);
        //this condition will make sure that after painting 10 bricks
        //the other bricks when painted becomes invisible therefore we cannot count their dedication
        if(wall.flagged<=10){
            brick.isVisibleAnimation=true;
        }
        //only owned can edit his brick so checking that condition
        if(!ownedBrick.containsKey(brick.brickID)){
            System.out.println("You cannot edit this brick.");
            return;
        }
        //only owner can edit
        if(brick.ownerId.equalsIgnoreCase(owner.id)){
            brick.animated=paint;
            wall.flagged++;
            System.out.println("Paint successful.");
        }
        else {
            System.out.println("You cannot paint this brick.");
        }
    }

}
class Wall{
    String wallId;
    int noOfBrick;
    int flagged; //its keeps increasing when someone paints any brick in one wall
    Wall(String id){
        wallId=id;
    }

}
class Brick{
    String brickID;
    String ownerId;
    String comment;
    String animated;   //its is the animation done by the owner
    boolean isVisibleAnimation;
    Brick(String ownerId,String brickID){
        this.ownerId=ownerId;
        comment="";
        this.brickID=brickID;
        animated="";
    }
    public void addComment(String edited){
        this.comment=edited;
    }
}