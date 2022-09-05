package libreria.persistance;

import java.util.List;
import libreria.entities.Book;

public class BookDAO extends DAO<Book> {

    //hacemos un override de la clase padre guardar
    @Override
    public void save(Book book) {
        super.save(book);
    }
    @Override
    public void edit(Book book){
        super.edit(book);
        
    }
  

    public Book searchBookByISBN(Long isbn) {
        connect();
        Book book = (Book) em.createQuery("SELECT b from Book b WHERE b.isbn LIKE :isbn")
                .setParameter("isbn", isbn)
                .getSingleResult();
        disconnect();
        return book;
    }
    public Book searchBookByTitle(String title) {
        connect();
        Book book = (Book) em.createQuery(
                "SELECT b FROM Book b WHERE b.title LIKE :title")
                .setParameter("title", title)
                .getSingleResult();
        disconnect();
        return book;
    }

    public List<Book> searchBooksByEditorial(String editorialname) {
        connect();
        List<Book> books = em.createQuery("SELECT b FROM Book b WHERE b.editorial.name LIKE :name")
                .setParameter("name", editorialname)
                .getResultList();

        disconnect();
        return books;
    }
    public List<Book> searchBooksByAuthor(String authorName) {
        connect();
        List<Book> returnedBooks = em.createQuery(
                "SELECT b FROM Book b WHERE b.author.name LIKE :name")
                .setParameter("name", authorName)
                .getResultList();
        disconnect();
        
        return returnedBooks;
    }

    public List<Book> listAllBooks() {
        connect();
        List<Book> books = em.createQuery("SELECT b FROM Book b")
                .getResultList();
        disconnect();
        return books;
    }

    public void deleteBookByISBN(long isbn) throws Exception {
        try {
           Book book =searchBookByISBN(isbn);
            if (book == null) {
                throw new Exception("the searched isbn is not found in the database");
            }
         
            super.delete(book);
            System.out.println("the book was successfully deleted ");

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
    
    
    }

