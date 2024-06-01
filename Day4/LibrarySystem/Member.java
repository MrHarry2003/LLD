import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Member {

    String name;
    String id; //unique
    String barCode; //unique
    int bookIssued; //cannot issue more than 5 books

    Member(String name,String id,String barCode){
        this.barCode=barCode;
        this.id=id;
        this.name=name;
    }

}

class Librarian extends Member{

    static String password ="admin123";     //ask password before creation of librarian account on system
    Librarian(String name,String id,String barCode){
        super(name,id,barCode);
    }

}
