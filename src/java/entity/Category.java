package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Category extends AbstractEntity {

    private String kategoriIsmi;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public String getKategoriIsmi() {
        return kategoriIsmi;
    }

    public void setKategoriIsmi(String kategoriIsmi) {
        this.kategoriIsmi = kategoriIsmi;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.getCategories().add(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.kategoriIsmi);
        hash = 17 * hash + Objects.hashCode(this.products);
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
        Category category = (Category) obj;
        return Objects.equals(kategoriIsmi, category.kategoriIsmi) &&
                Objects.equals(products, category.products);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + getId() +
                ", kategoriIsmi='" + kategoriIsmi + '\'' +
                '}';
    }
}
