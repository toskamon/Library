package libreria.persistance;

import java.util.List;
import libreria.entities.Author;

public class AuthorDAO extends DAO<Author> {

    @Override
    public void save(Author author) {
        super.save(author);
    }

    public Author searchAuthorForName(String name) throws Exception {
          try{
        connect();
        Author author = (Author) em.createQuery("SELECT a FROM Author a WHERE a.name LIKE :name")
                .setParameter("name", name).getSingleResult();
        disconnect();
        return author;
          }catch (Exception e){
              System.out.println(e.toString());
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

    public Author searchAuthorForId(Integer id) {

        connect();
        Author author = (Author) em.createQuery("SELECT a from Author a where a.id LIKE :id")
                .setParameter("id", id).getSingleResult();

        disconnect();
        return author;

    }

    public void modifyAuthor(Author author) {

        super.edit(author);

    }
}
