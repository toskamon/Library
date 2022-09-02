package libreria.services;

import java.util.List;
import java.util.Scanner;
import libreria.entities.Author;
import libreria.entities.Book;
import libreria.entities.Editorial;
import libreria.persistance.BookDAO;


public class BookServices {

    private final BookDAO dao;
    private EditorialServices editorialServices;
    private final Scanner leer;
    private AuthorServices authorServices;
    public BookServices() {
        this.dao = new BookDAO();
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }

    public Book createBook(Long isbn, String title, Integer releaseYear, Integer copies, String author, Integer editorialId) throws Exception{
        
        try {
            
            if (author==null){
             throw new Exception("that author does not exist");
                
            }
           
            Editorial editorial = editorialServices.searchEditorialForId(editorialId);
             if (editorialId==null){
             throw new Exception("that publisher does not exist");
            }
            
            
            Book book = new Book();
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setReleaseYear(releaseYear);
            book.setCopies(copies);
            book.setAuthor(author);
            book.setEditorial(editorial);
            book.setEnable(Boolean.TRUE);
            dao.save(book);
            System.out.println(book.toString());
            return book;
        }catch (Exception e) {
            System.out.println("An error occurred in the creation of the book");
            System.out.println(e.toString());
            return null;
            
        }

    }
    public List<Book> listBooks(){
       return null; 
    }
    
}
