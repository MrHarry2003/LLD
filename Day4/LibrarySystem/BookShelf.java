import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
//bookshelf has bookrows and bookrows has book spots and each book spot can have a book
public class BookShelf {
    String shelfId;  //unique
    Map<String,BookShelfRow> rowMap;

    BookShelf(String shelfId){
        rowMap=new HashMap<>();
        this.shelfId=shelfId;
    }

    public void addBookRow(String rowId){
        rowMap.put(rowId,new BookShelfRow(rowId));
    }

}
class BookShelfRow{
    String rowId;//unique
    Map<String,BookSpot> spotMap;  //storing bookspots

    BookShelfRow(String id){
        this.rowId=id;
        this.spotMap=new HashMap<>();
    }

    //for borrowing a book from the shelf
    public void addBookSpot(String spotId){
        spotMap.put(spotId,new BookSpot(spotId));
    }

}
class BookSpot{
    String spotId; //unique
    Map<String,Book> bookMap=new HashMap<>(); //this is used to give access location

    BookSpot(String spotId){
        this.spotId=spotId;
    }

    void addNewBook(Book book,String spotId){
        bookMap.put(book.id,book);
        Book.allBookId.add(book);
    }

}
