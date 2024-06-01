public abstract class Media {
    String content;
    String type;
    String owner;
    Media(String content){
        this.content=content;
    }
}
class Text extends Media{
    Text(String content){
        super(content);
        this.type="text";
    }
}
class Audio extends Media{
    Audio(String content){
        super(content);
        this.type="audio";
    }
}
class Image extends Media{
    Image(String content){
        super(content);
        this.type="image";
    }
}
class Video extends Media{
    Video(String content){
        super(content);
        this.type="video";
    }
}
//using factory pattern here
class MediaFactory{
    public static Media getMedia(String type,String content){
        if(type.trim().contains("text")){
            return new Text(content);
        }
        else if(type.trim().contains("audio")){
            return new Audio(content);
        }
        else if(type.trim().contains("image")){
            return new Image(content);
        }
        else if(type.trim().contains("video")){
            return new Video(content);
        }else{
            System.out.println("Invalid!");
            return null;
        }
    }
}
