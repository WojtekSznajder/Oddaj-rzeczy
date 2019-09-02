package pl.coderslab.charity.dao;



import org.springframework.transaction.annotation.Transactional;



import javax.persistence.*;
import java.util.Collection;


@Transactional
public abstract class GenericDao<T> {
    @PersistenceContext
    private EntityManager entityManager;
    private final Class<T> clazz;


    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }


    public Collection<T> findAll() {
        TypedQuery<T> query = entityManager.createQuery(
                String.format("select s FROM %s s", clazz.getSimpleName()), clazz);

        return query.getResultList();
    }




    public void save(T entity) {
        entityManager.persist(entity);


    }

    public T findById(long id) {
        return entityManager.find(clazz, id);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public void delete(long id) {
        entityManager.remove(findById(id));
    }


}