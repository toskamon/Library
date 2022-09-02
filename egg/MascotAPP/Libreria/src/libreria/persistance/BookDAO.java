package libreria.persistance;

import libreria.entities.Book;

public class BookDAO extends DAO<Book> {

    //hacemos un override de la clase padre guardar
    @Override
    public void save(Book book) {
        super.save(book);
    }

    public Book searchForISBN(Long isbn) {
        connect();
        Book book = (Book) em.createQuery("SELECT b from Book b WHERE b.isbn like: isbn")
                .setParameter("isbn", isbn).getSingleResult();
         disconnect();
         return book;
    }
    
    }
