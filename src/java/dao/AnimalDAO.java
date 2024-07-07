/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Animal;
import entity.Product;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Administrator
 */
@Local
@Stateless
public class AnimalDAO extends AbstractDAO<Animal> implements Serializable {
	    
    @PersistenceContext(unitName = "JSFPetshopKatalogPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnimalDAO() {
        super(Animal.class);
    }
public List<Animal> findCategoriesWithPagination(int pageNumber, int pageSize) {
        int firstResult = (pageNumber - 1) * pageSize;
        return findRange(firstResult, pageSize);
    }

    public int getCategoryCount() {
        return count();
    }

}
