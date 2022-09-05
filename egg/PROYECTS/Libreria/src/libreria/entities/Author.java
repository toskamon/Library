
package libreria.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="AUTHOR")
public class Author implements Serializable {

    @Id
    @Column(name= "Author_id")
    //Identity lo comienza por el numero 1 y va sumando cada vez que voy agregando una entidad en la base de datos
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name= "Name")
    private String name;
    
    @Column(name= "Enable")
    //LLamado soft delete
    // el boolean iniciado como objeto tiene la posibilidad de ser nulo
    private Boolean enable;

    public Author() {
    }

    public Author(Integer id, String name, Boolean enable) {
        this.id = id;
        this.name = name;
        this.enable = enable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", name=" + name + ", enable=" + enable + '}';
    }

   


   
 
 
}
