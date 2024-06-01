public class MessageSender {
    public void sendLateReturnMessage(){
        for(Book book:Book.allBookId){
            if(!book.isIssued){
                continue;
            }
            long today= System.currentTimeMillis();
            int duration = (int)(today-book.issueTime)/1000;
            if(duration>10){
                System.out.print("Message sent to "+book.owner+" for returning the book on time.");
                System.out.println();
            }
        }
    }
    public void sendAvailableIssuedBook(){
        for(Book book:Book.allBookId){
            if(!book.isIssued && book.isReserved){
                System.out.print("Message sent to "+book.reservedOwner+" for availability of issued book.");
                System.out.println();
            }
        }
    }
}
