import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Book {

    static List<Book> allBookId=new ArrayList<>();//all books when created will be added to this
    //this map will help us in the different queries for book(like serching)
    boolean isIssued;
    boolean isReserved;
    //when both isIssued and isReserved remains false that means it is present on its book spot
    String owner;
    String reservedOwner;
    String author;
    String publicationYear;
    String title;
    String barCode;  //unique
    String id;       //unique
    Book(String authorName,String bookTitle,String publicationYear,String bookId,String barcode){
        this.author=authorName;
        this.id=bookId;
        this.title=bookTitle;
        this.barCode=barcode;
        this.publicationYear=publicationYear;
        reservedOwner="No one";
        owner="No one";
    }
    //these 3 will give us answer for the location queris
    String shelfId;
    String rowId;
    String spotId;
    //initially as 0
    long issueTime=0;
    long checkoutTime=0;
}
