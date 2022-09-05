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
            if (dao.searchEditorialForName(name) != null) {
                throw new Exception("there is already a publisher with the name" + name);

            } else {

                editorial.setName(name);
                editorial.setEnable(Boolean.TRUE);
                dao.save(editorial);
                System.out.println(editorial.toString());
                return editorial;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Editorial> listEditorials() throws Exception {

        try {
            List<Editorial> editorials = dao.listAll();

            System.out.println(editorials);

            return editorials;

        } catch (Exception e) {
            System.out.println("no publisher to list");
            return null;

        }
    }

    public Editorial searchEditorialForId(Integer id) throws Exception {
        try {
            if (id <= 0 || id == null) {
                throw new Exception("you must enter a valid id");

            }
            Editorial editorials = dao.searchEditorialForId(id);
            if (editorials == null) {
                throw new Exception("the searched id is not found in the database");
            }
            System.out.println(editorials.toString());
            return editorials;
        } catch (Exception e) {
            throw e;
        }

    }

    public Editorial searchEditorialForName(String name) throws Exception {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("you must indicate a name");

            }
            Editorial editorial = dao.searchEditorialForName(name);

            if (editorial == null) {
                throw new Exception("the searched name is not found in the database");
            }
            System.out.println(editorial.toString());
            return editorial;

        } catch (Exception e) {
            throw e;
        }
    }

    public void modifyEditorialName() throws Exception {

        try {
            System.out.println("enter the id of the publisher you want to modify ");
            Editorial editorial = searchEditorialForId(read.nextInt());

            System.out.println("enter the new publisher name");
            String name = read.next();
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("you must indicate a name");

            }
            editorial.setName(name);
            dao.modifyEditorial(editorial);
            System.out.println("successfully changed the name of the publisher to" + name);

        } catch (Exception e) {
            throw e;
        }

    }

    public void editorialEnable() throws Exception {
        try {
            System.out.println("indicate the id of the publisher you want to enable");
            Editorial editorial = searchEditorialForId(read.nextInt());
            if (editorial.getEnable() == true) {
                System.out.println("the editor " + editorial.getName() + " is already enable");
            } else {
                editorial.setEnable(Boolean.TRUE);
                dao.modifyEditorial(editorial);
                System.out.println("the editor " + editorial.getName() + " is enable");

            }
        } catch (Exception e) {
            System.out.println("the process failed");
            e.printStackTrace();
        }
    }

    public void editorialDisable() throws Exception {
        try {
            System.out.println("indicate the id of the publisher you want to disable");
            Editorial editorial = searchEditorialForId(read.nextInt());
            if (editorial.getEnable() == false) {
                System.out.println("the editor " + editorial.getName() + " is already disable");
            } else {
                editorial.setEnable(Boolean.FALSE);
                dao.modifyEditorial(editorial);
                System.out.println("the editor " + editorial.getName() + " is disable");

            }
        } catch (Exception e) {
            System.out.println("the process failed");
            e.printStackTrace();
        }
    }
}
