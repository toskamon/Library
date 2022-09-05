package libreria.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

    @Id
    @Column(name = "ISBN")
    private Long isbn;

    @Column(name = "Title")
    private String title;

    @Column(name = "Release_Year")
    private Integer releaseYear;

    @Column(name = "Copies")
    private Integer copies;

    @Column(name = "Borrowed_Copies")
    private Integer borrowedCopies;

    @Column(name = "Remaining_Copies")
    private Integer remainingCopies;

    @Column(name = "Enable")
    private Boolean enable;

    //establecemos las relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Editorial editorial;

    public Book() {
    }

    public Book(Long isbn, String title, Integer releaseYear, Integer copies, Integer borrowedCopies, Integer remainingCopies, Boolean enable, Author author, Editorial editorial) {
        this.isbn = isbn;
        this.title = title;
        this.releaseYear = releaseYear;
        this.copies = copies;
        this.borrowedCopies = borrowedCopies;
        this.remainingCopies = remainingCopies;
        this.enable = enable;
        this.author = author;
        this.editorial = editorial;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Integer getBorrowedCopies() {
        return borrowedCopies;
    }

    public void setBorrowedCopies(Integer borrowedCopies) {
        this.borrowedCopies = borrowedCopies;
    }

    public Integer getRemainingCopies() {
        return remainingCopies;
    }

    public void setRemainingCopies(Integer remainingCopies) {
        this.remainingCopies = remainingCopies;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title=" + title + ", releaseYear=" + releaseYear + ", copies=" + copies + ", borrowedCopies=" + borrowedCopies + ", remainingCopies=" + remainingCopies + ", enable=" + enable + ", author=" + author + ", editorial=" + editorial + '}';
    }

}
