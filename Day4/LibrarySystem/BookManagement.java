import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
//Singleton
public class BookManagement {
    //bookManagement has book shelfs and its functions
    static Map<String,BookShelf> bookShelfMap=new HashMap<>();
    static BookManagement bookManagement=null;
    BookServices bookServices=new BookServices();

    private BookManagement(){}
    public static synchronized BookManagement getInstance(){
        if(bookManagement==null){
            bookManagement=new BookManagement();
        }
        return bookManagement;
    }
    //adding book shelf in the library
    public void addBookShelf(String shelfId){
        bookShelfMap.put(shelfId,new BookShelf(shelfId));
    }
    //we will add only if the given shelf exist
    public void addBookRow(String shelfId,String rowId){
        if(bookShelfMap.containsKey(shelfId)){
            bookShelfMap.get(shelfId).addBookRow(rowId);
        }
    }
    //we will add only when given row exist
    public void addBookSpot(String shelfId,String rowId,String spotId){
        if(bookShelfMap.containsKey(shelfId)){
            if(bookShelfMap.get(shelfId).rowMap.containsKey(rowId)){
                bookShelfMap.get(shelfId).rowMap.get(rowId).addBookSpot(spotId);
            }
        }
    }
    //we will add book only when such a spot exist in given location
    public void addNewBook(String shelfId,String rowId,String spotId,String authorName,String bookTitle,String publicationYear,String bookId,String barcode){
        //creating the book first then adding it to the location given
        Book book=new Book(authorName,bookTitle,publicationYear,bookId,barcode);
        book.shelfId=shelfId;
        book.rowId=rowId;
        book.spotId=spotId;

        if(bookShelfMap.containsKey(shelfId)){
            if(bookShelfMap.get(shelfId).rowMap.containsKey(rowId)){
                if(bookShelfMap.get(shelfId).rowMap.get(rowId).spotMap.containsKey(spotId)){
                    bookShelfMap.get(shelfId).rowMap.get(rowId).spotMap.get(spotId).addNewBook(book,spotId);
                }
            }
        }
    }
}
