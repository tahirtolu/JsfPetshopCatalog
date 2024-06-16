package dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public abstract class AbstractDAO<T> {

    private Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    public void delete(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        Query query = getEntityManager().createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e");
        return query.getResultList();
    }

    public List<T> findRange(int firstResult, int maxResults) {
        Query query = getEntityManager().createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e");
        query.setMaxResults(maxResults);
        query.setFirstResult(firstResult);
        return query.getResultList();
    }
    public int count() {
        Query query = getEntityManager().createQuery("SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e");
        return ((Long) query.getSingleResult()).intValue();
    }
}