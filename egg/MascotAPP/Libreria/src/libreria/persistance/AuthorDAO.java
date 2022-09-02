
package libreria.persistance;

import java.util.List;
import libreria.entities.Author;

public class AuthorDAO extends DAO<Author> {

    @Override
    public void save(Author author) {
        super.save(author);
    }

    public Author searchAuthorForName(String name) throws Exception {
        try {
            connect();
            Author author = (Author) em.createQuery("SELECT a FROM Author a WHERE a.name like: name")
                    .setParameter("name", name)
                    .getSingleResult();
            disconnect();
            return author;

        } catch (Exception e) {
            System.out.println("no  author found");
            return null;

        }
    }
    
     public List<Author> listAllAuthors() {
        connect();
        List<Author> authors = em.createQuery("SELECT a FROM Author a")
                .getResultList();
        disconnect();
        return authors;

    }
    public Author searchAuthorForId(Integer id) throws Exception {
        try {
            connect();
            Author author = (Author) em.createQuery("SELECT a from Author a where a.id like: id")
                    .setParameter("id", id)
                    .getSingleResult();
            disconnect();
            return author;
        } catch (Exception e) {
            System.out.println(" author no found");
            return null;
        }

    }
    public void modifyAuthor(Author author)throws Exception{
        try{
            if (author == null){
                throw new Exception ("the modification failed");
                
            }
            super.edit(author);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
