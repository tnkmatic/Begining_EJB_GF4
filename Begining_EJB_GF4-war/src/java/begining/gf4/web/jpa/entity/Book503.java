/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.web.jpa.entity;

import begining.gf4.web.common.ConstantValueQuery;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eiichi Tanaka
 */
@Entity
@XmlRootElement
@Table(name = "BOOK503")
@NamedQueries({
    @NamedQuery(
        name  = ConstantValueQuery.NAMED_FIND_ALL_BOOKS503
       ,query = ConstantValueQuery.QUERY_FIND_ALL_BOOKS503),
    @NamedQuery(
        name  = ConstantValueQuery.NAMED_FIND_BOOK503_BY_ISBN
       ,query = ConstantValueQuery.QUERY_FIND_BOOK503_BY_ISBN)
})
public class Book503 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    private Float price;
    @Column(length = 2000)
    private String description;
    private String isbn;
    private Integer nbOfPage;
    private Boolean illustration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNbOfPage() {
        return nbOfPage;
    }

    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }

    public Boolean getIllustration() {
        return illustration;
    }

    public void setIllustration(Boolean illustration) {
        this.illustration = illustration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book503)) {
            return false;
        }
        Book503 other = (Book503) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "begining.gf4.jpa.entity.Book503[ id=" + id + " ]";
    }
    
}
