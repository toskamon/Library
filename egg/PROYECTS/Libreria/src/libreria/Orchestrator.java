package libreria;

import java.util.Scanner;
import libreria.entities.Author;
import libreria.entities.Editorial;
import libreria.services.AuthorServices;
import libreria.services.BookServices;
import libreria.services.EditorialServices;

public class Orchestrator {

    public static final EditorialServices EDITORIAL_SERVICES = new EditorialServices();
    public static final BookServices BOOK_SERVICES = new BookServices();
    public static final AuthorServices AUTHOR_SERVICES = new AuthorServices();

    public static void mainMenu() throws Exception {
        Scanner leer = new Scanner(System.in);
        int Opcion;

        boolean EXIT = false;

        while (!EXIT) {

            System.out.println("WELCOME");
            System.out.println("Please,choose what action you want to perform");
            System.out.println("1. Author opcions.");
            System.out.println("2. Editorial opcions");
            System.out.println("3. Book opcions");
            System.out.println("4. EXIT");
            Opcion = leer.nextInt();
            switch (Opcion) {
                case 1:
                    authorOpcions();
                    break;
                case 2:
                    editorialOpcions();
                    break;
                case 3:
                    bookOpcions();
                    break;
                case 4:
                     System.out.println("THANK YOU FOR USING OUR PROGRAM");
                    System.exit(0);
                   
                    break;

            }
        }

    }

    public static void authorOpcions() throws Exception {

        Scanner read = new Scanner(System.in);
        Scanner read1 = new Scanner(System.in);
        int Opcion ;
        int Opcion1;

        boolean EXIT = false;

        while (!EXIT) {

            System.out.println("WELCOME To Author opcions");
            System.out.println("Please,choose what action you want to perform");
            System.out.println("1. Create an author ");
            System.out.println("2. Search for an author by Name ");
            System.out.println("3. Search for an author by ID ");
            System.out.println("4. List all authors in the Database");
            System.out.println("5. Modify the author's Name");
            System.out.println("6. Enable an autor");
            System.out.println("7. Disable an autor");
            System.out.println("8. go back to main menu");

            Opcion = read.nextInt();

            switch (Opcion) {
                case 1:
                    System.out.println(" Enter the name of the author to create ");
                    String name = read1.nextLine();
                    AUTHOR_SERVICES.createAuthor(name);
                    break;
                case 2:
                    System.out.println("Enter the name of the author to search");
                    String name2 = read1.nextLine();
                    AUTHOR_SERVICES.searchAuthorForName(name2);

                    break;
                case 3:
                    System.out.println("Enter the ID of the author to search");
                    Opcion1 = read1.nextInt();
                    AUTHOR_SERVICES.searchAuthorForId(Opcion1);
                    break;
                case 4:
                    AUTHOR_SERVICES.listAuthors();
                    break;

                case 5:
                    AUTHOR_SERVICES.modifyAuthorName();
                    break;
                case 6:
                    AUTHOR_SERVICES.authorEnable();
                    break;

                case 7:
                    AUTHOR_SERVICES.authorDisable();
                    break;

                case 8:
                    EXIT = true;
                    mainMenu();
                     break;
            }
        }
    }

    public static void editorialOpcions() throws Exception {
        Scanner read = new Scanner(System.in);
        Scanner read1 = new Scanner(System.in);
        int Opcion;
        int Opcion1;

        boolean EXIT = false;

        while (!EXIT) {

            System.out.println("WELCOME To Editorial opcions");
            System.out.println("Please,choose what action you want to perform");
            System.out.println("1. Create an Editorial ");
            System.out.println("2. Search for an Editorial by Name ");
            System.out.println("3. Search for an Editorial by ID ");
            System.out.println("4. List all publishers in the Database");
            System.out.println("5. change the name of the publisher");
            System.out.println("6. Enable a publisher");
            System.out.println("7. Disable a publisher");
            System.out.println("8. go back to main menu");

            Opcion = read.nextInt();

            switch (Opcion) {
                case 1:
                    System.out.println(" Enter the name of the publisher to create ");
                    String name = read1.nextLine();
                    EDITORIAL_SERVICES.createEditorial(name);
                    break;
                case 2:
                    System.out.println("Enter the name of the publisher to search");
                    String name2 = read1.nextLine();
                    EDITORIAL_SERVICES.searchEditorialForName(name2);

                    break;
                case 3:
                    System.out.println("Enter the ID of the publisher to search");
                    Opcion1 = read1.nextInt();
                    EDITORIAL_SERVICES.searchEditorialForId(Opcion1);
                    break;
                case 4:
                    EDITORIAL_SERVICES.listEditorials();
                    break;

                case 5:
                    EDITORIAL_SERVICES.modifyEditorialName();
                    break;
                case 6:
                    EDITORIAL_SERVICES.editorialEnable();
                    break;

                case 7:
                    EDITORIAL_SERVICES.editorialDisable();
                    break;

                case 8:
                    EXIT = true;
                    mainMenu();
                    break;
            }
        }
    }

    public static void bookOpcions() throws Exception {

        Scanner read = new Scanner(System.in);
        Scanner read1 = new Scanner(System.in);
        int Opcion;
        Long isbn;
        Integer releaseYear;
        Integer copies;
        Integer editorialId;
        String title;
        String authorname;

        boolean EXIT = false;

        while (!EXIT) {

            System.out.println("WELCOME To Book opcions");
            System.out.println("Please,choose what action you want to perform");
            System.out.println("1. Create a Book ");
            System.out.println("2. Search for a Book by ISBN ");
            System.out.println("3. Search for a book by title ");
            System.out.println("4. List books by Author");
            System.out.println("5. List books by Editorial");
            System.out.println("6. Delete a book");
            System.out.println("7. go back to main menu");

            Opcion = read.nextInt();

            switch (Opcion) {
                case 1:
                    System.out.println(" Enter the isbn of the book ");
                    isbn = read.nextLong();
                    System.out.println("Enter the title of the book ");
                    title = read1.nextLine();
                    System.out.println("Enter the realese year of the book ");
                    releaseYear = read.nextInt();
                    System.out.println("Enter how many copies the book has ");
                    copies = read.nextInt();
                    System.out.println("Enter the name of the author ");
                    authorname = read1.nextLine();
                     Author author = AUTHOR_SERVICES.searchAuthorForName(authorname);
                    System.out.println("Enter the publisher id ");
                    editorialId = read.nextInt();
                    Editorial editorial = EDITORIAL_SERVICES.searchEditorialForId(editorialId);
                    BOOK_SERVICES.createBook(isbn, title, releaseYear, copies, author, editorial);

                    break;
                case 2:
                    System.out.println("Enter the isbn of the Book to search ");
                    Long I = read.nextLong();
                    BOOK_SERVICES.searchBookForISBN(I);

                    break;
                case 3:
                    System.out.println("Enter the title of the Book to search ");
                    String title1 = read1.nextLine();
                    BOOK_SERVICES.searchBookForTitle(title1);
                    break;
                case 4:
                    System.out.println("Enter the name of the author of the book/books you want to search for ");
                    String nameAuthor = read1.nextLine();
                    BOOK_SERVICES.searchBooksByAuthor(nameAuthor);
                    break;

                case 5:
                    System.out.println("Enter the name of the publisher of the book/books you want to search for ");
                    String editorialName = read1.nextLine();
                    BOOK_SERVICES.searchBooksByEditorial(editorialName);
                    break;
                case 6:
                    System.out.println("enter the isbn of the book you want to delete");
                    Long isbnBook = read.nextLong();
                    BOOK_SERVICES.bookToDelete(isbnBook);

                case 7:

                    EXIT = true;
                    mainMenu();
                    break;

            }
        }
    }
}

