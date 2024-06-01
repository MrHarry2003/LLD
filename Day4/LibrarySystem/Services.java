//applying singleton as only one services for all the system
public class Services {

    static int rate=1; //assuming rate as $1 per day and one day is one second here
    Services(){}

    //personalized function to compare two strings irrespective of white spaces and cases
    public static boolean compareString(String str1,String str2){
        // Call the replaceAll() method --> using this to remove whitespaces in both the strings
        str1 = str1.replaceAll("\\s", "");
        str2 = str2.replaceAll("\\s", "");

        // Convert to lowercase
        // using toLowerCase function
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Comparing both using inbuilt function
        int x = str1.compareTo(str2);

        // if strings are equal,
        // return true otherwise false
        return x == 0;
    }
    //if duration becomes more than 10 days then fine will be calculated by rate initialized and librarian change the rate
    public static String amount(Book book){
        int duration=(int)(book.checkoutTime-book.issueTime)/1000;  //in seconds
        if(duration>10){
            int amount=duration*rate;
            return String.valueOf(amount);
        }
        return "No payment needed!";
    }
}
class BookServices extends Services{
    //display location of given book
    public static void displayLocationBook(Book book){
        System.out.println();
        System.out.print("Shelf id --> "+book.shelfId+", ");
        System.out.print("Row id --> "+book.rowId+", ");
        System.out.print("Spot id --> "+book.spotId+", ");
        System.out.print("Book id -->"+book.id);
        System.out.println();
    }
    //display all information of asked book
    public static void displayBook(Book book){
        System.out.println();
        System.out.print("Book title --> "+book.title+", ");
        System.out.print("Book author --> "+book.author+", ");
        System.out.print("Book publication year --> "+book.publicationYear+", ");
        System.out.print("Book issued --> "+book.isIssued+", ");
        System.out.print("Book reserved --> "+book.isReserved);
        System.out.println();
    }
    //displaying all the books
    public void displayAllBooks(){
        for(int i=0;i<Book.allBookId.size();i++){
            Book book=Book.allBookId.get(i);
            BookServices.displayBook(book);
        }
    }
    //user can search by any field like title , author , year so print them all those book with matching field
    public void searchBook(String field){
        for(int i=0;i<Book.allBookId.size();i++){
            Book book=Book.allBookId.get(i);
            System.out.println();
            //comparing with author , title and publication year
            if(Services.compareString(field,book.author) || Services.compareString(field,book.publicationYear) || Services.compareString(field,book.title)){
                BookServices.displayBook(book);
                BookServices.displayLocationBook(book);
            }
        }
    }
    //for issuing a book and date should be entered in DD/MM/YYYY form
    public void issueBook(String bookId,Member owner){
        if(owner.bookIssued==5){
            System.out.println("Limit reached for issuing book.");
            return;
        }
        for(Book book : Book.allBookId){
            if(book.id.compareTo(bookId)==0 && !book.isIssued){
                //checking if the book is reserved and the possible owner is not the reserver
                if(book.reservedOwner.compareTo(owner.name)!=0 && book.isReserved){
                    System.out.println("Sorry this book is reserved!");
                    return;
                }
                //issuing the book
                System.out.println("Successfully Issued Book!");
                book.isIssued=true;
                book.isReserved=false;
                owner.bookIssued++;
                book.owner=owner.name;
                book.issueTime=System.currentTimeMillis();
                System.out.println("Success");
                return;
            }
        }
        System.out.print("Book not available!");
    }
    //for reserving a book
    public void reserveBook(String bookId, Member reserver){
        for(Book book : Book.allBookId){
            if(book.id.compareTo(bookId)==0 && !book.isReserved){
                System.out.println("Successfully Reserved Book!");
                book.reservedOwner=reserver.name;
                book.isReserved=true;
                System.out.println("Success");
                return;
            }
        }
        System.out.print("Book not available!");
    }
    //returning the issued book
    public void returnBook(String bookId,Member member){
        for(Book book : Book.allBookId){
            if(book.id.compareTo(bookId)==0 && book.isIssued){
                book.checkoutTime=System.currentTimeMillis();
                System.out.println("Book returned. Your fine ---> "+Services.amount(book));
                member.bookIssued--;
                book.isIssued=false;
                book.issueTime=0;
                book.checkoutTime=0;
                System.out.println("Success");
                return;
            }
        }
        System.out.print("Given book was not issued!");
    }
    //librarian can add the book
    public void addBook(String shelfId,String rowId,String spotId,String authorName,String bookTitle,String publicationYear,String bookId,String barcode){
        BookManagement.getInstance().addNewBook(shelfId,rowId,spotId,authorName,bookTitle,publicationYear,bookId,barcode);
        System.out.println("Success");
    }
    //librarian can remove any given book
    public void removeBook(String bookId){
        if(Book.allBookId.isEmpty()){
            System.out.println("No books in library");
        }
        for(Book book:Book.allBookId){
            if(book.id.compareTo(bookId)==0){
                Book.allBookId.remove(book);
                System.out.println("Success");
                return;
            }
        }
        System.out.print("No such book found!");
    }

}
class UserServices extends Services{
    //librarian can users
    public void addMember(String name,String id,String barCode){
        if(!RegisterPortal.allMember.containsKey(barCode)){
            RegisterPortal.allMember.put(barCode,new Member(name,id,barCode));
            System.out.println("Success");
        }
    }
    //librarian can remove users
    public void removeMember(String barCode){
        if(RegisterPortal.allMember.isEmpty()){
            System.out.println("No member here.");
        }
        if(RegisterPortal.allMember.containsKey(barCode)){
            RegisterPortal.allMember.remove(barCode);
            System.out.println("Success");
        }
    }
    //Defining some Librarian special functions(only librarian can use)
    public void setRate(int newAmount){
        Services.rate=newAmount;
    }
    //displaying if a member has dues
    public void displayMember(String barcode){
        for(Member member : RegisterPortal.allMember.values()){
            if(member.barCode.compareTo(barcode)==0){
                System.out.println(member.name+" has "+member.bookIssued+" issued books");
                return;
            }
        }
    }
    public void displayAllMember(){
        for(Member member:RegisterPortal.allMember.values()){
            System.out.println(member.name+" has "+member.bookIssued+" books issued");
        }
    }
}
