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
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e")
                .getResultList();
        disconnect();
        return editoriales;

    }

    public Editorial searchForName(String name) throws Exception {
        try {
            connect();
            Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.name like: name")
                    .setParameter("name", name)
                    .getSingleResult();
            disconnect();
            return editorial;

        } catch (Exception e) {
            System.out.println("no  publishers found");
            return null;

        }
    }

    public Editorial searchForId(Integer id) throws Exception {
        try {
            connect();
            Editorial editorial = (Editorial) em.createQuery("SELECT e from Editorial e where e.id like: id")
                    .setParameter("id", id)
                    .getSingleResult();
            disconnect();
            return editorial;
        } catch (Exception e) {
            System.out.println("no publishers found");
            return null;
        }

    }
    public void modifyEditorial(Editorial editorial)throws Exception{
        try{
            if (editorial == null){
                throw new Exception ("the modification failed");
                
            }
            super.edit(editorial);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
