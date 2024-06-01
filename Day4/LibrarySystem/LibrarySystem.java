import java.util.Scanner;

public class LibrarySystem {

    BookManagement bookManagement;
    UserManagement userManagement;
    MessageSender messageSender;  //automated message-sender for late submission

    static LibrarySystem librarySystem=null;
    private LibrarySystem(){
        bookManagement=BookManagement.getInstance();
        userManagement=UserManagement.getInstance();
        messageSender=new MessageSender();
    }
    public static LibrarySystem getInstance(){
        if(librarySystem==null){
            librarySystem=new LibrarySystem();
        }
        return librarySystem;
    }

    //book-management services
    public void displayAllBook(Member member){
        bookManagement.bookServices.displayAllBooks();
    }
    public void addBook(Librarian librarian,String shelfId,String rowId,String spotId,String bookName,String bookId,String author,String barcode,String publicationYear){
        bookManagement.bookServices.addBook(shelfId,rowId,spotId,author,bookName,publicationYear,bookId,barcode);
    }
    public void searchBook(Member member,String query){
        bookManagement.bookServices.searchBook(query);
    }
    public void issueBook(Member member,String bookId){
        bookManagement.bookServices.issueBook(bookId,member);
    }
    public void returnBook(Member member,String bookId){
        bookManagement.bookServices.returnBook(bookId,member);
    }
    public void reserveBook(Member member,String bookId){
        bookManagement.bookServices.reserveBook(bookId,member);
    }

    //User-Services
    public void addMember(Librarian librarian,String name,String id,String barCode){
        userManagement.userServices.addMember(name,id,barCode);
    }
    public void removeMember(Librarian librarian,String barCode){
        userManagement.userServices.removeMember(barCode);
    }
    public void setFineRate(Librarian librarian,int newRate){
        userManagement.userServices.setRate(newRate);
    }
    public void seeMemberDues(Librarian librarian,String barcode){
        userManagement.userServices.displayMember(barcode);
    }
    public void displayAllMembers(Librarian librarian){
        userManagement.userServices.displayAllMember();
    }
    public void removeBook(Librarian librarian,String bookId){
        bookManagement.bookServices.removeBook(bookId);
    }

    //Automatic message Sender
    public void sendLateMessage(){
        messageSender.sendLateReturnMessage();
    }
    public void sendAvailableReservedBook(){
        messageSender.sendAvailableIssuedBook();
    }

}
