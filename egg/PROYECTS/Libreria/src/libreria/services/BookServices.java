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

    public Book createBook(Long isbn, String title, Integer releaseYear, Integer copies, Author authorName, Editorial editorialId) throws Exception {
            
        try {
              
     
            if (authorName == null) {
                throw new Exception("that author does not exist");

            }
               
            if (editorialId == null) {
                throw new Exception("that publisher does not exist");
            }

             Book book = new Book();
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setReleaseYear(releaseYear);
            book.setCopies(copies);
            book.setAuthor(authorName);
            book.setEditorial(editorialId);
            book.setEnable(Boolean.TRUE);
            dao.save(book);
            System.out.println("the book was created successfully");
            System.out.println(book.toString());
            return book;
        } catch (Exception e) {
            System.out.println("An error occurred in the creation of the book");

            return null;

        }

    }

    public Book searchBookForISBN(Long isbn) throws Exception {
        try {
            if (isbn <= 0 || isbn == null) {
                throw new Exception("you must enter a valid ISBN");
            }
            Book book = dao.searchBookByISBN(isbn);
            if (book == null) {
                throw new Exception("the searched isbn is not found in the database");
            }
            System.out.println("the book you are looking for is " + book);
            return book;
        } catch (Exception e) {
            throw e;
        }

    }

    public Book searchBookForTitle(String title) throws Exception {
        try {
            if (title == null) {
                throw new Exception("you must enter a name");
            }
            Book booktitle = dao.searchBookByTitle(title);
            if (booktitle == null) {
                throw new Exception("the searched book is not found in the database");
            }
            return booktitle;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Book> searchBooksByAuthor(String authorName) {
        try {
            if (authorName == null) {
                throw new Exception(" you must enter the author name");
            }

            List<Book> book = dao.searchBooksByAuthor(authorName);
            if (book == null) {
                throw new Exception("there are no books by that author");
            }

            System.out.println(book);

            return book;

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;

        }
    }

    public List<Book> searchBooksByEditorial(String editorial) {
        try {
            if (editorial == null) {
                throw new Exception(" you must enter the editorial name");
            }

            List<Book> book = dao.searchBooksByEditorial(editorial);
            if (book == null) {
                throw new Exception("No books from that publisher were found");
            }

            System.out.println(book);

            return book;

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;

        }
    }

    public void bookToDelete(Long isbn) throws Exception {
        try {
            if (isbn <= 0 || isbn == null) {
                throw new Exception("you must enter a valid ISBN");
            }

            dao.deleteBookByISBN(isbn);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
