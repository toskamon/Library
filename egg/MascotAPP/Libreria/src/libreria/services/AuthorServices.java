
package libreria.services;

import java.util.List;
import libreria.entities.Author;
import libreria.persistance.AuthorDAO;


public class AuthorServices {
    private final AuthorDAO dao;

    public AuthorServices() {
        this.dao = new AuthorDAO();
    }
    
     public Author createAuthor(String name) throws Exception {
        Author author = new Author();

        try {
            if (dao.searchAuthorForName(name) != null) {
                throw new Exception("there is already a author with the name" + name);

            } else {
                author.setName(name);
                author.setEnable(Boolean.TRUE);
                dao.save(author);
                return author;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
       public List<Author> listAuthors() throws Exception {
        try {
            if (dao.listAllAuthors().isEmpty()) {
                throw new Exception("no auhthors to list");

            } else {
                return dao.listAllAuthors();
            }
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
            return author;
            
        }catch (Exception e){
            throw e;
        }
    }
    
}
