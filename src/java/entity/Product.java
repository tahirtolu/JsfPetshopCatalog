package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Product extends AbstractEntity {

    private String isim;
    private String marka;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Category> categories;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.isim);
        hash = 17 * hash + Objects.hashCode(this.marka);
        hash = 17 * hash + Objects.hashCode(this.categories);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return Objects.equals(isim, product.isim) &&
                Objects.equals(marka, product.marka) &&
                Objects.equals(categories, product.categories);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                ", isim='" + isim + '\'' +
                ", marka='" + marka + '\'' +
                '}';
    }
}
