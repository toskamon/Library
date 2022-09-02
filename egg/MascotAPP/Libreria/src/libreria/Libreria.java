package libreria;

import libreria.services.BookServices;
import libreria.services.EditorialServices;

public class Libreria {

    public static void main(String[] args) {
        EditorialServices E1 = new EditorialServices();
        BookServices b1 = new BookServices();
        try{
          E1.listEditorials();
    }catch(Exception e){
            System.out.println(e.getMessage());
            
    }

}
    
    
}
