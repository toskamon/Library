package libreria.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO<T> {

    protected final EntityManagerFactory EMF = Persistence
            .createEntityManagerFactory("LibreriaPU");
    protected EntityManager em = EMF.createEntityManager();


    protected void connect() {
        if (!em.isOpen()) {
            this.em = EMF.createEntityManager();
        }
    }

    protected void disconnect() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected void save(T object) {
        connect();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        disconnect();
    }

    protected void edit(T object) {
        connect();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        disconnect();
    }

    protected void delete(T object) {
        try {
            connect();
            T objectToDelete = em.merge(object);
            em.getTransaction().begin();
            em.remove(objectToDelete);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            disconnect();
        }
    }

}
