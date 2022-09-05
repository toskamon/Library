package libreria.services;

import java.util.List;
import java.util.Scanner;
import libreria.entities.Author;
import libreria.persistance.AuthorDAO;

public class AuthorServices {

    private final AuthorDAO dao;
    private final Scanner read;

    public AuthorServices() {
        this.dao = new AuthorDAO();
        this.read = new Scanner(System.in).useDelimiter("\n");
    }

    public Author createAuthor(String name) throws Exception {
        Author author = new Author();

        try {
            if (dao.searchAuthorForName(name) != null) {
                throw new Exception("there is already a author with the name " + name);
            } else {
                author.setName(name);
                author.setEnable(Boolean.TRUE);
                dao.save(author);
                System.out.println("the following author is created " + author);
                return author;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Author> listAuthors() throws Exception {
        try {

            List<Author> list = dao.listAllAuthors();
            if (list.isEmpty()) {
                throw new Exception("no Authors to list");
            }

            System.out.println("this is the list of authors " + list);

            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Author searchAuthorForId(Integer id) throws Exception {
        try {
            if (id <= 0 || id == null) {
                throw new Exception("you must enter a valid id");

            }
            Author author = dao.searchAuthorForId(id);
            if (author == null) {
                throw new Exception("the searched id is not found in the database");
            }
            System.out.println(author.toString());
            return author;
        } catch (Exception e) {
            throw e;
        }

    }

    public Author searchAuthorForName(String name) throws Exception {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("you must indicate a name");

            }
            Author author = dao.searchAuthorForName(name);

            if (author == null) {
                throw new Exception("the searched name is not found in the database");
            }
            System.out.println(author);
            return author;

        } catch (Exception e) {
            throw e;
        }
    }

    public void modifyAuthorName() throws Exception {

        try {
            System.out.println("enter the id of the Author you want to modify ");
            Author author = searchAuthorForId(read.nextInt());

            System.out.println("enter the new author name");
            String name = read.next();
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("you must indicate a name");

            }
            author.setName(name);
            dao.modifyAuthor(author);
            System.out.println("successfully changed the name of the author to" + name);

        } catch (Exception e) {
            throw e;
        }

    }

    public void authorEnable() throws Exception {
        try {
            System.out.println("indicate the id of the Author you want to enable");
            Author author = searchAuthorForId(read.nextInt());
            if (author.getEnable() == true) {
                System.out.println("the Author " + author.getName() + " is already enable");
            } else {
                author.setEnable(Boolean.TRUE);
                dao.modifyAuthor(author);
                System.out.println("the Author" + author.getName() + " is enable");

            }
        } catch (Exception e) {
            System.out.println("the process failed");
            e.printStackTrace();
        }
    }

    public void authorDisable() throws Exception {
        try {
            System.out.println("indicate the id of the Author you want to disable");
            Author author = searchAuthorForId(read.nextInt());
            if (author.getEnable() == false) {
                System.out.println("the Author " + author.getName() + " is already disable");
            } else {
                author.setEnable(Boolean.FALSE);
                dao.modifyAuthor(author);
                System.out.println("the Author " + author.getName() + " is disable");

            }
        } catch (Exception e) {
            System.out.println("the process failed");
            e.printStackTrace();
        }
    }
}
