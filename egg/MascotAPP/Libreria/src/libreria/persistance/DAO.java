package libreria.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO<T> {

    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LibreriaPU");
    protected EntityManager em = EMF.createEntityManager();

    protected void connect() {
        if (em.isOpen()) {
            em = EMF.createEntityManager();
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

    public T delete(T object) throws Exception {
        try {

            connect();
            T object1 = em.merge(object);
            em.getTransaction().begin();
            em.remove(object1);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
            disconnect();
            throw new Exception("Entity of type " + object.getClass().getSimpleName() + "could not be deleted ");
        }
        return object;
    }
}
