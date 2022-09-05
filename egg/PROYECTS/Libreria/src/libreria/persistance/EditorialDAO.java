package libreria.persistance;

import java.util.List;
import libreria.entities.Editorial;

public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void save(Editorial editorial) {
        super.save(editorial);
    }

    public List<Editorial> listAll() {
        connect();
        List<Editorial> editorials = em.createQuery("SELECT e FROM Editorial e")
                .getResultList();
        disconnect();
        return editorials;

    }

    public Editorial searchEditorialForName(String name) throws Exception {
        try {

            connect();
            Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.name LIKE :name")
                    .setParameter("name", name)
                    .getSingleResult();
            disconnect();
            return editorial;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Editorial searchEditorialForId(Integer id) {

        connect();
        Editorial editorial = (Editorial) em.createQuery("SELECT e from Editorial e where e.id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();
        disconnect();
        return editorial;

    }

    public void modifyEditorial(Editorial editorial) {

        super.edit(editorial);

    }

}
