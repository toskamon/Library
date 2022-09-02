package libreria.services;

import java.util.List;
import java.util.Scanner;

import libreria.entities.Editorial;

import libreria.persistance.EditorialDAO;

public class EditorialServices {

    private final EditorialDAO dao;
    private final Scanner read;

    public EditorialServices() {
        this.dao = new EditorialDAO();
        this.read = new Scanner(System.in).useDelimiter("\n");

    }

    public Editorial createEditorial(String name) throws Exception {
        Editorial editorial = new Editorial();

        try {
            if (dao.searchForName(name) != null) {
                throw new Exception("there is already a publisher with the name" + name);

            } else {
                editorial.setName(name);
                editorial.setEnable(Boolean.TRUE);
                dao.save(editorial);
                return editorial;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Editorial> listEditorials() throws Exception {
        try {
            if (dao.listAll().isEmpty()) {
                throw new Exception("no publishers to list");

            } else {
                return dao.listAll();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Editorial searchForId(Integer id) throws Exception {
        try {
            if (id <= 0 || id == null) {
                throw new Exception("you must enter a valid id");

            }
            Editorial editorial = dao.searchForId(id);
            if (editorial == null) {
                throw new Exception("the searched id is not found in the database");
            }
            return editorial;
        } catch (Exception e) {
            throw e;
        }

    }

    public void modifyName() throws Exception {

        try {
            System.out.println("enter the id of the publisher you want to modify ");
            Editorial editorial = searchForId(read.nextInt());

            System.out.println("enter the new publisher name");
            String name = read.next();
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("you must indicate a name");

            }
            editorial.setName(name);
            dao.modifyEditorial(editorial);
            System.out.println("successfully changed the name of the publisher to" + name);
            
        }catch (Exception e){
            throw e;
        }

    }
}
